package game.engine.weapons;

import game.engine.interfaces.Attackee;
import game.engine.titans.Titan;

import java.util.PriorityQueue;

public class PiercingCannon extends Weapon
{
	public static final int WEAPON_CODE = 1;

	public PiercingCannon(int baseDamage)
	{
		super(baseDamage);
	}

	@Override
	public int turnAttack(PriorityQueue<Titan> laneTitans) {
		int resourcesum = 0;
		PriorityQueue<Titan> temp = new PriorityQueue<>();
		for(int i = 0; i<5;i++){
			Titan x = laneTitans.remove();
			int y = attack(x); //remove a titan then attack it and store the value of resources gained.
			resourcesum+=y;
			if(y==0){ //put him in temp queue if he's not dead yet.
				temp.add(x);
			}
		}
		while(!temp.isEmpty()){ //restore them all into queue again./
			laneTitans.add(temp.remove());
		}
		return resourcesum;
	}

	@Override
	public int attack(Attackee target) {
		return super.attack(target);
	}
}
//