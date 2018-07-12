package com.tycoon.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {//general key events

	private static boolean up, down, left, right, oneKey, twoKey, upKey, downKey, leftKey, rightKey;

	public KeyManager() {

	}

	@Override
	public void keyPressed(KeyEvent e) {
//		System.out.println("a");
		if (e.getKeyCode() == KeyEvent.VK_W)
			up = true;
		if (e.getKeyCode() == KeyEvent.VK_D)
			right = true;
		if (e.getKeyCode() == KeyEvent.VK_A)
			left = true;
		if (e.getKeyCode() == KeyEvent.VK_S)
			down = true;
		if(e.getKeyCode() == KeyEvent.VK_1)
			oneKey = true;
		if(e.getKeyCode() == KeyEvent.VK_2)
			twoKey = true;
		if(e.getKeyCode() == KeyEvent.VK_UP)
			upKey = true;
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
			downKey = true;
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
			leftKey = true;
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			rightKey = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W)
			up = false;
		if (e.getKeyCode() == KeyEvent.VK_D)
			right = false;
		if (e.getKeyCode() == KeyEvent.VK_A)
			left = false;
		if (e.getKeyCode() == KeyEvent.VK_S)
			down = false;
		if(e.getKeyCode() == KeyEvent.VK_1)
			oneKey = false;
		if(e.getKeyCode() == KeyEvent.VK_2)
			twoKey = false;
		if(e.getKeyCode() == KeyEvent.VK_UP)
			upKey = false;
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
			downKey = false;
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
			leftKey = false;
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			rightKey = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	public static boolean isUpKey() {
		return upKey;
	}

	public static boolean isDownKey() {
		return downKey;
	}

	public static boolean isLeftKey() {
		return leftKey;
	}

	public static boolean isRightKey() {
		return rightKey;
	}

	public static boolean isOneKey() {
		return oneKey;
	}

	public static boolean isTwoKey() {
		return twoKey;
	}

	public static boolean isUp() {
		return up;
	}

	public static boolean isDown() {
		return down;
	}

	public static boolean isLeft() {
		return left;
	}

	public static boolean isRight() {
		return right;
	}

}
