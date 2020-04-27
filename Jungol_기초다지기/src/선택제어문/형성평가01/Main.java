package 선택제어문.형성평가01;

import java.util.Scanner;

//두 개의 정수를 입력받아 큰 수에서 작은 수를 뺀 차를 출력하는 프로그램을 작성하시오.
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		if(num1>num2) {
			System.out.println(num1-num2);
		}else
			System.out.println(num2-num1);
		
		sc.close();
	}

}
