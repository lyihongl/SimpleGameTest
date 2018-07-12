package com.tycoon.item.equipment;

import com.tycoon.item.Item;
import com.tycoon.util.Handler;

//parent class to all equipable items, sub class of items
public abstract class Equipment extends Item {

	protected boolean isEquiped = false;
	protected int eqID;
	protected String typeName;

	public Equipment(Handler h, float x, float y) {
		super(h, x, y);
		typeID = 2;
	}
	
	public boolean getIsEquiped(){
		return isEquiped;
	}
	public int getEqID(){
		return eqID;
	}
	public String getTypeName(){
		return typeName;
	}
	public abstract void applyEffects();
	public abstract void removeEffects();
}
