package com.tycoon.worlds;

import com.tycoon.entity.PopUpText;
import com.tycoon.entity.SceneSwitchPad;
import com.tycoon.interfaces.IntersectAction;
import com.tycoon.item.equipment.rings.MinorDamageRing;
import com.tycoon.item.equipment.rings.MinorHealRing;
import com.tycoon.item.equipment.weapon.LongSword;
import com.tycoon.util.Handler;

public class Scene2 extends World {

	public Scene2(Handler h) {
		
		super(h, "/worlds/TestWorld2.txt");
		
		em.sEntityAdd(new SceneSwitchPad(h, 7, 18, new IntersectAction() {
			@Override
			public void intersectAction() {
				h.setWorld(new Scene1(h).setSpawn(7, 1));
			}
		}));
		
		em.sEntityAdd(new SceneSwitchPad(h, 8, 1, new IntersectAction(){
			
			public void intersectAction(){
				h.setWorld(new Scene3(h).setSpawn(7, 17));
			}
		}));
		
		em.sEntityAdd(new PopUpText(h, 50, 50, "Area 2"));
		em.sEntityAdd(new LongSword(h, 5, 5));
		em.sEntityAdd(new MinorDamageRing(h, 6, 6));
		em.sEntityAdd(new MinorHealRing(h, 7, 7));
	}

}
