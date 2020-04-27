package com.lec.java.collection03;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class Collection03Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");

		// TODO:
		// Student 타입을 담는 ArrayList를 만드고
		// 사용자로부터 3개의 Student 데이터 을 입력받아서
		// (id, name, kor, eng, math)
		// 3가지 방법으로 출력해보세요.
		// for, Enhanced-for, Iterator
		ArrayList<Student> student = new ArrayList<Student>(3);

		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			System.out.println("id :");
			int id = sc.nextInt();
			System.out.println("name :");
			String name = sc.next();
			System.out.println("kor :");
			int kor = sc.nextInt();
			System.out.println("eng :");
			int eng = sc.nextInt();
			System.out.println("math :");
			int math = sc.nextInt();

			Score score = new Score(kor, eng, math);
			Student student1 = new Student(id, name, score);

			student.add(student1);

		}
		sc.close();
		for (Student e : student) {
			System.out.println(e);
		}

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
