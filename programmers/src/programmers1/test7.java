package programmers1;

import java.util.Arrays;

public class test7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 동적계획법(Dynamic Programming)
		// lv.3
		System.out.println("Hello programmers");

		int[][] triangle = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
		int result = solution(triangle);
		System.out.println("답 : " + result);
	}

	int max = 0;

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public static int solution(int[][] triangle) {
		int answer = 0;
		
		solution(0, triangle, 0, 0);
		
		return answer;
	}

	public static void solution(int step, int[][] triangle, int cnt, int back) {
		if (step == 5) {
			System.out.println(cnt);
			return;
		}

		int count;
		for (int i = 0; i < 2; i++) {
			if (step == 0 && i == 1) break;

			count = cnt + triangle[step][back + i];
			
			solution(step + 1, triangle, count, back + i);
		}
	}

}
