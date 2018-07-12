package com.tycoon.worlds;

import java.awt.Graphics2D;

import com.tycoon.Game;
import com.tycoon.entity.Creature;
import com.tycoon.entity.EntityManager;
import com.tycoon.entity.StaticEntity;
import com.tycoon.tiles.Tile;
import com.tycoon.util.FileUtils;
import com.tycoon.util.Handler;

public class World {

	
	protected int width, height;
	protected int spawnX, spawnY;
	protected FileUtils fUtil = new FileUtils();
	protected int[][] tileId;
	protected EntityManager em = new EntityManager();
	protected Handler h;

	public World(Handler h, String path) {
		this.h = h;

		// loading in world
		String s[] = fUtil.loadWorldAsString(path);
		width = Integer.parseInt(s[0]);
		height = Integer.parseInt(s[1]);
		tileId = new int[width][height];
		spawnX = Integer.parseInt(s[2]);
		spawnY = Integer.parseInt(s[3]);
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				tileId[i][j] = Integer.parseInt(s[i + j * width + 4]);
			}
		}

		// setting entity manager
		h.setEm(em);

		// creating player
		Game.PLAYER_FINAL.setX(spawnX);
		Game.PLAYER_FINAL.setY(spawnY);
		Game.PLAYER_FINAL.settX(spawnX);
		Game.PLAYER_FINAL.settY(spawnY);

		em.creatureAdd(Game.PLAYER_FINAL);
	}

	// method that can be accessed when creating worlds to manually set spawn
	public World setSpawn(int spawnX, int spawnY) {
		this.spawnX = spawnX;
		this.spawnY = spawnY;
		Game.PLAYER_FINAL.setX(spawnX);
		Game.PLAYER_FINAL.setY(spawnY);
		Game.PLAYER_FINAL.settX(spawnX);
		Game.PLAYER_FINAL.settY(spawnY);
//		System.out.println("Spawn set");
		return this;
	}

	public World persistHealth(int i) {
		Game.PLAYER_FINAL.setInitHealth(i);
		return this;
	}

	public int getSpawnX() {
		return spawnX;
	}

	public int getSpawnY() {
		return spawnY;
	}

	// rendering world and all entities in that world
	public void render(Graphics2D g2d) {

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Tile.getTile(tileId[i][j]).render(g2d, i * Tile.SIZE - (int) h.getGame().getGC().getXOffset(),
						j * Tile.SIZE - (int) h.getGame().getGC().getYOffset());
			}
		}
		for (StaticEntity e : em.getSEntity()) {
			e.render(g2d);
		}
		for (Creature c : em.getCreature()) {
			c.render(g2d);
		}

	}

	// update world and all entities in world
	public void tick() {

		// center game on player
		h.getGame().getGC().centerOnEntity(Game.PLAYER_FINAL);

		// checking if any creature should be removed
		for (int i = 0; i < h.getEm().getCreature().size(); i++) {
			h.getEm().getCreature().get(i).tick();
			if (h.getEm().getCreature().get(i).getHealth() <= 0) {
				h.getEm().getCreature().get(i).die();

			}

		}
		// checking collisions with static entities
		for (int i = 0; i < em.getSEntity().size(); i++) {
			em.getSEntity().get(i).tick();
//			System.out.println(i);
		}
	}

	public Creature getPlayer() {
		return Game.PLAYER_FINAL;
	}

	// getting tile id at location
	public Tile getTile(int x, int y) {
		if (x > width - 1 || x < 0 || y > height - 1 || y < 0)
			return Tile.grassTile;
		return Tile.getTile(tileId[x][y]);
	}

	// getting array of all tile id's
	public int[][] getTileId() {
		return tileId;
	}

}
