package com.tycoon.gfx;

import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;

public class Assets {// load all game files

	public static BufferedImage stone, grass, coin, healthBar, healthPack, invPointer, shortDagger, basicArmor,
			longSword, minorDmgRing, minorHealRing, caveUp, caveDown, dirt;
	public static BufferedImage[] walkUp;
	public static final int SIZE = 16;

	public static void initAssets() {

		ImageUtils i = new ImageUtils("/textures/SpriteSheet1.png");

		stone = i.crop(0, 0, SIZE, SIZE);
		grass = i.crop(SIZE, 0, SIZE, SIZE);
		coin = i.crop(2 * SIZE, 0, SIZE, SIZE);
		healthBar = i.crop(0, SIZE, SIZE, SIZE);
		healthPack = i.crop(SIZE, SIZE, SIZE, SIZE);
		invPointer = i.crop(2 * SIZE, SIZE, SIZE, SIZE);
		shortDagger = i.crop(0, 2 * SIZE, SIZE, SIZE);
		basicArmor = i.crop(SIZE, 2 * SIZE, SIZE, SIZE);
		longSword = i.crop(2*SIZE, 2*SIZE, SIZE, SIZE);
		minorDmgRing = i.crop(3*SIZE, 2*SIZE, SIZE, SIZE);
		minorHealRing = i.crop(4*SIZE, 2*SIZE, SIZE, SIZE);
		caveUp = i.crop(5*SIZE, 2*SIZE, SIZE, SIZE);
		caveDown = i.crop(6*SIZE, 2*SIZE, SIZE, SIZE);
		dirt = i.crop(7*SIZE, 2*SIZE, SIZE, SIZE);

		walkUp = new BufferedImage[4];
		walkUp[0] = i.crop(3 * SIZE, 0, 2 * SIZE, 2 * SIZE);
		walkUp[1] = i.crop(5 * SIZE, 0, 2 * SIZE, 2 * SIZE);
		walkUp[2] = i.crop(3 * SIZE, 0, 2 * SIZE, 2 * SIZE);
		walkUp[3] = i.crop(7 * SIZE, 0, 2 * SIZE, 2 * SIZE);
	}
}
