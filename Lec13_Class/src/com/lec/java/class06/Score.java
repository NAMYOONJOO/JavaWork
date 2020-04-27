package com.lec.java.class06;

public class Score {
	// 멤버변수 : 
	// 	학생 이름 String
	private String student;
	// 	국어점수 int 
	private int korean;
	// 	수학점수 int
	private int math;
	// 	영어점수 int
	private int english;
	
	// 생성자: 멤버 변수 초기화
	//   1) 디폴트 생성자
	public Score() {
		super();
	}

	//   2) 매개변수 받는 생성자 (이름, 국어점수, 수학점수, 영어점수)
	public Score(String student, int korean, int math, int english) {
		super();
		this.student = student;
		this.korean = korean;
		this.math = math;
		this.english = english;
	}
	
	// 메소드
	// 총점계산 메소드
	// 메소드이름 :calcTotal()
	// 리턴타입 : int
	public int calcTotal() {
		return this.korean+this.math+this.english;
	}
	
	// 평균계산 메소드
	// 메소드 이름 : calcAvg()
	// 리턴타입 : double
	public double calcAvg() {
		return this.calcTotal()/3;
	}
	
	// 메소드
	// 이름: displayInfo()
	// 리턴: void
	// 매개변수: none
	//   학생의 이름, 국어, 영어, 수학 점수 출력
	// TODO
	public void displayInfo() {
		System.out.println("국어 : "+this.korean);
		System.out.println("수학 : "+this.math);
		System.out.println("영어 : "+this.english);
	}
	
	
}


















