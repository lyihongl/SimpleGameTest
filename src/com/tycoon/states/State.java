package com.tycoon.states;

import java.awt.Graphics2D;

import com.tycoon.util.Handler;

public abstract class State {
	
	
	//parent class of all states
	protected static State currentState = null;
	protected Handler h;
	public State(Handler h){
		this.h = h;
	}
	
	public abstract void render(Graphics2D g2d);
	public abstract void tick();
	
	public static void setState(State state){
		currentState = state;
	}
	
	public static State getCurretState(){
		return currentState;
	}
	
}
