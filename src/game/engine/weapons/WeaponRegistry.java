package game.engine.weapons;

public class WeaponRegistry 
{
	private final int code;
	private int price;
	private int damage;
	private int minRange;
	private int maxRange;
	private String name;
	
	public int getCode() {
		return code;
	}
	public int getPrice() {
		return price;
	}
	public int getDamage() {
		return damage;
	}
	public int getMinRange() {
		return minRange;
	}
	public int getMaxRange() {
		return maxRange;
	}
	public String getName() {
		return name;
	}
	public WeaponRegistry(int code, int price) 
	{
		this.code = code;
		this.price = price;
	}
	public WeaponRegistry(int code, int price, int damage, String name) 
	{
		this.code = code;
		this.price = price;
		this.damage = damage;
		this.name = name;
	}
	public WeaponRegistry( int code, int price, int damage,String name, int minRange, int maxRange) 
	{
		this.code = code;
		this.price = price;
		this.damage = damage;
		this.minRange = minRange;
		this.maxRange = maxRange;
		this.name = name;
	}

	
	
	
}
