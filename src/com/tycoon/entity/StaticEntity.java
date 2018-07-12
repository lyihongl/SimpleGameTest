package com.tycoon.entity;

import com.tycoon.tiles.Tile;
import com.tycoon.util.Handler;

public abstract class StaticEntity extends Entity{
	
	//an entity that will not move
	
	protected int health = 10;
	public static final int SIZE = 32;

	
	public StaticEntity(Handler h, float x, float y) {
		super(h, x*Tile.SIZE, y*Tile.SIZE, SIZE, SIZE);
	}
	
	

	public int getTileX() {
		return (int) x / Tile.SIZE;
	}

	public int getTileY() {
		return (int) y / Tile.SIZE;
	}
	
	public abstract void intersectAction();
	
	public abstract void onHitAction();
}
