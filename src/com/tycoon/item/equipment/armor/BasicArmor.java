package com.tycoon.item.equipment.armor;

import java.awt.Graphics2D;

import com.tycoon.gfx.Assets;
import com.tycoon.item.equipment.Armor;
import com.tycoon.util.Handler;

public class BasicArmor extends Armor {

	public static final int ARMOR = 5;

	public BasicArmor(Handler h, float x, float y) {
		super(h, x, y, ARMOR);
		name = "Basic Armor";
	}

	@Override
	public void render(Graphics2D g2d) {
		g2d.drawImage(Assets.basicArmor, (int)(x-h.getGame().getGC().getXOffset()), (int)(y-h.getGame().getGC().getYOffset()), width, height, null);
	}

	@Override
	public void onHitAction() {

	}

	@Override
	public boolean isSolid() {
		return false;
	}

}
