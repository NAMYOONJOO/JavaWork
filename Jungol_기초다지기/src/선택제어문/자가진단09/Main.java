package 선택제어문.자가진단09;

import java.util.Scanner;

/*
 * 3개의 정수를 입력받아 조건연산자를 이용하여 입력받은 수들 중 최소값을 출력하는 프로그램을 작성하시오.
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		
		if(num1>num2) {
			if(num2>num3) {
				System.out.println(num3);
			}else
				System.out.println(num2);
		}else {
			if(num1>num3) {
				System.out.println(num3);
			}else
				System.out.println(num1);
			
		}
		
		sc.close();
		
	}

}
