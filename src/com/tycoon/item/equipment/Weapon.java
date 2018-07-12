package com.tycoon.item.equipment;

import com.tycoon.entity.Creature;
import com.tycoon.util.Handler;

//parent class to all weapons, sub class of equipment
public abstract class Weapon extends Equipment {

	protected int damage;

	public Weapon(Handler h, float x, float y, int damage) {
		super(h, x, y);
		eqID = 0;
		typeName = "Weapon";
		this.damage = damage;
	}

	@Override
	public void applyEffects() {
		h.getPlayer().setDamage(damage);
	}

	@Override
	public void removeEffects() {
		h.getPlayer().setDamage(Creature.DEF_PLAYER_DAMAGE);
	}

}
