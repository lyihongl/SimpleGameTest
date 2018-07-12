package com.tycoon.entity;

import java.awt.Graphics2D;

import com.tycoon.gfx.Animation;
import com.tycoon.gfx.Assets;
import com.tycoon.input.KeyManager;
import com.tycoon.input.TimedKeyManager;
import com.tycoon.tiles.Tile;
import com.tycoon.util.Handler;

public class Player extends Creature {

	// game player

	// down animation
	private Animation animDown;

	public Player(Handler h, int x, int y) {
		super(h, x * Tile.SIZE, y * Tile.SIZE, Creature.SIZE, Creature.SIZE);
		tX = x * Tile.SIZE;
		tY = y * Tile.SIZE;
		animDown = new Animation(Assets.walkUp, 10);
		damage = DEF_PLAYER_DAMAGE;
	}

	public void tick() {
		/// movement
		if (!isMovingX()) {
			if (KeyManager.isRight()) {
				moveRight();
			}
			if (KeyManager.isLeft()) {
				moveLeft();
			}
		}
		if (!isMovingY()) {

			if (KeyManager.isUp()) {
				moveUp();
			}
			if (KeyManager.isDown()) {
				animDown.tick();
				moveDown();
			}
		}
		// implementing the move command
		move(tX, tY);
		// combat
		meleeCombat();
	}

	//melee combat
	public void meleeCombat() {
		if (TimedKeyManager.isLeft()) {
			if (h.getEm().getCreatureAt(currentTileX() - 1, currentTileY()) != null) {
				h.getEm().getCreatureAt(currentTileX() - 1, currentTileY()).doDamage(damage);
				h.getEm().getCreatureAt(currentTileX() - 1, currentTileY()).knockBackX(-10);
			}
		} else if (TimedKeyManager.isRight()) {
			if (h.getEm().getCreatureAt(currentTileX() + 1, currentTileY()) != null) {
				h.getEm().getCreatureAt(currentTileX() + 1, currentTileY()).doDamage(damage);
				h.getEm().getCreatureAt(currentTileX() + 1, currentTileY()).knockBackX(10);
			}
		} else if (TimedKeyManager.isUp()) {
			if (h.getEm().getCreatureAt(currentTileX(), currentTileY() - 1) != null) {
				h.getEm().getCreatureAt(currentTileX(), currentTileY() - 1).doDamage(damage);
				h.getEm().getCreatureAt(currentTileX(), currentTileY() - 1).knockBackY(-10);
			}
		} else if (TimedKeyManager.isDown()) {
			if (h.getEm().getCreatureAt(currentTileX(), currentTileY() + 1) != null) {
				h.getEm().getCreatureAt(currentTileX(), currentTileY() + 1).doDamage(damage);
				h.getEm().getCreatureAt(currentTileX(), currentTileY() + 1).knockBackY(10);
			}
		}
	}

	@Override
	public void render(Graphics2D g2d) {
		super.render(g2d);
		if (KeyManager.isDown()) {
			g2d.drawImage(animDown.getCurrent(), (int) x - (int) h.getGame().getGC().getXOffset(),
					(int) y - (int) h.getGame().getGC().getYOffset(), width, height, null);
		} else {
			g2d.drawImage(Assets.walkUp[0], (int) x - (int) h.getGame().getGC().getXOffset(),
					(int) y - (int) h.getGame().getGC().getYOffset(), width, height, null);
		}

	}

	@Override
	public boolean isSolid() {
		return true;
	}

	@Override
	protected void knockBackX(int x) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void knockBackY(int y) {
		// TODO Auto-generated method stub

	}

}
