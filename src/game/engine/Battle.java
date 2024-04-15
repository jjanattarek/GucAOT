package game.engine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

import game.engine.base.Wall;
import game.engine.dataloader.DataLoader;
import game.engine.exceptions.InsufficientResourcesException;
import game.engine.exceptions.InvalidLaneException;
import game.engine.lanes.Lane;
import game.engine.titans.Titan;
import game.engine.titans.TitanRegistry;
import game.engine.weapons.factory.FactoryResponse;
import game.engine.weapons.factory.WeaponFactory;

import static game.engine.dataloader.DataLoader.readTitanRegistry;

public class Battle
{
	private static final int[][] PHASES_APPROACHING_TITANS =
	{
		{ 1, 1, 1, 2, 1, 3, 4 },
		{ 2, 2, 2, 1, 3, 3, 4 },
		{ 4, 4, 4, 4, 4, 4, 4 } 
	}; // order of the types of titans (codes) during each phase
	private static final int WALL_BASE_HEALTH = 10000;

	private int numberOfTurns;
	private int resourcesGathered;
	private BattlePhase battlePhase;
	private int numberOfTitansPerTurn; // initially equals to 1
	private int score; // Number of Enemies Killed
	private int titanSpawnDistance;
	private final WeaponFactory weaponFactory;
	private final HashMap<Integer, TitanRegistry> titansArchives;
	private final ArrayList<Titan> approachingTitans; // treated as a Queue
	private final PriorityQueue<Lane> lanes; //from least to highest danger level according to compareTo of Lanes.
	private final ArrayList<Lane> originalLanes;

	public Battle(int numberOfTurns, int score, int titanSpawnDistance, int initialNumOfLanes,
			int initialResourcesPerLane) throws IOException
	{
		super();
		this.numberOfTurns = numberOfTurns;
		this.battlePhase = BattlePhase.EARLY;
		this.numberOfTitansPerTurn = 1;
		this.score = score;
		this.titanSpawnDistance = titanSpawnDistance;
		this.resourcesGathered = initialResourcesPerLane * initialNumOfLanes;
		this.weaponFactory = new WeaponFactory();
		this.titansArchives = readTitanRegistry();
		this.approachingTitans = new ArrayList<Titan>();
		this.lanes = new PriorityQueue<>();
		this.originalLanes = new ArrayList<>();
		this.initializeLanes(initialNumOfLanes);
	}

	public int getNumberOfTurns()
	{
		return numberOfTurns;
	}

	public void setNumberOfTurns(int numberOfTurns)
	{
		this.numberOfTurns = numberOfTurns;
	}

	public int getResourcesGathered()
	{
		return resourcesGathered;
	}

	public void setResourcesGathered(int resourcesGathered)
	{
		this.resourcesGathered = resourcesGathered;
	}

	public BattlePhase getBattlePhase()
	{
		return battlePhase;
	}

	public void setBattlePhase(BattlePhase battlePhase)
	{
		this.battlePhase = battlePhase;
	}

	public int getNumberOfTitansPerTurn()
	{
		return numberOfTitansPerTurn;
	}

	public void setNumberOfTitansPerTurn(int numberOfTitansPerTurn)
	{
		this.numberOfTitansPerTurn = numberOfTitansPerTurn;
	}

	public int getScore()
	{
		return score;
	}

	public void setScore(int score)
	{
		this.score = score;
	}

	public int getTitanSpawnDistance()
	{
		return titanSpawnDistance;
	}

	public void setTitanSpawnDistance(int titanSpawnDistance)
	{
		this.titanSpawnDistance = titanSpawnDistance;
	}

	public WeaponFactory getWeaponFactory()
	{
		return weaponFactory;
	}

	public HashMap<Integer, TitanRegistry> getTitansArchives()
	{
		return titansArchives;
	}

	public ArrayList<Titan> getApproachingTitans()
	{
		return approachingTitans;
	}

	public PriorityQueue<Lane> getLanes()
	{
		return lanes;
	}

	public ArrayList<Lane> getOriginalLanes()
	{
		return originalLanes;
	}

	private void initializeLanes(int numOfLanes)
	{
		for (int i = 0; i < numOfLanes; i++)
		{
			Wall w = new Wall(WALL_BASE_HEALTH);
			Lane l = new Lane(w);

			this.getOriginalLanes().add(l);
			this.getLanes().add(l);
		}
	}

