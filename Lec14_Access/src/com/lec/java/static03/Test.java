package com.lec.java.static03;

public class Test {

	private int num;

	static int count = 0;
//==================================================
	// Singleton 패턴
	// 기본생성자
	private Test() {
		count++; // 생성자가 생성될 때마다 일씩 증가
		System.out.println(count + "번째 인스턴스 생성");
	}

	// getter & setter
	private static Test instance = null;

	public static Test getInstance() {
		if (instance == null) {
			instance = new Test();
		}
		return instance;
	}
	//===============================================

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
