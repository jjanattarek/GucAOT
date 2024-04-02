package game.engine.weapons;

import game.engine.titans.Titan;

import java.util.PriorityQueue;

public class SniperCannon extends Weapon
{
	public static final int WEAPON_CODE = 2;

	public SniperCannon(int baseDamage)
	{
		super(baseDamage);
	}

	@Override
	int turnAttack(PriorityQueue<Titan> laneTitans) {
		Titan x = laneTitans.remove();
		int y = attack(x);
		if(y == 0){ //only return him into the queue if he's still alive
			laneTitans.add(x);
		}
		return y;
	}

}
//