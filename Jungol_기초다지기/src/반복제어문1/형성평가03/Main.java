package 반복제어문1.형성평가03;

import java.util.Scanner;

/*0 부터 100 까지의 점수를 계속 입력받다가 범위를 벗어나는 수가 입력되면 그 이전까지
 *  입력된 자료의 합계와 평균을 출력하는 프로그램을 작성하시오.

sum : 239
avg : 47.8
(평균은 반올림하여 소수 첫째자리까지 출력한다.)
*/
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int count = 0, sum = 0;
		while(true) {
			int num = sc.nextInt();
			if(num<=100&&num>=0) {
				count ++;
				sum += num;
			}else {
				System.out.println("sum : "+sum);
				System.out.printf("avg : %.1f",(double)sum/count
						);
				break;
			}
		}
		sc.close();

	}

}
