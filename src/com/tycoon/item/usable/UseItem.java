package com.tycoon.item.usable;

import com.tycoon.item.Item;
import com.tycoon.util.Handler;

//parent class of all items that can be used, sub class of items
public abstract class UseItem extends Item{

	public UseItem(Handler h, float x, float y) {
		super(h, x, y);
		typeID = 1;
	}
	
	public abstract void use();
}
