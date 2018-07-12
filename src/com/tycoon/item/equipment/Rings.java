package com.tycoon.item.equipment;

import com.tycoon.util.Handler;

//parent class to all ring items, sub class of equipment
public abstract class Rings extends Equipment{

	public Rings(Handler h, float x, float y) {
		super(h, x, y);
		eqID = 2;
		typeName = "Ring";
	}

}
