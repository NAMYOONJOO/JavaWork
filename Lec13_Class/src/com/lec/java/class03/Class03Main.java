package com.lec.java.class03;

/*
	캡슐화, 은닉, 추상화

	클래스 안에 필요한 '속성' 과 '행동' 을 멤버로 묶고
	외부에서의 '직접적인 접근을 제한'하여
	객체의 데이터 와 메소드를 은닉(hiding)하고, 
	사용자에게는 필요한 기능만 제공하여 추상화(abstraction) 하는   
	객체지향 기술을 '캡슐화(encapsulation)' 라고 한다
	
	
	클래스의 멤버변수를 접근하기 위한 기능을 제공하는 메소드를 
	getter , setter 라 한다
*/
public class Class03Main {

	public static void main(String[] args) {
		System.out.println("Getter & Setter");
		
		Number n1 = new Number(100,'A');
		//n1.num=200;//private :데이터은닉 /다른클래스에서 사용불가
		// not visible
		//n1.name = 400;name cannot be resolved or is not a field
		
		System.out.println(n1.getNum());
		n1.setNum(200);
		System.out.println(n1.getNum());
		n1.setNum(-1); //데이터 보호 가능
		System.out.println(n1.getNum());
		
		
		
		System.out.println("프로그램 종료");
	} // end main()
} // end class Class03Main














