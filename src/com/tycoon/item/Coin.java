package com.tycoon.item;

import java.awt.Graphics2D;

import com.tycoon.gfx.Assets;
import com.tycoon.util.Handler;

//coin item, sub class of item
public class Coin extends Item {
	
	public Coin(Handler h, float x, float y) {
		super(h, x, y);
		ID = 0;
		name = "Coin";
	}

	@Override
	public void render(Graphics2D g2d) {
		g2d.drawImage(Assets.coin, (int) x-(int)h.getGame().getGC().getXOffset(), (int) y-(int)h.getGame().getGC().getYOffset(), width, height, null);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	public void onHitAction() {

	}

	@Override
	public boolean isSolid() {
		return false;
	}

	

}
