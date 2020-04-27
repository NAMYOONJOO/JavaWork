package com.lec.java.class04;
/*
   클래스 안에서 this : 
	객체 내에서 자기자신(인스턴스)을 가리킴

   메소드 체이닝 (method chaining)
 	자기자신을 리턴하여, 연이어 메소드
 	호출 가능케 하는 메소드 설계
 	보통 setter 와 이와 같은 동작을 수행하는 메소드들에 적용하면 좋다
*/
public class Class04Main {

	public static void main(String[] args) {
		System.out.println("this & 메소드 체이닝");
		
		Number n1 = new Number();
		System.out.println("n1.num ="+n1.getNum());
		
		Number n2 = new Number(123);
		n1.add(n2); //n1 이 변한다. 
		System.out.println("n1.num ="+n1.getNum());
		//100+123
		
		Number n3 = new Number(10);
		n1.sub(n3);//213
		System.out.println("n1.num ="+n1.getNum());
		
		n1.sub(new Number(100));//
		System.out.println("n1.num ="+n1.getNum());
		
		
		System.out.println();
		n1.setNum(100);
		
		n1.add(n2).sub(n3).add(new Number(100)); //한줄로 가능
		//메소드 체이닝 : 자기자신을 리턴,
		
		System.out.println("n1.num ="+n1.getNum());
		
		Number n4 = new Number();
		n4.setNum1(10);
		n4.setNum2(20);
		n4.setNum3(30);
		n4.setNum4(40);
		n4.setNum5(50);
		n4.setNum6(60);
		//메소드 체이닝
		n4.setNum1(10)
			.setNum2(20)
			.setNum3(30)
			.setNum4(40)
			.setNum5(50)
			.setNum6(60);
		
		System.out.println("프로그램 종료");
	} // end main()

} // end class Class04Main










