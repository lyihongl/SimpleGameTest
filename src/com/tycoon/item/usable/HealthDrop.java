
package com.tycoon.item.usable;

import java.awt.Graphics2D;

import com.tycoon.Game;
import com.tycoon.gfx.Assets;
import com.tycoon.util.Handler;

public class HealthDrop extends UseItem {

	private static float heal;
	
	public HealthDrop(Handler h, float x, float y) {
		super(h, x, y);
		ID = 1;
		name = "Health Pack";
	}

	@Override
	public void render(Graphics2D g2d) {
//		System.out.println(heal);
		g2d.drawImage(Assets.healthPack, (int) (x - h.getGame().getGC().getXOffset()),
				(int) (y - h.getGame().getGC().getYOffset()), width, height, null);
	}

	@Override
	public void onHitAction() {

	}
	
	public static void setHeal(float f){
		heal = f;
	}
	public static float getHeal(){
		return heal;
	}

	@Override
	public boolean isSolid() {
		return false;
	}

	@Override
	public void use() {
//		System.out.println(heal);
		if (Game.PLAYER_FINAL.getInitHealth() - Game.PLAYER_FINAL.getHealth() < heal)
			Game.PLAYER_FINAL.setInitHealth(Game.PLAYER_FINAL.getInitHealth());
		else
			Game.PLAYER_FINAL.setHealth(Game.PLAYER_FINAL.getHealth() + heal);
	}

}