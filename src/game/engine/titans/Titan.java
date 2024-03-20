package game.engine.titans;
import game.engine.interfaces.*;
public abstract class Titan implements Comparable<Titan>,Attackee,Attacker,Mobil
{ 
	private final int baseHealth;
	
	private int currentHealth;
	
	private final int baseDamage; 
	
    private final int heightInMeters; 
	
	private int distanceFromBase;
	
	private int speed;

	private final int resourcesValue;
	
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
	  if(health <= 0)
		  this.currentHealth = 0;
	  else
		  this.currentHealth = health;
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
		if(distance <= 0 )
		this.distanceFromBase = 0;
		else
			this.distanceFromBase = distance;
	}

	@Override
	public int getSpeed() 
	{
		return speed;
	}
	@Override
	public void setSpeed(int speed) 
	{
		if(speed<=0)
		this.speed = 0;
		else
			this.speed = speed;
	}
	@Override
	public int getResourcesValue() 
	{
		return resourcesValue;
	}
	//constructor
	public Titan(int baseHealth,  int baseDamage,  int heightInMeters, int distanceFromBase, int speed, int resourcesValue,  int dangerLevel)
	{
	    this.currentHealth = baseHealth;
		this.baseHealth = baseHealth;
		this.baseDamage = baseDamage;
		this.heightInMeters = heightInMeters;
		this.distanceFromBase = distanceFromBase;
		this.speed = speed;
		this.resourcesValue = resourcesValue;
		this.dangerLevel = dangerLevel;
	}


	//e compareTo method to order titans based on their distance from the base/wall.
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
