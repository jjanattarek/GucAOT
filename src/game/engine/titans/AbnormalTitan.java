package game.engine.titans;

import game.engine.interfaces.Attackee;

public class AbnormalTitan extends Titan
{
	public static final int TITAN_CODE = 2;

	public AbnormalTitan(int baseHealth, int baseDamage, int heightInMeters, int distanceFromBase, int speed,
			int resourcesValue, int dangerLevel)
	{
		super(baseHealth, baseDamage, heightInMeters, distanceFromBase, speed, resourcesValue, dangerLevel);
	}


	@Override
	public int attack(Attackee target) { //abnormal titan attacks twice but that's given that the first hit didn't kill the target
		int x = target.takeDamage(this.getDamage()); // attack once and store it in x
		if(x==0){
			return target.takeDamage(this.getDamage()); // if x is zero, target isn't dead yet so attack again
		}
		else{
			return x; // else just return x
		}
	}

}
//