package com.tycoon.item.equipment;

import com.tycoon.util.Handler;

//parent class for all armor items, sub class of equipment
public abstract class Armor extends Equipment {

	protected int armor;

	public Armor(Handler h, float x, float y, int armor) {
		super(h, x, y);
		eqID = 1;
		typeName = "Armor";
		this.armor = armor;
	}

	@Override
	public void applyEffects() {
		h.getPlayer().setArmor(armor);
	}

	@Override
	public void removeEffects() {
		h.getPlayer().setArmor(0);
	}

}