	public void refillApproachingTitans() throws IOException {
		// we want to only read the first row (first list) if the battlephase is early and so on.
		int row;
		if(battlePhase == BattlePhase.EARLY){
			row = 0;
		}
		else if(battlePhase == BattlePhase.INTENSE){
			row = 1;
		}
		else {
			row = 2;
		}

		// read from titan registry hatly el titan that has this code
		HashMap<Integer, TitanRegistry> a = readTitanRegistry();
		for(int i = 0; i<7;i++){
			TitanRegistry TitanR = a.get(PHASES_APPROACHING_TITANS[row][i]);
			approachingTitans.add(TitanR.spawnTitan(getTitanSpawnDistance()));
			// I FOUND IT EZ, feeh attribute esmo titan spawn distance wana ely 3abat w mashoftosh.
		}
	}

	public void purchaseWeapon(int weaponCode, Lane lane) throws InsufficientResourcesException, InvalidLaneException, IOException {
		// hastakhdem the buyweapon method I made fe weaponfactory to purchase it
		FactoryResponse f = weaponFactory.buyWeapon(resourcesGathered, weaponCode);
		if(!lane.isLaneLost()){
			lane.addWeapon(f.getWeapon());
		}
		else{
			throw new InvalidLaneException();
		}
		setResourcesGathered(f.getRemainingResources());
		performTurn();
		//hwa bey2ool rest of turn actions should complete after that and idk what that means ngl.
	}
	public void passTurn() throws IOException {
		performTurn();
	}


	private void addTurnTitansToLane() throws IOException {
		for (int i = 0; i<numberOfTitansPerTurn;i++){
			if(approachingTitans.isEmpty()){
				refillApproachingTitans();
			}
			Lane LeastDangerousLane = lanes.remove();
			LeastDangerousLane.addTitan(approachingTitans.remove(0));
			lanes.add(LeastDangerousLane);
		}
	}

	private void moveTitans(){
		PriorityQueue<Lane> temp = new PriorityQueue<>();
		while(!lanes.isEmpty()){
			Lane L = lanes.remove();
			temp.add(L);
			if(!L.isLaneLost()){
				L.moveLaneTitans();
				}
			}
		while(!temp.isEmpty()){
			lanes.add(temp.remove());
		}
	}

	private int performWeaponsAttacks(){
		PriorityQueue<Lane> temp = new PriorityQueue<>();
		int resourceSum = 0;
		while(!lanes.isEmpty()){
			Lane L = lanes.remove();
			temp.add(L);
			if(!L.isLaneLost()){
				int a = L.performLaneWeaponsAttacks();
				resourceSum+=a;
			}
		}
		while(!temp.isEmpty()){
			lanes.add(temp.remove());
		}
		return resourceSum;
	}

	private int performTitansAttacks(){
		PriorityQueue<Lane> temp = new PriorityQueue<>();
		int resourceSum = 0;
		while(!lanes.isEmpty()){
			Lane L = lanes.remove();
			temp.add(L);
			if(!L.isLaneLost()){
				int a = L.performLaneTitansAttacks();
				resourceSum+=a;
			}
		}
		while(!temp.isEmpty()){
			lanes.add(temp.remove());
		}
		return resourceSum;
	}

	private void updateLanesDangerLevels(){
		PriorityQueue<Lane> temp = new PriorityQueue<>();
		while(!lanes.isEmpty()){
			Lane L = lanes.remove();
			temp.add(L);
			if(!L.isLaneLost()){
				L.updateLaneDangerLevel();
			}
		}
		while(!temp.isEmpty()){
			lanes.add(temp.remove());
		}
	}
	private void performTurn() throws IOException {
		moveTitans();
		int x = performWeaponsAttacks();
		int y = performTitansAttacks();
		addTurnTitansToLane();
		finalizeTurns();
		this.setResourcesGathered(this.getResourcesGathered()+x+y);
	}


	private void finalizeTurns(){
		numberOfTurns++;

		if(numberOfTurns<15){
			BattlePhase b = BattlePhase.EARLY;
			setBattlePhase(b);
		}
		else if(numberOfTurns>15 && numberOfTurns<30){
			BattlePhase b = BattlePhase.INTENSE;
			setBattlePhase(b);
		}
		else if(numberOfTurns>=30 && numberOfTurns%5!=0){
			BattlePhase b = BattlePhase.GRUMBLING;
			setBattlePhase(b);
		}
		else if(numberOfTurns>=30 && numberOfTurns%5==0){
			BattlePhase b = BattlePhase.GRUMBLING;
			setBattlePhase(b);

			setNumberOfTitansPerTurn(2*getNumberOfTitansPerTurn());
		}
	}

	boolean isGameOver(){
		PriorityQueue<Lane> temp = new PriorityQueue<>();
		while(!lanes.isEmpty()){
			Lane L = lanes.remove();
			temp.add(L);
			if(!L.isLaneLost()){
				return false;
			}
		}
		while(!temp.isEmpty()){
			lanes.add(temp.remove());
	}
		return true;
	}

	public static void main(String[] args) {

	}

}
//