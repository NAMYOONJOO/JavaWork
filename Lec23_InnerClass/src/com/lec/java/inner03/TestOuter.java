package com.lec.java.inner03;

public class TestOuter {
	private int value;//1. OuterValue
	
	public TestOuter(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	// 멤버 내부 클래스
	public class TestInner{
		private int value;//2. InnerValue
		public TestInner(int value) {
			this.value = value;
		}
		public void printValue() {
			int value = 10;//지역변수 value
			System.out.println("value = " +value);
			System.out.println("this.value : "+this.value);//InnerCalss 의 value값
			System.out.println("TestOuter.this.value : "+TestOuter.this.value); //OuterClass value
			//실무코드에서 보기 힘들다
		}
	}
	

} // end class TestOuter














