package com.lec.java.exception08;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception08Main {

	static Scanner sc = new Scanner(System.in);

	// TODO : AgeInputException 을 throws 하는 메소드 정의
	public static int inputAge() throws AgeInputException {
		System.out.println("나이 입력:");
		int age = sc.nextInt();

		if (age < 0 || age > 1000) {
			AgeInputException ex = new AgeInputException();
			throw ex;
		}

		return age;

	} // end inputAge()

	public static void main(String[] args) {
		System.out.println("예외 클래스 만들기 2");

		int i = 0;
		while (i < 5) {
			try {
				int age = inputAge();
				i++;
			} catch (AgeInputException e) {
				System.out.println(e.getMessage());
			}catch (InputMismatchException ex) {
				System.out.println(ex.getMessage());
				System.out.println("적절하지 않은 입력값입니다. ");
				sc.nextLine();
			}
		}

		System.out.println("프로그램 종료...");

	} // end main()

} // end class Exception08Main
