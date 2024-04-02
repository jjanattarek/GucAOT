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
	int turnAttack(PriorityQueue<Titan> laneTitans) {
		return 0;
	}

	@Override
	public int attack(Attackee target) {
		return super.attack(target);
	}
}
//