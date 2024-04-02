package game.engine.weapons;

import game.engine.interfaces.Attackee;
import game.engine.titans.Titan;

import java.util.PriorityQueue;

public class VolleySpreadCannon extends Weapon
{
	public static final int WEAPON_CODE = 3;

	private final int minRange;
	private final int maxRange;

	public VolleySpreadCannon(int baseDamage, int minRange, int maxRange)
	{
		super(baseDamage);
		this.minRange = minRange;
		this.maxRange = maxRange;
	}

	public int getMinRange()
	{
		return minRange;
	}

	public int getMaxRange()
	{
		return maxRange;
	}

	@Override
	public int attack(Attackee target) {
		return super.attack(target);
	}

	@Override
	public int turnAttack(PriorityQueue<Titan> laneTitans) {
		int resourcesum = 0;
		PriorityQueue<Titan> temp = new PriorityQueue<>();
		for(int i = this.getMinRange(); i<this.getMaxRange();i++){
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
}
//