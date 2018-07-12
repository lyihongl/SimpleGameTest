package com.tycoon.worlds;

import com.tycoon.entity.SceneSwitchPad;
import com.tycoon.interfaces.IntersectAction;
import com.tycoon.util.Handler;

public class Scene3 extends World{

	public Scene3(Handler h) {
		super(h, "/worlds/TestWorld2.txt");
		em.sEntityAdd(new SceneSwitchPad(h, 7, 18, new IntersectAction() {

			@Override
			public void intersectAction(){
				h.setWorld(new Scene2(h).setSpawn(8, 2));
//				System.out.println("m");
			}
		}));
	}

}
