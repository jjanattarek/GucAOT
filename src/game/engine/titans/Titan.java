package game.engine.titans;
import game.engine.interfaces.*;
public abstract class Titan implements Comparable<Titan>,Attackee,Attacker,Mobil
{ 
	private final int baseHealth;
	
	private int currentHealth;
	
	private final int baseDamage; 
	
    private final int heightInMeters; 
	
	private int distanceFromBase;
	
	private int speed; // distance moved per turn

	private final int resourcesValue; // resources gained on kill
	
	private final int dangerLevel;

	public int getHeightInMeters() {
		return heightInMeters;
	}
	
	public int getDangerLevel() 
	{
		return dangerLevel;
	}

	public int getBaseHealth() 
	{
		return baseHealth;
	}
	
	@Override
	public int getCurrentHealth() 
	{
	  return currentHealth;
	}
	@Override
	public void setCurrentHealth(int health) 
	{
        this.currentHealth = Math.max(health, 0);
	}

	@Override
	public int getDamage() 
	{
		return baseDamage;
	}

	@Override
	public int getDistance() 
	{
		return distanceFromBase;
	}
	@Override
	public void setDistance(int distance)
	{
        this.distanceFromBase = Math.max(distance, 0);
	}

	@Override
	public int getSpeed() 
	{
		return speed;
	}
	@Override
	public void setSpeed(int speed) 
	{
		this.speed = Math.max(speed,0);
	}
	@Override
	public int getResourcesValue() 
	{
		return resourcesValue;
	}
	//constructor
	public Titan(int baseHealth,  int baseDamage,  int heightInMeters, int distanceFromBase, int speed, int resourcesValue,  int dangerLevel)
	{
		super();
	    this.currentHealth = baseHealth;
		this.baseHealth = baseHealth;
		this.baseDamage = baseDamage;
		this.heightInMeters = heightInMeters;
		this.distanceFromBase = distanceFromBase;
		this.speed = speed;
		this.resourcesValue = resourcesValue;
		this.dangerLevel = dangerLevel;
	}


	// prioritizing the nearest titans according to the wall
	@Override
	public int compareTo(Titan o) 
	{
		return this.distanceFromBase - o.distanceFromBase;
	}
	@Override
	public String toString() 
	{
		return "this titans danger level is "+ dangerLevel;
	}

	
	
}
