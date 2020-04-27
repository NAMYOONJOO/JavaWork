package 배열1.자가진단09;

import java.util.Scanner;

/*
 10개의 정수를 입력받아 배열에 저장한 후 내림차순으로 정렬하여 출력하시오.
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = new int[10];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i <= 9; i++) {
			num[i] = sc.nextInt();
		}

		for (int j = num.length - 1; j > 0; j--) {
			for (int i = 0; i < j; i++) {
				if (num[i] < num[i + 1]) {
					int temp = num[i];
					num[i] = num[i + 1];
					num[i + 1] = temp;
				}
			}
		}
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
		System.out.println();
	}

}
