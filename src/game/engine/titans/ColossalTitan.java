package game.engine.titans;

public class ColossalTitan extends Titan
{
	public static final int TITAN_CODE = 4;

	public ColossalTitan(int baseHealth, int baseDamage, int heightInMeters, int distanceFromBase, int speed,
			int resourcesValue, int dangerLevel)
	{
		super(baseHealth, baseDamage, heightInMeters, distanceFromBase, speed, resourcesValue, dangerLevel);
	}

	//adjusted this
	@Override
	public boolean move() {
		this.setDistance(this.getDistance() - this.getSpeed());
		this.setSpeed(this.getSpeed() + 1);
		return this.hasReachedTarget();
	}
}
