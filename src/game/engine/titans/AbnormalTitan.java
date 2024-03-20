package game.engine.titans;

public class AbnormalTitan extends Titan 
{
	
	public static final int TITAN_CODE = 2;

	//super constructor
	public AbnormalTitan(int baseHealth, int baseDamage, int heightInMeters, int distanceFromBase, int speed,int resourcesValue, int dangerLevel) 
	{
		super(baseHealth, baseDamage, heightInMeters, distanceFromBase, speed, resourcesValue, dangerLevel);
	}

	public int getHeightInMeters() {
		return AbnormalTitan.super.getHeightInMeters();
	}
	
	public int getDangerLevel() 
	{
		return AbnormalTitan.super.getDangerLevel();
	}

	public int getBaseHealth() 
	{
		return AbnormalTitan.super.getBaseHealth();
	}
	
	@Override
	public int getCurrentHealth() 
	{
	  return AbnormalTitan.super.getCurrentHealth();
	}
	@Override
	public void setCurrentHealth(int health) 
	{
	  if(health <= 0)
		  AbnormalTitan.super.setCurrentHealth(0);
	  else
		  AbnormalTitan.super.setCurrentHealth(health);;
	}

	@Override
	public int getDamage() 
	{
		return AbnormalTitan.super.getDamage();
	}

	@Override
	public int getDistance() 
	{
		return AbnormalTitan.super.getDistance();
	}
	@Override
	public void setDistance(int distance)
	{
		if(distance <= 0 )
			AbnormalTitan.super.setDistance(0);
		else
			AbnormalTitan.super.setDistance(distance);
	}

	@Override
	public int getSpeed() 
	{
		return AbnormalTitan.super.getSpeed();
	}
	@Override
	public void setSpeed(int speed) 
	{
		if(speed<=0)
			AbnormalTitan.super.setSpeed(0);
		else
			AbnormalTitan.super.setSpeed(speed);
	}
	@Override
	public int getResourcesValue() 
	{
		return AbnormalTitan.super.getResourcesValue();
	}



}
