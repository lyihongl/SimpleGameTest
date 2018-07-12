package com.tycoon;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import com.tycoon.entity.Creature;
import com.tycoon.entity.Player;
import com.tycoon.gfx.Assets;
import com.tycoon.gfx.GameCamera;
import com.tycoon.gfx.overlay.MenuManager;
import com.tycoon.input.KeyManager;
import com.tycoon.input.TimedKeyManager;
import com.tycoon.inventory.Inventory;
import com.tycoon.item.equipment.EqManager;
import com.tycoon.item.usable.HealthDrop;
import com.tycoon.states.GameState;
import com.tycoon.states.State;
import com.tycoon.util.Handler;

//Title: Merchant's World
//Programmed by: Yihong
//Version: 1.05 Alpha
//School: Western Canada High School

public class Game implements Runnable {

	// title
	public static final String TITLE = "1.05 Alpha";

	// game frame
	private JFrame frame;
	private Canvas canvas;

	// width height of game
	private int width, height;

	// thread running
	private boolean running = false;
	private Thread thread;

	// graphics
	private BufferStrategy bs;
	private Graphics2D g2d;

	// handler
	private Handler handler;

	// input
	private KeyManager km;
	private TimedKeyManager tkm;

	// Game states
	private State gameState;

	// Game Camera
	private GameCamera gc;

	// game inv
	private Inventory inv;
	private EqManager eqM;

	// player
	public static Creature PLAYER_FINAL;

	public Game(int width, int height) {
		this.width = width;
		this.height = height;
	}

	// init game
	public void init() {

		// inventory
		inv = new Inventory();
		eqM = new EqManager();

		// handler
		handler = new Handler(this);
		PLAYER_FINAL = new Player(handler, 0, 0).setHealthInit(10);
//		PLAYER_FINAL.setArmor(1000);
		// Game camera
		gc = new GameCamera(handler);

		// game state
		gameState = new GameState(handler);
		State.setState(gameState);

		// set inv
		handler.setInv(inv);
		handler.setEqM(eqM);
		
		//init health drop, (complications with ring system, so has to be done here)
		HealthDrop.setHeal(5);

		// init input getters
		km = new KeyManager();
		tkm = new TimedKeyManager();
		
		MenuManager.setHandler(handler);
		MenuManager.init();
		MenuManager.setCurrentMenu(MenuManager.superMenu);

		// init frame
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setResizable(false);
		frame.addKeyListener(km);
		frame.addKeyListener(tkm);
		frame.setTitle(TITLE);

		// init canvas
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		canvas.setBackground(Color.BLACK);

		// adding things to frame
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);

	}

	// render
	public void render() {
		bs = canvas.getBufferStrategy();
		if (bs == null) {
			canvas.createBufferStrategy(3);
			return;
		}
		g2d = (Graphics2D) bs.getDrawGraphics();
		g2d.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		if (State.getCurretState() != null)
			State.getCurretState().render(g2d);

		bs.show();
		g2d.dispose();
	}

	// update game
	public void tick() {
		if (State.getCurretState() != null)
			State.getCurretState().tick();
		// gc.tick();
		
	}

	// start game thread
	public synchronized void start() {
		if (running)
			return;
		running = true;
		// init thread
		thread = new Thread(this);
		thread.start();
	}

	// stop game thread
	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {

		// init game
		Assets.initAssets();
		init();

		// fps
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();

		while (running) {
			// fps calculations
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			lastTime = now;

			if (delta >= 1) {
				tick();
				render();
				delta = 0;
			}
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public KeyManager getKm() {
		return km;
	}

	public GameCamera getGC() {
		return gc;
	}

	public Inventory getInv() {
		return inv;
	}

	public static void main(String[] args) {
		Game g = new Game(900, 700);
		g.start();
		// System.out.println(ItemNames.values()[0]); 
		
	}
}