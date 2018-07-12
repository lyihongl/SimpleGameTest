package com.tycoon.tiles;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public abstract class Tile {
	
	//parent class of all tiles
	
	protected int id;
	protected BufferedImage img;
	public static final int SIZE = 32;
	private static Tile[] tile = new Tile[16];
	
	public static Tile grassTile = new Grass(0);
	public static Tile stoneTile = new Stone(1);
	public static Tile caveUp = new CaveUp(2);
	public static Tile caveDown = new CaveDown(3);
	public static Tile dirt = new Dirt(4);
	
	public Tile(BufferedImage img, int id) {
		this.img = img;
		this.id = id;
		tile[id] = this;
	}

	public abstract boolean isSolid();

	public void render(Graphics2D g2d, int x, int y) {
		g2d.drawImage(img, x, y, SIZE, SIZE, null);
	}
	
	public static Tile getTile(int id){
		return tile[id];
	}

	public int getId() {
		return id;
	}
}
