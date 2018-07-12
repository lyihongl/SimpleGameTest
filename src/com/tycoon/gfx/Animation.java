package com.tycoon.gfx;

import java.awt.image.BufferedImage;

public class Animation {// allows an array of images to be animated

	private BufferedImage[] frames;// frames of the animation
	private int time;
	private long lastTime = System.currentTimeMillis();
	private int count = 0;

	public Animation(BufferedImage[] frames, int time) {
		this.frames = frames;
		this.time = time;
	}

	public void tick() {// swaping current frame
		if (System.currentTimeMillis() - lastTime >= time) {
			lastTime = System.currentTimeMillis();
			count++;
			if (count >= frames.length)
				count = 0;
		}
	}

	public BufferedImage getCurrent() {
		return frames[count];
	}
}
