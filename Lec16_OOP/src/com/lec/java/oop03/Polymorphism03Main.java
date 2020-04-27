package com.lec.java.oop03;

public class Polymorphism03Main {

	public static void main(String[] args) {
		System.out.println("다형성의 어려움");

		Vehicle car1 = new Vehicle();
		Vehicle car2 = new Car();
		Vehicle car3 = new HybridCar();

		car2.setSpeed(10);
		// car2.setOil() --->에러
		// car2는 Vehicle 타입으로 선언되어 있으므로,
		// Vehicle이 아니 다른 클래스(심지어 자식 클래스이더라도)에 정의된
		// 메소드는 사용할 수 없다.
		// 따라서, 실제로는 Car 타입 인스턴스로 생성되긴 했지만,
		// Vehicle 타입 참조변수로는 Car 클래스에 있는 메소드를 사용할 수 없다

		System.out.println("\n 프로그램 종료");

		((Car) car2).setOil(100);
		// 실제로 Car 클래스의 인스턴스로 생성된 car2 변수는
		// 형변환(casting)을 통해서 Car 타입으로 변환할 수 있고,
		// Car 클래스에 정의된 메소드를 사용할 수 있다.

		// ((Car)car1).setOil(10); //classcastException
		// ClassCastException 발생:
		// 실제로 Vehicle 클래스의 인스턴스로 생성된 car1을
		// 자식 클래스인 Car로 강제 형변환을 하게 되면 문제가 발생할 수 있다.
		// 예외는 setOil() 을 호출하는 과정이 아니라, 형변환 하는 과정에서 발생된다

	} // end main()

} // end class
