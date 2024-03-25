package game.engine.weapons.factory;

import java.io.IOException;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;

import game.engine.weapons.WeaponRegistry;

public class WeaponFactory 
{
	private final HashMap<Integer,WeaponRegistry> weaponShop = new HashMap<Integer,WeaponRegistry>();

    public final HashMap<Integer, WeaponRegistry> getWeaponShop()
    {
		return weaponShop;
	}
    
    public WeaponFactory() throws IOException 
	{
    	BufferedReader br = new BufferedReader(new FileReader("weapons.csv"));
		String line = br.readLine();
		while(line != null) {
			String[] sp = line.split(",");
			WeaponRegistry w;
			w = new WeaponRegistry(Integer.parseInt(sp[0]),Integer.parseInt(sp[1]));
			weaponShop.put(Integer.parseInt(sp[0]),w);
			line = br.readLine();
		}
		br.close();
	}
   	
}
