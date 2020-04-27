package com.lec.java.static03;

import java.util.Calendar;

//Singleton 디자인패턴
// 생성되는 인스턴스가 최대 1개까지만 허용해야 하는 패턴 설계
public class Static03Main {

	public static void main(String[] args) {
		System.out.println("Singleton 디자인 패턴");
//		
//		Test t1 = new Test();
//		Test t2 = new Test();
		Test t1 = Test.getInstance(); //이제 new는 안된다
		System.out.println("t1:num = "+t1.getNum());
		t1.setNum(123);
		System.out.println("t1:num = "+t1.getNum());
		
		Test t2 = Test.getInstance();
		System.out.println("t2:num = "+t2.getNum());
//이 부분을 메모리상에 그릴줄 알아야 한다. 		
		
		t2.setNum(500);
		System.out.println("t1:num = "+t1.getNum());//500
		
		
		//Singleton 사용 예
		//Calendar c = mew Calendar(); ->생성자 제공안함
		Calendar c = Calendar.getInstance();
		
	} // end main()

} // end class Static03Main











