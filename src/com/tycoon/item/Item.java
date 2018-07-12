package com.tycoon.item;

import java.awt.Graphics2D;

import com.tycoon.entity.PopUpText;
import com.tycoon.entity.StaticEntity;
import com.tycoon.tiles.Tile;
import com.tycoon.util.Handler;

//parent class of all items, sub class static entity
public abstract class Item extends StaticEntity {

	protected Handler h;
	protected int ID;
	protected int typeID;
	protected String name;
	
	public Item(Handler h, float x, float y) {
		super(h, x, y);
		this.h = h;
		typeID = 0;
	}

	public abstract void render(Graphics2D g2d);
	
	//collision detection
	public void tick(){
		if (h.getWorld().getPlayer().currentTileX() == (int) x / Tile.SIZE
				&& h.getWorld().getPlayer().currentTileY() == (int) y / Tile.SIZE) {
				intersectAction();
		}
	}

	// when player intersects with the item
	public void intersectAction() {
		if(h.getInv().getItems().size()<h.getInv().getCurrentMax())
			h.getEm().getSEntity().remove(this);
		else{
			h.getEm().sEntityAdd(new PopUpText(h, 50, 50, "Inventory Full"));
		}
		h.getInv().addItem(this);	
	}
	public int getTypeID(){
		return typeID;
	}
	public String getName(){
		return name;
	}
}
