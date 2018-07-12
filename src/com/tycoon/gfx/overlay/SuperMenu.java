package com.tycoon.gfx.overlay;

import java.awt.Color;
import java.awt.Graphics2D;

import com.tycoon.gfx.Assets;
import com.tycoon.input.TimedKeyManager;
import com.tycoon.util.Handler;

public class SuperMenu extends Menus {//the first menu

	protected String[] menuItems = { "Inventory", "Equiped Items" };

	// private Handler h;
	public SuperMenu(Handler h) {
		super(h);
		title = "Menu";
		// System.out.println(this.h);
	}

	public void tick() {
		if (TimedKeyManager.isDown()) {
			if (pointerLocation < menuItems.length - 1)
				pointerLocation++;
		} else if (TimedKeyManager.isUp()) {
			if (pointerLocation > 0) {
				pointerLocation--;
			}
		} else if (TimedKeyManager.isRight()) {
			if (pointerLocation == 0){
				MenuManager.setCurrentMenu(new InventoryMenu(h));
//				System.out.println("x");
			}
				
			else if(pointerLocation == 1)
				MenuManager.setCurrentMenu(new CharacterMenu(h));
		}
//		else if(TimedKeyManager.isLeft()){
//			
//		}
	}

	public void render(Graphics2D g2d) {
		int width = g2d.getFontMetrics().stringWidth(title);
		int boxWidth = 0;
		int tempWidth;
		if (menuItems.length != 0)
			for (int i = 0; i < menuItems.length; i++) {
				tempWidth = g2d.getFontMetrics().stringWidth(menuItems[i]);
				if (tempWidth > boxWidth)
					boxWidth = tempWidth;
			}

		if (boxWidth < g2d.getFontMetrics().stringWidth(title)) {
			boxWidth = g2d.getFontMetrics().stringWidth(title);
		}
		g2d.setColor(Color.DARK_GRAY);
		if (menuItems.length == 0)
			g2d.fillRect(25, 5, boxWidth + 10, 20);
		else {
			g2d.fillRect(25, 5, boxWidth + 10, menuItems.length * 20 + 25);
			g2d.drawImage(Assets.invPointer, 10, pointerLocation * gridSpacing + 26, 16, 16, null);
		}

		g2d.setColor(Color.WHITE);
		g2d.drawString(title, 30, 20);
		g2d.drawLine(28, 25, 27 + width + 4, 25);
		g2d.setColor(Color.DARK_GRAY);
		for (int i = 0; i < menuItems.length; i++) {
			if (pointerLocation == i)
				g2d.setColor(Color.red);
			else
				g2d.setColor(Color.white);
			g2d.drawString(menuItems[i], 30, gridSpacing * i + 40);
		}
	}

}
