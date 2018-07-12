package com.tycoon.item.equipment.weapon;

import java.awt.Graphics2D;

import com.tycoon.gfx.Assets;
import com.tycoon.item.equipment.Weapon;
import com.tycoon.util.Handler;

public class LongSword extends Weapon{
	
	public static final int DAMAGE = 20;
	
	public LongSword(Handler h, float x, float y) {
		super(h, x, y, DAMAGE);
		name = "Long Sword";
	}

	@Override
	public void render(Graphics2D g2d) {
		g2d.drawImage(Assets.longSword, (int)(x-h.getGame().getGC().getXOffset()), (int)(y-h.getGame().getGC().getYOffset()), width, height, null);
	}

	@Override
	public void onHitAction() {
		
	}

	@Override
	public boolean isSolid() {
		// TODO Auto-generated method stub
		return false;
	}

}
