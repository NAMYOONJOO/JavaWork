package programmers1;

import java.util.Arrays;

public class test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 깊이/너비 우선 탐색(DFS/BFS)
		// lv.2
		// test 4 모범답안
		System.out.println("Hello programmers");

		int[] numbers = { 1, 1, 1, 1, 1 };
		int target = 3;
		int result = solution(numbers, target);
		System.out.println("답 : " + result);

	}

	public static int solution(int[] numbers, int target) {
		int answer = 0;
		answer = dfs(numbers, 0, 0, target);
		return answer;
	}

	public static int dfs(int[] numbers, int n, int sum, int target) {
		if (n == numbers.length) {
			if (sum == target) {
				return 1;
			}
			return 0;
		}
		return dfs(numbers, n + 1, sum + numbers[n], target) + dfs(numbers, n + 1, sum - numbers[n], target);
	}

}
