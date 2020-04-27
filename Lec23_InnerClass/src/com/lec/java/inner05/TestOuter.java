package com.lec.java.inner05;

public class TestOuter {
	// TestOuter 클래스의 멤버 변수
	private int num1 = 100;

	// TestOuter 클래스의 멤버 메소드
	public void localMethod(final int num4) {
		int num2 = 200;// localMethod()의 지역변수
//		 effectively final 변수란?
//		 1) final로 선언된 변수, 또는
//		 2) 한 번 초기화가 된 이후로 값이 변경되지 않은 변수(Java 8에서 도입)
//		num4=500----->에러
		// Local inner class
		class TestLocal {
			// 멤버변수
			private int num3 = 300;

			// 멤버 메소드
			public void showNumber() {
				System.out.println("num1 = " + num1); // 외부클래스 멤버
				System.out.println("num2 = " + num2); // class와 같은 local의 지역변수
				System.out.println("num3 = " + num3); // 자기자신의 멤버변수
				System.out.println("num4 = " + num4); 
			}
		}

		TestLocal local = new TestLocal();
		// num2 값을 변경하면.. 아래 showNumbers()에선
		// 200 이 찍혀야 하나? 400이 찍혀야 하나?
		// 그래서 로컬내부클래스에서 사용 가능한 지역의 변수는
		// 반드시 effectively final 이어야 한다
		// 즉 한번 초기화 된후 값이 변경되지 않거나, final 이어야 한다.

//		num2 = 400;--->에러
		local.showNumber();
	} // end localMethod()

} // end class TestOuter
