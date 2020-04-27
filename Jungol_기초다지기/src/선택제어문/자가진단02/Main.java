package 선택제어문.자가진단02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();//몸무게
		int num2 = sc.nextInt();//키
		
		int num3 = num1+100-num2;
		
		System.out.println(num3);
		if(num3>=0)System.out.println("Obesity");

	}

}
