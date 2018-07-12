package com.tycoon.entity;

import java.awt.Graphics2D;

import com.tycoon.gfx.Assets;
import com.tycoon.tiles.Tile;
import com.tycoon.util.Handler;

public abstract class Creature extends Entity {

	// can move, can die

	protected int tX, tY;
	public static final float SPEED = 2f;
	public static final int SIZE = 32;
	public static final int DEF_HEALTH = 10;
	public static final int DEF_ARMOR = 0;
	public static final int DEF_PLAYER_DAMAGE = 5;

	protected float speed;
	protected float health;
	protected float initHealth;
	protected float damage;
	protected int armor;
	
	

	public Creature(Handler h, float x, float y, int width, int height) {
		super(h, x, y, width, height);
		health = DEF_HEALTH;
		initHealth = health;
		speed = SPEED;
		armor = DEF_ARMOR;
	}

	public Creature setHealthInit(int h) {
		health = h;
		initHealth = h;
		return this;
	}

	public void setArmor(int i) {
		armor = i;
	}

	protected void move(int tX, int tY) {

		xMove(tX);
		yMove(tY);
	}

	protected abstract void knockBackX(int x);

	protected abstract void knockBackY(int y);

	private void xMove(int tX) {
		if (x < tX) {
			x += speed;
		} else if (x > tX) {
			x -= speed;
		}
	}

	private void yMove(int tY) {
		if (y < tY) {
			y += speed;
		} else if (y > tY) {
			y -= speed;
		}
	}
	
	//returns if tile is solid 
	protected boolean tileSolid(int x, int y) {
		return h.getWorld().getTile(x / Tile.SIZE, y / Tile.SIZE).isSolid();
	}

	public void render(Graphics2D g2d) {
		g2d.drawImage(Assets.healthBar, (int) x - (int) h.getGame().getGC().getXOffset(),
				(int) y + SIZE - (int) h.getGame().getGC().getYOffset(), (int) ((float) health * (32f / initHealth)), 3,
				null);
	}

	// collision with static entity
	public boolean isCollision(int x, int y) {
		if (h.getEm().getSEntityAt(x / Tile.SIZE, y / Tile.SIZE) == null)
			return false;
		else
			return true;
	}

	// a creature colliding with static entity
	public boolean isCollisionE(int x, int y, int ex, int ey) {
		if (h.getEm().getSEntityAt(ex, ey) != null && x == ex && y == ey) {
			return true;
		}
		return false;
	}

	// checking if there is a solid static entity
	protected boolean isSEntitySolid(int x, int y) {
		if (isCollision(x, y))// if there is entity
			return h.getEm().getSEntityAt(x / Tile.SIZE, y / Tile.SIZE).isSolid();
		return false;// no entity, return false
	}

	// creature solid
	public boolean isCreatureCollision(int x, int y) {
		for (int i = 0; i < h.getEm().getCreature().size(); i++) {
			if (h.getEm().getCreature().get(i).currentTileX() == x / Tile.SIZE
					&& h.getEm().getCreature().get(i).currentTileY() == y / Tile.SIZE)
				return true;
		}
		return false;
	}

	//returns if creature is solid
	public boolean isCreatureSolid(int x, int y) {
		if (isCreatureCollision(x, y)) {
			return h.getEm().getCreatureAt(x / Tile.SIZE, y / Tile.SIZE).isSolid();
		}
		return false;
	}

	// remove from entity manager
	public void removeC() {
		h.getEm().getCreature().remove(this);
	}

	// can be called to deal damage to this creature
	public void doDamage(float damage) {
		health -= (double) damage*calculateDmgTaken();
	}
	
	public float calculateDmgTaken(){
		float xVal = armor/100;
		float damageTake = 1/(1+xVal);
		return damageTake;
	}

	// get x in terms of the tile its on
	public int currentTileX() {
		return (int) (x + SIZE / 2) / Tile.SIZE;
	}

	// get y in terms of the tile its on
	public int currentTileY() {
		return (int) (y + SIZE / 2) / Tile.SIZE;
	}

	protected void moveRight() {
		if (!tileSolid((int) x + Tile.SIZE, (int) tY) && !isSEntitySolid((int) x + Tile.SIZE, (int) tY)
				&& !isCreatureSolid((int) x + Tile.SIZE, (int) tY))
			tX = (int) (currentTileX() + 1) * Tile.SIZE;
	}

	protected void moveLeft() {
		if (!tileSolid((int) x - Tile.SIZE, (int) tY) && !isSEntitySolid((int) x - Tile.SIZE, (int) tY)
				&& !isCreatureSolid((int) x - Tile.SIZE, (int) tY))
			tX = (int) (currentTileX() - 1) * Tile.SIZE;
	}

	protected void moveUp() {
		if (!tileSolid((int) tX, (int) y - Tile.SIZE) && !isSEntitySolid((int) tX, (int) y - Tile.SIZE)
				&& !isCreatureSolid((int) tX, (int) y - Tile.SIZE))
			tY = (int) (currentTileY() - 1) * Tile.SIZE;
	}

	protected void moveDown() {
		if (!tileSolid((int) tX, (int) y + Tile.SIZE) && !isSEntitySolid((int) tX, (int) y + Tile.SIZE)
				&& !isCreatureSolid((int) tX, (int) y + Tile.SIZE))
			tY = (int) (currentTileY() + 1) * Tile.SIZE;
	}

	// checking if the creature is moving in the x
	protected boolean isMovingX() {
		if (x % 32 != 0)
			return true;
		return false;
	}

	public void setDamage(float i) {
		damage = i;
	}

	public void die() {
		h.getEm().removeC(this);
	}

	// checking if the creature is moving in the y
	protected boolean isMovingY() {
		if (y % 32 != 0)
			return true;
		return false;
	}

	public void setX(int x) {
		this.x = x * Tile.SIZE;
	}

	public void setY(int y) {
		this.y = y * Tile.SIZE;
	}

	public void settX(int tX) {
		this.tX = tX * Tile.SIZE;
	}

	public void settY(int tY) {
		this.tY = tY * Tile.SIZE;
	}

	public float getHealth() {
		return health;
	}

	public void setInitHealth(float f) {
		this.health = f;
		this.initHealth = f;
	}
	public void setHealth(float f){
		this.health = f;
	}
	public float getDamage(){
		return damage;
	}

	public float getInitHealth() {
		return initHealth;
	}

}