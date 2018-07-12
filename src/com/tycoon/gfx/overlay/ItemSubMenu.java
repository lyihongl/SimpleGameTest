package com.tycoon.gfx.overlay;

import java.awt.Color;
import java.awt.Graphics2D;

import com.tycoon.entity.PopUpText;
import com.tycoon.gfx.Assets;
import com.tycoon.input.TimedKeyManager;
import com.tycoon.item.equipment.Armor;
import com.tycoon.item.equipment.Equipment;
import com.tycoon.item.equipment.Rings;
import com.tycoon.item.equipment.Weapon;
import com.tycoon.item.usable.UseItem;
import com.tycoon.util.Handler;

public class ItemSubMenu extends Menus {//Sub menu for different items

	private String[] menuItems;
	private int previousPointer;
	private boolean isCharacter = false;
	
	//constructor for sub menu from inventory
	public ItemSubMenu(Handler h, String[] menuItems, int previousPointer) {
		super(h);
		title = h.getInv().getItems().get(previousPointer).getName();
		this.menuItems = menuItems;
		this.previousPointer = previousPointer;
	}
	
	//constructor for sub menu from equiped items menu
	public ItemSubMenu(Handler h, String[] menuItems, int previousPointer, int i) {
		super(h);
		if (previousPointer == 0)
			for (int j = 0; j < h.getEqM().getEquipedItems().size(); j++) {
				if (h.getEqM().getEquipedItems().get(j) instanceof Weapon) {
					title = h.getEqM().getEquipedItems().get(j).getName();
				}
			}
		else if (previousPointer == 1)
			for (int j = 0; j < h.getEqM().getEquipedItems().size(); j++) {
				if (h.getEqM().getEquipedItems().get(j) instanceof Armor) {
					title = h.getEqM().getEquipedItems().get(j).getName();
				}
			}
		else if (previousPointer >= 2)
			for (int j = 0; j < h.getEqM().getEquipedItems().size(); j++) {
				if (h.getEqM().getEquipedItems().get(j) instanceof Rings) {
					title = h.getEqM().getEquipedItems().get(j).getName();
				}
			}

		this.menuItems = menuItems;
		this.previousPointer = previousPointer;
		isCharacter = true;
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
			if (isCharacter)
				MenuManager.setCurrentMenu(new CharacterMenu(h).setPointerLocation(previousPointer));
			else
				MenuManager.setCurrentMenu(new InventoryMenu(h).setPointerLocation(previousPointer));
		} else if (TimedKeyManager.isRight()) {
			if (menuItems[pointerLocation].equals("Discard")) {
				//if from the equiped items menu
				if (isCharacter) {
					int ringCount = 0;
					if (previousPointer == 0)
						for (int i = 0; i < h.getEqM().getEquipedItems().size(); i++) {
							if (h.getEqM().getEquipedItems().get(i) instanceof Weapon) {
								h.getEqM().getEquipedItems().get(i).removeEffects();
								h.getEqM().getEquipedItems().remove(i);
							}

						}
					else if (previousPointer == 1)
						for (int i = 0; i < h.getEqM().getEquipedItems().size(); i++) {
							if (h.getEqM().getEquipedItems().get(i) instanceof Armor) {
								h.getEqM().getEquipedItems().get(i).removeEffects();
								h.getEqM().getEquipedItems().remove(i);
							}

						}
					else if (previousPointer >= 2)
						for (int i = 0; i < h.getEqM().getEquipedItems().size(); i++) {
							if (h.getEqM().getEquipedItems().get(i) instanceof Rings) {
								ringCount++;
								if (previousPointer == 2) {
									h.getEqM().getEquipedItems().get(i).removeEffects();
									h.getEqM().getEquipedItems().remove(i);
								} else if (previousPointer == 3) {
									if (ringCount == 2) {
										h.getEqM().getEquipedItems().get(i).removeEffects();
										h.getEqM().getEquipedItems().remove(i);
									}
								} else if (previousPointer == 4) {
									if (ringCount == 3) {
										h.getEqM().getEquipedItems().get(i).removeEffects();
										h.getEqM().getEquipedItems().remove(i);
									}
								}
							}
						}
					
					MenuManager.setCurrentMenu(new CharacterMenu(h).setPointerLocation(previousPointer).setPointerLocation(previousPointer));

				} else {
					h.getInv().removeItem(previousPointer);
					if (previousPointer != 0)
						MenuManager.setCurrentMenu(new InventoryMenu(h).setPointerLocation(previousPointer - 1));
					else
						MenuManager.setCurrentMenu(new InventoryMenu(h));
				}

			} else if (menuItems[pointerLocation].equals("Use")) {
				UseItem u = (UseItem) h.getInv().getItems().get(previousPointer);
				u.use();
				h.getInv().removeItem(previousPointer);
				if (previousPointer != 0)
					MenuManager.setCurrentMenu(new InventoryMenu(h).setPointerLocation(previousPointer - 1));
				else
					MenuManager.setCurrentMenu(new InventoryMenu(h));
			} else if (menuItems[pointerLocation].equals("Equip")) {
				boolean addnew = true;

				Equipment e = (Equipment) h.getInv().getItems().get(previousPointer);

				for (int i = 0; i < h.getEqM().getEquipedItems().size(); i++) {

					if (h.getEqM().getEquipedItems().get(i).getEqID() == e.getEqID() && e.getEqID() != 2) {
						addnew = false;

						break;
					} else if (e.getEqID() == 2) {
						int rings = 0;
						for (int j = 0; j < h.getEqM().getEquipedItems().size(); j++) {
							if (h.getEqM().getEquipedItems().get(j) instanceof Rings)
								rings++;
						}
						if (rings >= 3) {
							addnew = false;
						}
					}
				}

				if (addnew) {
					h.getEqM().equipItem(e);
					h.getInv().removeItem(previousPointer);
					if (previousPointer != 0)
						MenuManager.setCurrentMenu(new InventoryMenu(h).setPointerLocation(previousPointer - 1));
					else
						MenuManager.setCurrentMenu(new InventoryMenu(h));
				} else {
					MenuManager.setCurrentMenu(new InventoryMenu(h).setPointerLocation(previousPointer));
					h.getEm().sEntityAdd(new PopUpText(h, h.getGame().getWidth() / 2, 50,
							"A(n) " + e.getTypeName() + " is already equiped"));
				}

			} else if (menuItems[pointerLocation].equals("Unequip")) {

				if (h.getInv().getItems().size() < h.getInv().getCurrentMax()) {
					if (previousPointer == 0)
						for (int i = 0; i < h.getEqM().getEquipedItems().size(); i++) {
							if (h.getEqM().getEquipedItems().get(i) instanceof Weapon) {
								h.getEqM().getEquipedItems().get(i).removeEffects();
								h.getInv().addItem(h.getEqM().getEquipedItems().get(i));
								h.getEqM().getEquipedItems().remove(i);
							}

						}
					else if (previousPointer == 1)
						for (int i = 0; i < h.getEqM().getEquipedItems().size(); i++) {
							if (h.getEqM().getEquipedItems().get(i) instanceof Armor) {
								h.getEqM().getEquipedItems().get(i).removeEffects();
								h.getInv().addItem(h.getEqM().getEquipedItems().get(i));
								h.getEqM().getEquipedItems().remove(i);
							}
						}
					else if (previousPointer >= 2) {
						int ringCount = 0;
						for (int i = 0; i < h.getEqM().getEquipedItems().size(); i++) {
							if (h.getEqM().getEquipedItems().get(i) instanceof Rings) {
								ringCount++;
								if (previousPointer == 2) {
									h.getEqM().getEquipedItems().get(i).removeEffects();
									h.getInv().addItem(h.getEqM().getEquipedItems().get(i));
									h.getEqM().getEquipedItems().remove(i);
								} else if (previousPointer == 3) {
									if (ringCount == 2) {
										h.getEqM().getEquipedItems().get(i).removeEffects();
										h.getInv().addItem(h.getEqM().getEquipedItems().get(i));
										h.getEqM().getEquipedItems().remove(i);
									}
								} else if (previousPointer == 4) {
									if (ringCount == 3) {
										h.getEqM().getEquipedItems().get(i).removeEffects();
										h.getInv().addItem(h.getEqM().getEquipedItems().get(i));
										h.getEqM().getEquipedItems().remove(i);
									}
								}
							}
						}
					}

				} else
					h.getEm().sEntityAdd(new PopUpText(h, h.getGame().getWidth() / 2, 50, "Inventory Full"));
				MenuManager.setCurrentMenu(new CharacterMenu(h).setPointerLocation(previousPointer));
			}
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