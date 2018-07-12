package com.tycoon.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//for one time key events, so the key has to be released before another event can occur
public class TimedKeyManager implements KeyListener {

	private static boolean isLeft, isRight, isUp, isDown, ePressed, comma, period, esc;
	private static boolean released = true;

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			isLeft = true;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			isRight = true;
		if (e.getKeyCode() == KeyEvent.VK_UP)
			isUp = true;
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			isDown = true;
		if (e.getKeyCode() == KeyEvent.VK_E)
			ePressed = true;
		if (e.getKeyCode() == KeyEvent.VK_COMMA)
			comma = true;
		if (e.getKeyCode() == KeyEvent.VK_PERIOD)
			period = true;
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
			esc = true;
//		released = false;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			isLeft = false;

		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			isRight = false;

		if (e.getKeyCode() == KeyEvent.VK_UP)
			isUp = false;

		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			isDown = false;

		if (e.getKeyCode() == KeyEvent.VK_E)
			ePressed = false;
		if (e.getKeyCode() == KeyEvent.VK_COMMA)
			comma = false;
		if (e.getKeyCode() == KeyEvent.VK_PERIOD)
			period = false;
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
			esc = false;

		released = true;

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public static boolean isLeft() {
		boolean a;
		if (released)
			a = isLeft;
		else
			a = false;
		if (a)
			released = false;
		return a;
	}

	public static boolean isRight() {
		boolean a;
		if (released)
			a = isRight;
		else
			a = false;
		if (a)
			released = false;
		return a;
	}

	public static boolean isUp() {
		boolean a;
		if (released)
			a = isUp;
		else
			a = false;
		if (a)
			released = false;
		return a;
	}

	public static boolean isDown() {
		boolean a;
		if (released)
			a = isDown;
		else
			a = false;
		if (a)
			released = false;
		// System.out.println(a);
		return a;
	}

	public static boolean isEPressed() {
		boolean a;
		if (released)
			a = ePressed;
		else
			a = false;
		if (a)
			released = false;
		return a;
	}
	public static boolean isPeriod() {
		boolean a;
		if (released)
			a = period;
		else
			a = false;
		if (a)
			released = false;
		return a;
	}
	public static boolean isComma() {
		boolean a;
		if (released)
			a = comma;
		else
			a = false;
		if (a)
			released = false;
		return a;
	}
	public static boolean isEsc() {
		boolean a;
		if (released)
			a = esc;
		else
			a = false;
		if (a)
			released = false;
		return a;
	}

}
