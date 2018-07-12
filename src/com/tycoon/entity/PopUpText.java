package com.tycoon.entity;

import java.awt.Color;
import java.awt.Graphics2D;

import com.tycoon.tiles.Tile;
import com.tycoon.util.Handler;

public class PopUpText extends StaticEntity {
	
	//text that is displayed
	private String popUpText;
	
	//width that the background box needs to be
	private int sWidth;
	
	//num of ticks that the text will be on screen for
	public static final int TICK_TIME = 120;
	
	//current num of ticks text has been on screen for
	private int currentTicks = 0;
	
	//for the fade effect
	private int alpha = 255;

	public PopUpText(Handler h, float x, float y, String s) {
		super(h, x, y);
		this.popUpText = s;
	}
	
	public void setY(int y){
		this.y = y;
	}

	@Override
	public void intersectAction() {

	}

	@Override
	public void onHitAction() {

	}

	@Override
	public void tick() {
		//fading the text
		currentTicks++;
		if (currentTicks >= 30) {
			if (alpha > 0)
				alpha -= 255.0/90;
		}
		if (currentTicks >= TICK_TIME) {
			h.getEm().getSEntity().remove(this);
		}
	}

	@Override
	public boolean isSolid() {
		return false;
	}

	@Override
	public void render(Graphics2D g2d) {
		sWidth = g2d.getFontMetrics().stringWidth(popUpText);
		Color DGA = new Color(64, 64, 64, alpha);
		Color WA = new Color(255, 255, 255, alpha);
		g2d.setColor(DGA);
		g2d.fillRect((int) x / Tile.SIZE - sWidth / 2 - 2, (int) y / Tile.SIZE - 17, sWidth + 4, 22);
		g2d.setColor(WA);
		g2d.drawString(popUpText, x / Tile.SIZE - sWidth / 2, y / Tile.SIZE);
	}

}
