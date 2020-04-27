package practice.stddev;

import java.util.Random;

public class StdDev {

	public static void main(String[] args) {

		// 임의정수 5개로 초기화한 정수로
		// 평균, 분산, 표준편차 구하기
		int[] num = new int[5];
		Random rand = new Random();
		for (int i = 0; i < num.length; i++) {
			num[i] = rand.nextInt(100) + 1;
			System.out.print(num[i] + " ");
		}
		System.out.println();
		System.out.println("평균 : " + calcAvg(num));
		System.out.println("분산 : " + calcVariance(num));
		System.out.println("표준편차 : " + calcStdDev(num));

	} // end main

	/**
	 * 메소드 이름 : calcAvg 매개변수 : int [] 리턴값 : double
	 * 
	 * 주어진 배열의 '평균값' 리턴
	 */
	public static double calcAvg(int[] num) {
		double avg = 0;
		int total = 0;
		for (int i = 0; i < num.length; i++) {
			total += num[i];
		}
		avg = (double) total / num.length;
		return avg;
	}

	/**
	 * 메소드 이름 : calcVariance 매개변수 : int [] 리턴값 : double
	 * 
	 * 주어진 배열의 '분산값' 리턴
	 */
	public static double calcVariance(int[] num) {
		double var = 0;// 분산값
		double avg = calcAvg(num); // 평균
		double sum2 = 0; // 편차제곱의 합
		for (int i = 0; i < num.length; i++) {
			sum2 += (num[i] - avg) * (num[i] - avg);//편차제곱
		}
		var = sum2 / num.length;

		return var;
	}

	/**
	 * 메소드 이름 : calcStdDev 매개변수 : int [] 리턴값 : double
	 * 
	 * 주어진 배열의 '표준편차' 리턴
	 */
	public static double calcStdDev(int[] num) {
		double var = calcVariance(num);// 분산값
		double dev = Math.sqrt(var); //Math.sqrt() : 제곱근
		return dev;
	}

} // end class
