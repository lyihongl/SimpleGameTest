package com.tycoon.entity;

import java.awt.Graphics2D;

import com.tycoon.gfx.Assets;
import com.tycoon.interfaces.IntersectAction;
import com.tycoon.tiles.Tile;
import com.tycoon.util.Handler;
import com.tycoon.worlds.Scene1;
import com.tycoon.worlds.Scene2;
import com.tycoon.worlds.World;

public class SceneSwitchPad extends StaticEntity {
	
	//when player intersects with this, an action occurs
	//Action that occurs is described in the interface IntersectAction ia
	
	private IntersectAction ia;

	public SceneSwitchPad(Handler h, float x, float y, IntersectAction ia) {
		super(h, x, y);
		this.ia = ia;
		
	}

	@Override
	public boolean isSolid() {
		return false;
	}

	@Override
	public void tick() {
		if (h.getWorld().getPlayer().currentTileX() == (int) x / Tile.SIZE
				&& h.getWorld().getPlayer().currentTileY() == (int) y / Tile.SIZE)
			intersectAction();
	}

	@Override
	public void render(Graphics2D g2d) {
	}

	@Override
	public void intersectAction() {
		ia.intersectAction();
//		System.out.println(x+" "+y);
	}

	@Override
	public void onHitAction() {

	}

}
