package game.engine.weapons;

import game.engine.interfaces.Attacker;

public abstract class Weapon implements Attacker
{
	private final int baseDamage; 
	
	@Override
	public int getDamage() 
	{   
		return baseDamage;
	}
	public Weapon(int baseDamage) 
	{
		this.baseDamage = baseDamage;
	}
}