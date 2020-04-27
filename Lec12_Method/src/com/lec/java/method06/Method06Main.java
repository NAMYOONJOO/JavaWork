package com.lec.java.method06;

/* Method Overloading (메소드 중복 정의)
	 같은 이름으로 메소드를 매개변수 리스트를 달리하여 중복 정의, ********중요하당 면접에서 물어보면 대답할 줄 알아야된다. 
	 즉, 이름이 같아도 메소드 signature 가 다르면 중복정의 가능.
	
  Method Signature 란
	   메소드 이름 + 매개변수 리스트 (parameter list)
	
	 1. 매개변수의 개수가 다르거나
	 2. 매개변수의 자료형이 다르거나
	 3. 매개변수의 순서가 다를 때
	 위 3개를 '매개변수 리스트' 라 한다
	
    메소드의 리턴 타입만 다른 경우는 중복 정의할 수 없다!!

     메소드 오버로딩의 장점:
	동일한 동작을 하는 메소드에 대해 매개변수만 달리하여 중복정의 하면
	이 메소드를 사용하는 입장에선 여러타입의 이름을 익힐 필요가 없다. 

 */

public class Method06Main {

	public static void main(String[] args) {
		System.out.println("Method Overloading (메소드 중복 정의)");

		sayHello();
		sayHello("우경이애기");
		sayHello(3);
		sayHello ("우경이검은콩", 5);
		sayHello (5, "김우경 밥보");
		
		byte b = 10;
		sayHello(b);//byte type -> int type으로 자동 형변한
		//short 버전 메소드가 선언되면 int메소드가 아닌 short 메소드호출이된다.
		
		
		//**** 메소드 오버로딩의 장점
		System.out.println(10);
		System.out.println(3.14);
		System.out.println("Hello");//이미 누리고 있다 
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

	// 1
	public static void sayHello() { // Signature : sayHello()
		System.out.println("sayHello() 호출");
		System.out.println("안녕하세요");
	}

	// 2 메소드 오버로딩
	// 자바에서는 완전히 다른 메소드로 취급한다.
	public static void sayHello(String name) {// Signature ; sayHello(String)
		System.out.println("sayHello(String) 호출");
		System.out.println("Hi~");
		System.out.println("제이름은 " + name + "입니다~");

	}

	// 3-1
	public static void sayHello(int age) { // Signature : sayHello (int)
		System.out.println("sayHello(int) 호출");
		System.out.println("My age is "+ age);
	}
	
	// 3-2 //오버로딩 성립
	public static void sayHello(short age) { // Signature : sayHello (int)
		System.out.println("sayHello(int) 호출");
		System.out.println("My age is "+ age);
	}
	
	//4
	public static void sayHello(String name, int age) { //Signature : sayHello(String, int)
		System.out.println("sayHello(String, int) 호출");
		System.out.println("안녕!");
		System.out.println("내이름은 "+name+"이야!");
		System.out.println("나는 "+age+"짤이야!");
	}
	//5 매개변수의 순서가 다르기때문에 오버로딩 가능
	public static void sayHello(int age, String name) { //Signature : sayHello(int, string)
		System.out.println("sayHello(int, String) 호출");
		System.out.println("안녕!");
		System.out.println("내이름은 "+name+"이야!");
		System.out.println("나는 "+age+"짤이야!");
	}
	
	/*
	 * public static int sayHello() { return 0; } //리턴타입 다르다고 오버로딩 안된다.
	 */

} // end class
