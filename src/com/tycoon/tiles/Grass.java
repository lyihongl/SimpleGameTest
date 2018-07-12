package com.tycoon.tiles;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.tycoon.gfx.Assets;

public class Grass extends Tile {

	public Grass (int id) {
		super(Assets.grass, id);
	}

	@Override
	public boolean isSolid() {
		return false;
	}

}
