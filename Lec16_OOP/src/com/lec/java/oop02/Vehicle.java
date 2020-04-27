package com.lec.java.oop02;

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
