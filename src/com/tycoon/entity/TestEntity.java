package com.tycoon.entity;

import java.awt.Graphics2D;

import com.tycoon.gfx.Assets;
import com.tycoon.item.Coin;
import com.tycoon.tiles.Tile;
import com.tycoon.util.Handler;

public class TestEntity extends Creature {// currently testing combat system

	private int attackSpeed = 5;
	private int ct = 0;
	private float dist;

	public TestEntity(Handler h, float x, float y) {
		super(h, x * Tile.SIZE, y * Tile.SIZE, Creature.SIZE, Creature.SIZE);
		tX = (int) x * Tile.SIZE;
		tY = (int) y * Tile.SIZE;
		speed = 1f;
		damage = 1;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		ct++;
		// System.out.println(currentTileX()+" "+currentTileY());
		dist = (float) Math.sqrt((currentTileX() - h.getWorld().getPlayer().currentTileX())
				* (currentTileX() - h.getWorld().getPlayer().currentTileX())
				+ (currentTileY() - h.getWorld().getPlayer().currentTileY())
						* (currentTileY() - h.getWorld().getPlayer().currentTileY()));
		if (dist <= 1 && ct % 30 == 0)
			h.getWorld().getPlayer().doDamage(damage);

		ai();
		move(tX, tY);
		if (ct >= 60)
			ct = 0;
	}

	public void ai() {
		if (!isMovingX())
			if (currentTileX() < h.getWorld().getPlayer().currentTileX()) {
				moveRight();
			} else if (currentTileX() > h.getWorld().getPlayer().currentTileX()) {
				moveLeft();
			}
		if (!isMovingY())
			if (currentTileY() < h.getWorld().getPlayer().currentTileY()) {
				moveDown();
			} else if (currentTileY() > h.getWorld().getPlayer().currentTileY())
				moveUp();
	}

	@Override
	public void die() {
		super.die();
		if (Math.random() < 0.3) {
			h.getEm().sEntityAdd(new Coin(h, this.currentTileX(), this.currentTileY()));
		}
	}

	@Override
	public void render(Graphics2D g2d) {
		super.render(g2d);
		g2d.drawImage(Assets.coin, (int) (x - h.getGame().getGC().getXOffset()),
				(int) (y - h.getGame().getGC().getYOffset()), width, height, null);
	}

	@Override
	public boolean isSolid() {
		return true;
	}

	@Override
	protected void knockBackX(int x) {
		this.x += x;
	}

	@Override
	protected void knockBackY(int y) {
		this.y += y;
	}

}
