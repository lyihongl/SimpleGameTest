package com.tycoon.item.equipment.rings;

import java.awt.Graphics2D;

import com.tycoon.gfx.Assets;
import com.tycoon.item.equipment.Rings;
import com.tycoon.item.usable.HealthDrop;
import com.tycoon.util.Handler;

public class MinorHealRing extends Rings{

	public static final float MULTIPLIER = 1.3f;
	
	public MinorHealRing(Handler h, float x, float y) {
		super(h, x, y);
		name = "Ring of Minor Healing";
	}

	@Override
	public void applyEffects() {
		HealthDrop.setHeal(HealthDrop.getHeal()*MULTIPLIER);
	}

	@Override
	public void removeEffects() {
		HealthDrop.setHeal(HealthDrop.getHeal()/MULTIPLIER);
	}

	@Override
	public void render(Graphics2D g2d) {
		g2d.drawImage(Assets.minorHealRing, (int)(x-h.getGame().getGC().getXOffset()), (int)(y-h.getGame().getGC().getYOffset()), width, height, null);
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
