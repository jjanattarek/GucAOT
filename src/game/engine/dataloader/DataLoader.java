package game.engine.dataloader;
import java.io.IOException;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import game.engine.titans.*;
import game.engine.weapons.*;

public class DataLoader
{
	private static final String TITANS_FILE_NAME = "titans.csv";
	private static final String WEAPONS_FILE_NAME = "weapons.csv" ;
	
	public static String getTITANS_FILE_NAME() {
		return TITANS_FILE_NAME;
	}
	public static String getWEAPONS_FILE_NAME() {
		return WEAPONS_FILE_NAME;
	}
	public static HashMap<Integer ,TitanRegistry> readTitanRegistry() throws IOException
	{
		HashMap<Integer,TitanRegistry> info = new HashMap<Integer,TitanRegistry>();
		BufferedReader br = new BufferedReader(new FileReader(TITANS_FILE_NAME));
		String line = br.readLine();
		
		while(line != null) 
		{
			String[] sp = line.split(",");
			TitanRegistry t = new TitanRegistry(Integer.parseInt(sp[0]),Integer.parseInt(sp[1]),Integer.parseInt(sp[2]),Integer.parseInt(sp[3]),Integer.parseInt(sp[4]),Integer.parseInt(sp[5]),Integer.parseInt(sp[6]));
		    info.put(Integer.parseInt(sp[0]), t); 
			line = br.readLine();
		}
		br.close();
		
		return info;
	}

	public static HashMap<Integer ,WeaponRegistry> readWeaponRegistry() throws IOException
	{
		HashMap<Integer,WeaponRegistry> info = new HashMap<Integer,WeaponRegistry>();
		BufferedReader br = new BufferedReader(new FileReader(WEAPONS_FILE_NAME));
		String line = br.readLine();
		while(line != null) {
			String[] sp = line.split(",");
			WeaponRegistry w;
			if(sp.length >=6){
				w = new WeaponRegistry(Integer.parseInt(sp[0]),Integer.parseInt(sp[1]),Integer.parseInt(sp[2]),sp[3],Integer.parseInt(sp[4]),Integer.parseInt(sp[5]));
				info.put(Integer.parseInt(sp[0]),w);
			}
			else {
				w = new WeaponRegistry(Integer.parseInt(sp[0]),Integer.parseInt(sp[1]),Integer.parseInt(sp[2]),sp[3]);
				info.put(Integer.parseInt(sp[0]),w);
			}
			
			line = br.readLine();
		}
		br.close();
		return info;
	}

	

	
}
