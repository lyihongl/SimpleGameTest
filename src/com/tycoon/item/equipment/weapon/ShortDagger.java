package com.tycoon.item.equipment.weapon;

import java.awt.Graphics2D;

import com.tycoon.entity.Creature;
import com.tycoon.gfx.Assets;
import com.tycoon.item.equipment.Weapon;
import com.tycoon.util.Handler;

public class ShortDagger extends Weapon{
	
	public static final int DAMAGE = 7;
	
	public ShortDagger(Handler h, float x, float y) {
		super(h, x, y, DAMAGE);
		name = "Short Dagger";
	}

	

	@Override
	public void render(Graphics2D g2d) {
		g2d.drawImage(Assets.shortDagger, (int)(x-h.getGame().getGC().getXOffset()), (int)(y-h.getGame().getGC().getYOffset()), width, height, null);
	}

	@Override
	public void onHitAction() {
		
	}

	@Override
	public boolean isSolid() {
		return false;
	}
//	public void intersectAction(){
//		super.intersectAction();
//		h.getInv().addItem(this);
//	}

}
