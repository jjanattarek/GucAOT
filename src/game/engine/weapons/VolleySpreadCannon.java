package game.engine.weapons;

public class VolleySpreadCannon extends Weapon {

	public static final int WEAPON_CODE = 3;

	private final int minRange; // This attribute will never be changed once initialized.

	private final int maxRange;// This attribute will never be changed once initialized.

	public int getMinRange() 
	{
		return minRange;
	}

	public int getMaxRange() 
	{
		return maxRange;
	}

	// super constructor
	public VolleySpreadCannon(int baseDamage, final int minRange, final int maxRange) 
	{
		super(baseDamage);
		this.minRange = minRange;
		this.maxRange = maxRange;
	}

	public static int getWeaponCode() 
	{
		return WEAPON_CODE;
	}
}
