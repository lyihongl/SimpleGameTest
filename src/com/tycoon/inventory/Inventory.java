package com.tycoon.inventory;

import java.util.ArrayList;

import com.tycoon.item.Item;

public class Inventory {

	//list of items
	private ArrayList<Item> items;
	private int currentMax = 20;

	public Inventory() {
		items = new ArrayList<Item>();
	}

	//adds item
	public void addItem(Item i) {
		if (items.size() < currentMax)
			items.add(i);
	}

	public int getCurrentMax() {
		return currentMax;
	}
	
	//remove item
	public void removeItem(Item i) {
		items.remove(i);
	}
	
	//remove item at location i
	public void removeItem(int i) {
		items.remove(i);
	}

	public ArrayList<Item> getItems() {
		return items;
	}


}
