package com.lec.java.oop03;

public class Vehicle {
	private int speed;
	
	public int getSpeed() {
		return this.speed;
	}
	public void setSpeed(int Speed) {
		this.speed = Speed;
	}
	public void displayInfo() {
		System.out.println("---- vigicle정보----");
		System.out.println("speed:"+speed);
	}
	
	
}
