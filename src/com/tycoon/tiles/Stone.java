package com.tycoon.tiles;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.tycoon.gfx.Assets;

public class Stone extends Tile {

	public Stone(int id) {
		super(Assets.stone, id);
	}

	@Override
	public boolean isSolid() {
		return true;
	}

}
