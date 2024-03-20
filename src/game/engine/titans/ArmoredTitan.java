package game.engine.titans;

public class ArmoredTitan extends Titan 
{
	public static final int TITAN_CODE = 3;
    
	//superConstructor
	public ArmoredTitan(int baseHealth, int baseDamage, int heightInMeters, int distanceFromBase, int speed,int resourcesValue, int dangerLevel) 
	{
		super(baseHealth, baseDamage, heightInMeters, distanceFromBase, speed, resourcesValue, dangerLevel);
	}

	public int getHeightInMeters() {
		return ArmoredTitan.super.getHeightInMeters();
	}
	
	public int getDangerLevel() 
	{
		return ArmoredTitan.super.getDangerLevel();
	}

	public int getBaseHealth() 
	{
		return ArmoredTitan.super.getBaseHealth();
	}
	
	@Override
	public int getCurrentHealth() 
	{
	  return ArmoredTitan.super.getCurrentHealth();
	}
	@Override
	public void setCurrentHealth(int health) 
	{
	  if(health <= 0)
		  ArmoredTitan.super.setCurrentHealth(0);
	  else
		  ArmoredTitan.super.setCurrentHealth(health);;
	}

	@Override
	public int getDamage() 
	{
		return ArmoredTitan.super.getDamage();
	}

	@Override
	public int getDistance() 
	{
		return ArmoredTitan.super.getDistance();
	}
	@Override
	public void setDistance(int distance)
	{
		if(distance <= 0 )
			ArmoredTitan.super.setDistance(0);
		else
			ArmoredTitan.super.setDistance(distance);
	}

	@Override
	public int getSpeed() 
	{
		return ArmoredTitan.super.getSpeed();
	}
	@Override
	public void setSpeed(int speed) 
	{
		if(speed<=0)
			ArmoredTitan.super.setSpeed(0);
		else
			ArmoredTitan.super.setSpeed(speed);
	}
	@Override
	public int getResourcesValue() 
	{
		return ArmoredTitan.super.getResourcesValue();
	}



}
