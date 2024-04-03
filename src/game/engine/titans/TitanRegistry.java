package game.engine.titans;
public class TitanRegistry // For storing the titan's information from the csv file read in the data loader
{
	private final int code;
	private int baseHealth;
	private int baseDamage;
	private int heightInMeters;
	private int speed; // distance moved per turn
	private int resourcesValue; // resources gained by defeating it
	private int dangerLevel;


	public TitanRegistry(int code, int baseHealth, int baseDamage, int heightInMeters, int speed, int resourcesValue,
			int dangerLevel)
	{
		super();
		this.code = code;
		this.baseHealth = baseHealth;
		this.baseDamage = baseDamage;
		this.heightInMeters = heightInMeters;
		this.speed = speed;
		this.resourcesValue = resourcesValue;
		this.dangerLevel = dangerLevel;
	}

	public int getCode()
	{
		return code;
	}

	public int getBaseHealth()
	{
		return baseHealth;
	}

	public int getBaseDamage()
	{
		return baseDamage;
	}

	public int getHeightInMeters()
	{
		return heightInMeters;
	}

	public int getSpeed()
	{
		return speed;
	}

	public int getResourcesValue()
	{
		return resourcesValue;
	}

	public int getDangerLevel()
	{
		return dangerLevel;
	}

	public Titan spawnTitan(int distanceFromBase) {
		if (this.code == 1){
            return new PureTitan(100,15,15,distanceFromBase,10,10,1);
		}
		else if (this.code == 2){
            return new AbnormalTitan(100,20,10,distanceFromBase,15,15,2);
		}
		else if (this.code == 3){
            return new ArmoredTitan(200,85,15,distanceFromBase,10,30,3);
		}
		else{
            return new ColossalTitan(1000,100,60,distanceFromBase,5,60,4);
		}
	}

	public static void main(String[] args) {
	}
}