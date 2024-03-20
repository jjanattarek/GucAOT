package game.engine.titans;

public class ColossalTitan extends Titan 
{
	public static final int TITAN_CODE = 4;

	//super constructor
	public ColossalTitan(int baseHealth, int baseDamage, int heightInMeters, int distanceFromBase, int speed,int resourcesValue, int dangerLevel)
	{
		super(baseHealth, baseDamage, heightInMeters, distanceFromBase, speed, resourcesValue, dangerLevel);
	}

	public int getHeightInMeters() {
		return ColossalTitan.super.getHeightInMeters();
	}
	
	public int getDangerLevel() 
	{
		return ColossalTitan.super.getDangerLevel();
	}

	public int getBaseHealth() 
	{
		return ColossalTitan.super.getBaseHealth();
	}
	
	@Override
	public int getCurrentHealth() 
	{
	  return ColossalTitan.super.getCurrentHealth();
	}
	@Override
	public void setCurrentHealth(int health) 
	{
	  if(health <= 0)
		  ColossalTitan.super.setCurrentHealth(0);
	  else
		  ColossalTitan.super.setCurrentHealth(health);;
	}

	@Override
	public int getDamage() 
	{
		return ColossalTitan.super.getDamage();
	}

	@Override
	public int getDistance() 
	{
		return ColossalTitan.super.getDistance();
	}
	@Override
	public void setDistance(int distance)
	{
		if(distance <= 0 )
			ColossalTitan.super.setDistance(0);
		else
			ColossalTitan.super.setDistance(distance);
	}

	@Override
	public int getSpeed() 
	{
		return ColossalTitan.super.getSpeed();
	}
	@Override
	public void setSpeed(int speed) 
	{
		if(speed<=0)
			ColossalTitan.super.setSpeed(0);
		else
			ColossalTitan.super.setSpeed(speed);
	}
	@Override
	public int getResourcesValue() 
	{
		return ColossalTitan.super.getResourcesValue();
	}





}
