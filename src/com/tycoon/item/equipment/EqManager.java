package com.tycoon.item.equipment;

import java.util.ArrayList;

import com.tycoon.util.Handler;

//manages currently equiped items
public class EqManager {
	
	private ArrayList<Equipment> equipedItems;
	
	public EqManager(){
		equipedItems = new ArrayList<Equipment>();
	}
	public void equipItem(Equipment e){
		e.applyEffects();
		equipedItems.add(e);
	}
	public void unequipItem(Equipment e){
		e.removeEffects();
		equipedItems.remove(e);
	}
	public ArrayList<Equipment> getEquipedItems(){
		return equipedItems;
	}
	
	
	
}
