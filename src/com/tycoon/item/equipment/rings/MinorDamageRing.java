package com.tycoon.item.equipment.rings;

import java.awt.Graphics2D;

import com.tycoon.gfx.Assets;
import com.tycoon.item.equipment.Rings;
import com.tycoon.util.Handler;

public class MinorDamageRing extends Rings{
	
	public static final float DMG_INCREASE = 1.3f;
	
	public MinorDamageRing(Handler h, float x, float y) {
		super(h, x, y);
		name = "Ring of Minor Damage";
	}

	@Override
	public void applyEffects() {
		h.getPlayer().setDamage(h.getPlayer().getDamage()*DMG_INCREASE);
	}

	@Override
	public void removeEffects() {
		h.getPlayer().setDamage(h.getPlayer().getDamage()/DMG_INCREASE);
	}

	@Override
	public void render(Graphics2D g2d) {
		g2d.drawImage(Assets.minorDmgRing, (int)(x-h.getGame().getGC().getXOffset()), (int)(y-h.getGame().getGC().getYOffset()), width, height, null);
	}

	@Override
	public void onHitAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isSolid() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
