package com.tycoon.entity;

import java.util.ArrayList;

import com.tycoon.tiles.Tile;

public class EntityManager {
	
	//manager that helps with all the entities
	
	//static entities
	private ArrayList<StaticEntity> sEntity;
	//creatures
	private ArrayList<Creature> creature;

	public EntityManager() {
		sEntity = new ArrayList<StaticEntity>();
		creature = new ArrayList<Creature>();
	}
	
	//add something to the static entities
	public void sEntityAdd(StaticEntity e) {
		for(int i = 0; i<sEntity.size(); i++){
			Object o = sEntity.get(i);
			if(o instanceof PopUpText && e instanceof PopUpText){
				sEntity.remove(o);
				System.out.println("removed");
			}
		}
		sEntity.add(e);
	}
	//add creature
	public void creatureAdd(Creature c) {
		creature.add(c);
	}
	
	public ArrayList<Creature> getCreature() {
		return creature;
	}
	
	//get creature at specific location
	public Creature getCreatureAt(int x, int y) {
		for (Creature c : creature) {
			if (c.currentTileX() == x && c.currentTileY() == y) {
				return c;
			}
		}
		return null;
	}
	
	//remove creature
	public void removeC(Creature c){
		creature.remove(c);
	}
	
	public ArrayList<StaticEntity> getSEntity() {
		return sEntity;
	}
	//get static entity at specific location
	public StaticEntity getSEntityAt(int x, int y) {
		for (StaticEntity e : sEntity) {
			if (e.getTileX() == x && e.getTileY() == y)
				return e;
		}
		return null;
	}
}
