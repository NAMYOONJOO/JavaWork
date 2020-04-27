package 선택제어문.자가진단04;

import java.util.Scanner;

/*
 * 복싱체급은 몸무게가 50.80kg 이하를 Flyweight 61.23kg 
 * 이하를 Lightweight, 72.57kg 이하를 Middleweight, 
 * 88.45kg 이하를 Cruiserweight, 88.45kg 초과를 Heavyweight라고 하자.

몸무게를 입력받아 체급을 출력하는 프로그램을 작성하시오.
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double weight = sc.nextDouble();
		
		if(weight<=50.80) {
			System.out.println("Flyweight");
		}else if(weight<=61.23) {
			System.out.println("Lightweight");
		}else if(weight<=72.57) {
			System.out.println("Middleweight");
		}else if(weight<=88.45) {
			System.out.println("Cruiserweight");
		}else if(weight>88.45) {
			System.out.println("Heavyweight");
		}

	}

}
