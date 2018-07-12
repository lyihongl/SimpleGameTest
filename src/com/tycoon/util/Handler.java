package com.tycoon.util;

import com.tycoon.Game;
import com.tycoon.entity.Creature;
import com.tycoon.entity.EntityManager;
import com.tycoon.inventory.Inventory;
import com.tycoon.item.equipment.EqManager;
import com.tycoon.worlds.World;

//class that takes variables from all parts of the game, allows easy access to everything
public class Handler {
	
	private Game g;
	private World w;
	private EntityManager em;
	private Inventory inv;
	private EqManager eqM;
	public Handler(Game g){
		this.g = g;
	}
	public void setEqM(EqManager eqM){
		this.eqM = eqM;
	}
	public EqManager getEqM(){
		return eqM;
	}
	public void setInv(Inventory inv){
		this.inv = inv;
	}
	public Game getGame(){
		return g;
	}
	public void setWorld(World w){
		this.w = w;
	}
	public Creature getPlayer(){
		return w.getPlayer();
	}
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public World getWorld(){
		return w;
	}
	public Inventory getInv(){
		return inv;
	}
}
