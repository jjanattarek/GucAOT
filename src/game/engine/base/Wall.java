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
	    if (health < 0) 
	    {
	        this.currentHealth = 0;
	    } 
	    else if (this.currentHealth <= 0 && health > baseHealth) 
	    {
	        this.currentHealth = baseHealth;
	    } 
	    else 
	    {
	        this.currentHealth = health;
	    }
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
