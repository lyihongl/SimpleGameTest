package com.tycoon.tiles;

import java.awt.image.BufferedImage;

import com.tycoon.gfx.Assets;

public class CaveDown extends Tile{

	public CaveDown(int id) {
		super(Assets.caveDown, id);
	}



	@Override
	public boolean isSolid() {
		return false;
	}}
