package game.engine.lanes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import game.engine.base.Wall;
import game.engine.titans.*;
import game.engine.weapons.Weapon;

public class Lane implements Comparable<Lane>
{
	private final Wall laneWall;
	private int dangerLevel;
	private final PriorityQueue<Titan> titans;
	private final ArrayList<Weapon> weapons;

	public Lane(Wall laneWall)
	{
		super();
		this.laneWall = laneWall;
		this.dangerLevel = 0;
		this.titans = new PriorityQueue<>(Comparator.comparingInt(Titan::getDistance));
		this.weapons = new ArrayList<>();
	}

	public Wall getLaneWall()
	{
		return this.laneWall;
	}

	public int getDangerLevel()
	{
		return this.dangerLevel;
	}

	public void setDangerLevel(int dangerLevel)
	{
		this.dangerLevel = dangerLevel;
	}

	public PriorityQueue<Titan> getTitans()
	{
		return this.titans;
	}

	public ArrayList<Weapon> getWeapons()
	{
		return this.weapons;
	}

	@Override
	public int compareTo(Lane o)
	{
		return this.dangerLevel - o.dangerLevel;
	}

	public static void main(String[] args) {
		Titan t1 = new AbnormalTitan(2,100,20,60,15,15,2);
		Titan t2 = new PureTitan(1,100,15,30,10,10,1);
		Titan t3 = new ColossalTitan(4,1000,100,15,5,60,4);
		Titan t4 = new ArmoredTitan(3,200,85,10,10,30,3);
		Titan t5 = new ArmoredTitan(3,200,85,9,10,30,3);
		Titan t6 = new ArmoredTitan(3,200,85,5,10,30,3);
		Titan t7 = new ArmoredTitan(3,200,85,1,10,30,3);
		Wall w = new Wall(10000);
		Lane l = new Lane(w);
		l.titans.add(t2);
		l.titans.add(t1);
		l.titans.add(t3);
		l.titans.add(t4);
		l.titans.add(t5);
		l.titans.add(t6);
		l.titans.add(t7);
		System.out.println(l.titans);

	}

}
//