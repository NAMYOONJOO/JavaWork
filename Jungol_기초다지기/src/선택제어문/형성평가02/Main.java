package 선택제어문.형성평가02;

import java.util.Scanner;

//정수를 입력받아 0 이면 "zero" 양수이면 "plus" 음수이면 "minus" 라고 출력하는 프로그램을 작성하시오.



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		if (num==0) {
			System.out.println("zero");
			
		}else if(num<0) {
			System.out.println("minus");
		}else {
			System.out.println("plus");
		}
	}

}
