package com.tycoon.worlds;

import com.tycoon.entity.PopUpText;
import com.tycoon.entity.SceneSwitchPad;
import com.tycoon.entity.StaticEntity;
import com.tycoon.entity.BasicEnemy;
import com.tycoon.interfaces.IntersectAction;
import com.tycoon.item.Coin;
import com.tycoon.item.Item;
import com.tycoon.item.equipment.Rings;
import com.tycoon.item.equipment.armor.BasicArmor;
import com.tycoon.item.equipment.weapon.ShortDagger;
import com.tycoon.item.usable.HealthDrop;
import com.tycoon.tiles.Tile;
import com.tycoon.util.Handler;

public class Scene1 extends World {

	public Scene1(Handler h) {
		super(h, "/worlds/TestWorld.txt");

		em.sEntityAdd(new SceneSwitchPad(h, 7, 0, new IntersectAction() {
			
			public void intersectAction() {
				h.setWorld(new Scene2(h));
			}
		}));

		if (Math.random() < 0.5) {
			em.creatureAdd(new BasicEnemy(h, 5, 5));
//			em.creatureAdd(new BasicEnemy(h, 7, 5));
		}
		if (!WorldEntityManager.OTAScene1.healthAdded){
//			if (Math.random() < 0.3) {
				em.sEntityAdd(new HealthDrop(h, 15, 15));
				WorldEntityManager.OTAScene1.healthAdded = true;
		}
//			}
		
		if (!WorldEntityManager.OTAScene1.daggerAdded){
//			if (Math.random() < 0.3) {
				em.sEntityAdd(new ShortDagger(h, 10, 10));
				WorldEntityManager.OTAScene1.daggerAdded = true;
		}
//			}
		
		if (!WorldEntityManager.OTAScene1.armorAdded){
//			if (Math.random() < 0.3) {
				em.sEntityAdd(new BasicArmor(h, 5, 5));
				WorldEntityManager.OTAScene1.armorAdded = true;
		}
//			}
		
		if (!WorldEntityManager.OTAScene1.coinAdded){
//			if (Math.random() < 0.3) {
				em.sEntityAdd(new Coin(h, 7, 4));
				WorldEntityManager.OTAScene1.coinAdded = true;
		}
//			}

		em.sEntityAdd(new PopUpText(h, 50, 50, "Area 1"));
	}
	
}
