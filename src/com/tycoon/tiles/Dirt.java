package com.tycoon.tiles;


import com.tycoon.gfx.Assets;

public class Dirt extends Tile {

	public Dirt(int id) {
		super(Assets.dirt, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isSolid() {
		// TODO Auto-generated method stub
		return false;
	}

}
