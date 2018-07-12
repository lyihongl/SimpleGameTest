package com.tycoon.gfx;

import com.tycoon.entity.Creature;
import com.tycoon.entity.Entity;
import com.tycoon.util.Handler;

public class GameCamera {//allows a certain part of the game to be displayed

	private float xOffset, yOffset;
	private Handler h;

	public GameCamera(Handler h) {
		this.h = h;
	}
	
	//centers on Entity e
	public void centerOnEntity(Entity e) {
		xOffset = e.getX() - h.getGame().getWidth() / 2 + Creature.SIZE / 2;
		yOffset = e.getY() - h.getGame().getHeight() / 2 + Creature.SIZE / 2;
	}
	public float getXOffset(){
		return xOffset;
	}
	public float getYOffset(){
		return yOffset;
	}
}
