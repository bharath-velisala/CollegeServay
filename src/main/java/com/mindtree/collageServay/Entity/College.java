package com.mindtree.collageServay.Entity;

public class College {
	private String collageName;
	private int strength;
	public College() {
		super();
		// TODO Auto-generated constructor stub
	}
	public College(String collageName, int strength) {
		super();
		this.collageName = collageName;
		this.strength = strength;
	}
	public String getCollageName() {
		return collageName;
	}
	public void setCollageName(String collageName) {
		this.collageName = collageName;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	
	
	
}
