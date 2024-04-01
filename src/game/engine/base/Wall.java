package game.engine.base;

import game.engine.interfaces.Attackee;

public class Wall implements Attackee
{
	private final int baseHealth; 
	
	private int currentHealth;

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
	public void setCurrentHealth(int health) {
	    this.currentHealth = Math.max(health,0);
	}

	public Wall(int baseHealth) 
	{
		this.baseHealth = baseHealth;
		this.currentHealth = baseHealth;
	}

	@Override
	public int getResourcesValue() {
		return -1;
	}
	
}
