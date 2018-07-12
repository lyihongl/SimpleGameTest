package com.tycoon.tiles;

import java.awt.image.BufferedImage;

import com.tycoon.gfx.Assets;

public class CaveUp extends Tile{

	public CaveUp( int id) {
		super(Assets.caveUp, id);
	}

	@Override
	public boolean isSolid() {
		return false;
	}
	
}
