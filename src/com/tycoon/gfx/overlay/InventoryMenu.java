package com.tycoon.gfx.overlay;

import java.awt.Color;
import java.awt.Graphics2D;

import com.tycoon.gfx.Assets;
import com.tycoon.input.TimedKeyManager;
import com.tycoon.util.Handler;

public class InventoryMenu extends Menus {
	
	
	//menu items
	private String[] menuItems;
	
	//depending on item type, can load sub menu fron this list
	public static final String subMenuItems[][] = { { "Discard" }, { "Use", "Discard" }, { "Equip", "Discard" } };

	//loading menu items
	public InventoryMenu(Handler h) {
		super(h);
		title = "Inventory";
		String[] menuItems = new String[h.getInv().getItems().size()];
		this.menuItems = new String[menuItems.length];
		for (int i = 0; i < menuItems.length; i++) {
			menuItems[i] = h.getInv().getItems().get(i).getName();
		}
		this.h = h;
		this.menuItems = menuItems;
	}
	
	//set pointer location from other calss
	public InventoryMenu setPointerLocation(int i) {
		pointerLocation = i;
		return this;
	}
	
	//not used currently
	public InventoryMenu updateMenu() {
		String[] menuItems = new String[h.getInv().getItems().size()];
		for (int i = 0; i < menuItems.length; i++) {
			menuItems[i] = h.getInv().getItems().get(i).getName();
		}
		this.menuItems = menuItems;
		return this;
	}

	@Override
	public void tick() {
		if (TimedKeyManager.isDown()) {
			if (pointerLocation < menuItems.length - 1)
				pointerLocation++;
		} else if (TimedKeyManager.isUp()) {
			if (pointerLocation > 0) {
				pointerLocation--;
			}
		} else if (TimedKeyManager.isLeft()) {
			MenuManager.setCurrentMenu(MenuManager.superMenu);
		} else if (TimedKeyManager.isRight() && menuItems.length != 0) {
			MenuManager.setCurrentMenu(new ItemSubMenu(h,
					subMenuItems[h.getInv().getItems().get(pointerLocation).getTypeID()], pointerLocation));
		}
	}

	@Override
	public void render(Graphics2D g2d) {
		int width = g2d.getFontMetrics().stringWidth(title);
		int boxWidth = 0;
		int tempWidth;
		if (menuItems.length != 0)
			for (int i = 0; i < menuItems.length; i++) {
				// System.out.println(menuItems[i]);
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