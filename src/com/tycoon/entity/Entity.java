package com.tycoon.entity;

import java.awt.Graphics2D;
import java.util.Scanner;

import com.tycoon.util.Handler;

public abstract class Entity {// parent class of all entities
	
	protected float x, y;
	protected int width, height;
	protected Handler h;

	public Entity(Handler h, float x, float y, int width, int height) {
		this.h = h;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public abstract void tick();

	public abstract boolean isSolid();

	public abstract void render(Graphics2D g2d);

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

}
