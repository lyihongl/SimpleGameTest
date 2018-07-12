package com.tycoon.gfx.overlay;

import java.awt.Graphics2D;

import com.tycoon.util.Handler;

public abstract class Menus {//parent menu for all classes

	protected int pointerLocation = 0;
	
	protected int gridSpacing = 20;
	
	protected Handler h;
	
	protected String title;
	
	public Menus(Handler h) {
		this.h = h;
	}

	public abstract void tick();

	public abstract void render(Graphics2D g2d);

}
