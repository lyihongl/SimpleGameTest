package com.tycoon.states;

import java.awt.Graphics2D;

import com.tycoon.entity.PopUpText;
import com.tycoon.entity.StaticEntity;
import com.tycoon.gfx.overlay.MenuManager;
import com.tycoon.gfx.overlay.SuperMenu;
import com.tycoon.input.TimedKeyManager;
import com.tycoon.util.Handler;
import com.tycoon.worlds.Scene1;
import com.tycoon.worlds.World;

public class GameState extends State {

	// main game state

	private World world;
	private boolean showInv = false;

	public GameState(Handler h) {
		super(h);
		world = new Scene1(h);
		h.setWorld(world);
	}

	@Override
	public void render(Graphics2D g2d) {
		h.getWorld().render(g2d);
		if (showInv)
			MenuManager.getCurrentMenu().render(g2d);

	}

	@Override
	public void tick() {

		if (showInv){
			MenuManager.getCurrentMenu().tick();
			for(int i = 0; i<h.getEm().getSEntity().size();i++){
				if(h.getEm().getSEntity().get(i) instanceof PopUpText){
					h.getEm().getSEntity().get(i).tick();
				}
			}
		}
			
		else
			h.getWorld().tick();
		if (TimedKeyManager.isEPressed()) {
			if (showInv) {
				showInv = false;
				MenuManager.setCurrentMenu(MenuManager.superMenu);
			}

			else
				showInv = true;
		}
		if(showInv){
			if(TimedKeyManager.isEsc()){
				showInv = false;
				MenuManager.setCurrentMenu(MenuManager.superMenu);
			}else if(TimedKeyManager.isLeft()){
				showInv = false;
				MenuManager.setCurrentMenu(MenuManager.superMenu);
			}
		}

	}

}
