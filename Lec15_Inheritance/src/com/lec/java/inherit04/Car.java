package com.lec.java.inherit04;

public class Car extends Vehicle {

	int oil;

	public Car() {
		// 부모클래스의 생성자 호출 -->Vehicle()
		// 명시적으로 super 생성자가 없으면 부모의 기본 생성자를 호출
		System.out.println("Car() 생성");
	}

	public Car(int oil) {
		//super()는 반드시 생성자코드의 '첫번째 문장'이어야함
		super();// super : 부모를 의미 , super() <---부모의 기본생성자 호출
		this.oil=oil;
		System.out.println("Car(int) 생성 : oil = " + oil);
	}

	public Car(int speed, int oil) {
		super(speed); // super(int)
		this.oil = oil;
		System.out.println("Car(int, int) 생성 : speed=" + speed+ "oil ="+oil);

	}
	public Car(double value) {
		this(555,(int)value);
		//this(,) 다른 생성자에게 자신의 갑ㅅ을 주어 호출하는 것 , super 불가능
		System.out.println("Car(double) 생성 : value = " +value);
	}

}
