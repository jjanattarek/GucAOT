package game.engine.lanes;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import game.engine.base.Wall;
import game.engine.titans.*;
import game.engine.weapons.*;

public class Lane implements Comparable<Lane>
{
	private final Wall laneWall; 

	private int dangerLevel;
	
    private final PriorityQueue<Titan> titans;
	
	private final ArrayList<Weapon> weapons;

	public int getDangerLevel() 
	{
		return dangerLevel;
	}

	public void setDangerLevel(int dangerLevel)
	{
		this.dangerLevel = dangerLevel;
	}

	public Lane(Wall laneWall) {
        this.laneWall = laneWall;
        this.titans = new PriorityQueue<>();
        this.weapons = new ArrayList<>();
    }

	@Override
	public int compareTo(Lane o) {
		return this.dangerLevel - o.dangerLevel;
	}
	
	public Wall getLaneWall() {
		return laneWall;
	}

	public PriorityQueue<Titan> getTitans() {
		return titans;
	}

	public ArrayList<Weapon> getWeapons() {
		return weapons;
	}

}
