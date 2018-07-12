package com.tycoon.gfx.overlay;

import java.awt.Color;
import java.awt.Graphics2D;

import com.tycoon.gfx.Assets;
import com.tycoon.input.TimedKeyManager;
import com.tycoon.item.equipment.Armor;
import com.tycoon.item.equipment.Rings;
import com.tycoon.item.equipment.Weapon;
import com.tycoon.util.Handler;

public class CharacterMenu extends Menus {

	//menu items
	private String[] menuItems;

	//loads the menu items
	public CharacterMenu(Handler h) {
		super(h);
		menuItems = new String[5];
		int numOfRings = 0;
		for(int i = 0; i<menuItems.length;i++){
			menuItems[i] = "None";
		}
		for (int i = 0; i < h.getEqM().getEquipedItems().size(); i++) {
			if (h.getEqM().getEquipedItems().get(i) instanceof Weapon) {
				menuItems[0] = h.getEqM().getEquipedItems().get(i).getName();
			} else if (h.getEqM().getEquipedItems().get(i) instanceof Armor) {
				menuItems[1] = h.getEqM().getEquipedItems().get(i).getName();
			} else if (h.getEqM().getEquipedItems().get(i) instanceof Rings) {
				menuItems[2 + numOfRings] = h.getEqM().getEquipedItems().get(i).getName();
				numOfRings++;
			}
		}
		title = "Equiped Items";
	}
	
	//allows the pointer location to be set
	public CharacterMenu setPointerLocation(int i){
		pointerLocation =i;
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
		} else if(TimedKeyManager.isRight() && !menuItems[pointerLocation].equals("None")){
			String[] a = {"Unequip", "Discard"};
			MenuManager.setCurrentMenu(new ItemSubMenu(h, a, pointerLocation, 1));
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
			
		g2d.setColor(Color.WHITE);
		g2d.drawString(title, 30, 20);
		g2d.drawLine(28, 25, 27+width+4, 25);
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
