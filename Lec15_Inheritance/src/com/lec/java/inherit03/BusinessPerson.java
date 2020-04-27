package com.lec.java.inherit03;

public class BusinessPerson extends Person { // 다중상속을 허용하지 않는다. (단일상속)

	String company;
	public void showInfo() {
		whoAmI();
		System.out.println("회사는"+company+"입니다.");
	}
	
	
	
}
