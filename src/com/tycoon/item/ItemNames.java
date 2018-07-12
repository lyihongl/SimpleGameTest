package com.tycoon.item;

public enum ItemNames {
	
	coin("coin"),
	healthDrop("Health Pack");
	
	private String name;
	
	ItemNames(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
}	
