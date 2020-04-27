package com.lec.java.class04;

public class Number {
	private int num = 100; // 멤버변수 선언시 초깃값 명시 가능
	// 생성자
	// 매개변수 받는 생성자

	public Number() {
	}

	public Number(int num) {
		this.num = num;
	}

	// getter& setter
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	
	public Number add(Number x) {
		this.num +=x.num;
		return this;
	}
	
	public Number sub(Number x) {
		this.num -=x.num;
		return this;
	}
	
	//set 해야 할 멤버변수가 많~은 경우
	//setter들을 메소드 체이닝 하면 편리
	private int num1;
	private int num2;
	private int num3;
	private int num4;
	private int num5;
	private int num6;

	public Number setNum1(int num1) {
		this.num1 = num1;
		return this;
	}

	public Number setNum2(int num2) {
		this.num2 = num2;
		return this;
	}

	public Number setNum3(int num3) {
		this.num3 = num3;
		return this;
	}

	public Number setNum4(int num4) {
		this.num4 = num4;
		return this;
	}

	public Number setNum5(int num5) {
		this.num5 = num5;
		return this;
	}

	public Number setNum6(int num6) {
		this.num6 = num6;
		return this;
	}
}
