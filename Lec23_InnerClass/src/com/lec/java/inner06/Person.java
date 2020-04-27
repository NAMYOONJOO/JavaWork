package com.lec.java.inner06;

public class Person {
	// Person 외부 클래스의 멤버 변수
	private String name;

	// Person 외부 클래스의 생성자
	public Person(String name) {
		this.name = name;
	}

	/*
	 * public void createInstance(int age){ //local inner class class PersonAge{
	 * public void readInfo() { System.out.println("이름"+ name);
	 * System.out.println("나이"+ age); }
	 * 
	 * } PersonAge p = new PersonAge(); return p; //p.readInfo(); }
	 * 
	 */
	/*
	 * 지역 클래스는 메소드 실행이 끝나게 되면 정의 자체가 사라지게 되는 클래스임. 메소드 내부에 정의된 지역 클래스 타입을 리턴하는 메소드는
	 * 만들 수 없다. 경우에 따라서는, 지역 클래스에 정의된 메소드를 외부에서 직접 사용하고자 하는 경우가 발생할 수도 있습니다. 그걸 가능하게
	 * 하는 방법이
	 * 
	 * 인터페이스(interface) + 다형성(polymorphism):
	 * 
	 * 1. 외부에서 사용하고 싶은 메소드를 선언한 인터페이스를 작성 2. 메소드의 리턴타입은 정의한 인터페이스 타입으로 정의 3. 로컬 클래스는
	 * 인터페이스를 구현(implements)하도록 정의 4. 로컬 클래스의 인스턴스를 생성하고 리턴해줌
	 */
	// 2
	public Readable createInstance(int age) {
		// 3.
		class PersonAge implements Readable {

			@Override
			public void readInfo() {
				System.out.println("이름 : " + name);
				System.out.println("나이 : " + age);

			}

		}// end PersonAge
		//4.
		Readable person = new PersonAge(); //다형성
		return person;
	
	}

} // end class Person

//1.
interface Readable {
	public abstract void readInfo();
}
