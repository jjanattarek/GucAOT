package game.engine.weapons;

import game.engine.interfaces.Attackee;
import game.engine.titans.Titan;

import java.util.PriorityQueue;

public class WallTrap extends Weapon
{
	public static final int WEAPON_CODE = 4;

	public WallTrap(int baseDamage)
	{
		super(baseDamage);
	}

	@Override
	public int turnAttack(PriorityQueue<Titan> laneTitans) {
		Titan x = laneTitans.remove();
		int y = 0;
		if(x.getDistance()<=0){
			y = attack(x);
			if(y == 0){ //only return him into the queue if he's still alive
				laneTitans.add(x);
			}
		}
		return y;
	}

}
//