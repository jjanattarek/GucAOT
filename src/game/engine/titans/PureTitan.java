package game.engine.titans;

public class PureTitan extends Titan
{
	//super constructor
	public PureTitan(int baseHealth, int baseDamage, int heightInMeters, int distanceFromBase, int speed,int resourcesValue, int dangerLevel) 
	{
	   super(baseHealth, baseDamage, heightInMeters, distanceFromBase, speed, resourcesValue, dangerLevel);
	}

	public int getHeightInMeters() {
		return PureTitan.super.getHeightInMeters();
	}

	public static final int TITAN_CODE = 1;
	
	public int getDangerLevel() 
	{
		return PureTitan.super.getDangerLevel();
	}

	public int getBaseHealth() 
	{
		return PureTitan.super.getBaseHealth();
	}
	
	@Override
	public int getCurrentHealth() 
	{
	  return PureTitan.super.getCurrentHealth();
	}
	@Override
	public void setCurrentHealth(int health) 
	{
	  if(health <= 0)
		  PureTitan.super.setCurrentHealth(0);
	  else
		  PureTitan.super.setCurrentHealth(health);;
	}

	@Override
	public int getDamage() 
	{
		return PureTitan.super.getDamage();
	}

	@Override
	public int getDistance() 
	{
		return PureTitan.super.getDistance();
	}
	@Override
	public void setDistance(int distance)
	{
		if(distance <= 0 )
			PureTitan.super.setDistance(0);
		else
			PureTitan.super.setDistance(distance);
	}

	@Override
	public int getSpeed() 
	{
		return PureTitan.super.getSpeed();
	}
	@Override
	public void setSpeed(int speed) 
	{
		if(speed<=0)
			PureTitan.super.setSpeed(0);
		else
			PureTitan.super.setSpeed(speed);
	}
	@Override
	public int getResourcesValue() 
	{
		return PureTitan.super.getResourcesValue();
	}


}
