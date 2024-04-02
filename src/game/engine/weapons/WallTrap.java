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
	int turnAttack(PriorityQueue<Titan> laneTitans) {
		return 0;
	}

	@Override
	public int attack(Attackee target) {
		return super.attack(target);
	}
}
//