package com.tycoon.gfx.overlay;

import com.tycoon.util.Handler;

public class MenuManager {
	
	private static Menus currentMenu;
	private static Handler ha;
	
	public static Menus superMenu;
	
	//manages current menu
	
	public MenuManager(){
		
	}
	
	public static void setHandler(Handler h){
		ha = h;
	}
	
	public static void init(){
		superMenu = new SuperMenu(ha);
	}
	
	public static void setCurrentMenu(Menus m){
		currentMenu = m;
	}
	public static Menus getCurrentMenu(){
		return currentMenu;
	}
}
