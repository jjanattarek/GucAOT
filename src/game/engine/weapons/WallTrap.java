package game.engine.weapons;

public class WallTrap extends Weapon{

	public static final int WEAPON_CODE = 4;
	
	//super constructor
	public WallTrap(int baseDamage) 
	{
		super(baseDamage);
	}

	public static int getWeaponCode() {
		return WEAPON_CODE;
	}
}
