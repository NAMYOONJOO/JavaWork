package com.lec.java.exception08;

// TODO : Exception 상속받은 예외 클래스 만들기
public class AgeInputException extends Exception {

	public AgeInputException() {
		super("유효한 나이가 아닙니다.");
	}
	
	public AgeInputException(String str) {
		super(str);
	}
	
} // end class AgeInputException
