package com.lec.java.wrapper05;

/* Wrapper 클래스의 유용성
 * 1. Object 타입이 모~든 (심지어 primitive) 타입도 받을수 있다.
 * 2. Collection 과 같은 Generic 클래스에선
 *     primitive 타입을 담을수 없다. 그러나 ,Wrapper 를 통해 가능하다.
 */
public class Wrapper05Main {

	public static void main(String[] args) {
		System.out.println("Wrapper 클래스의 유용성");
		
		Object[] obj = new Object[5];
		obj[0]=new Wrapper05Main();
		obj[1]=new A(); 
		obj[2]=new A2(); 
		obj[3]=new B();
		obj[4]=123; //Object가 primitive type도 받을 수 있다.!?
			//이유 : Auto - Boxing + Polymorphism(다형성)
			// Object <---Integer <-- int
		
		for(Object e : obj) {
			System.out.println(e);
		}
		//obj[5] 출력 123 -----> Wrapper는 알아서 Auto unboxing발생
		
		System.out.println();
		//실타입이 Object 이면
		//auto- unboxing 등이 필요한 연산식에선 '형변환' 해주어야 동작한다.
		//int num = obj[4]*3;  ------>Object와 곱하기로 인식해 에러발생  : 형변환 필요
		int num = (Integer)obj[4]*3;
				
		System.out.println("\n프로그램 종료");
	} // end main()

	// TODO
	
} // end class

class A{
	
}
class A2 extends A{
	
}
class B{
	
}