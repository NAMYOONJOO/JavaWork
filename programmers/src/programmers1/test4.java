package programmers1;

import java.util.Arrays;

public class test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//깊이/너비 우선 탐색(DFS/BFS) 
		//lv.2
		

		System.out.println("Hello programmers");
		
		int[] numbers = {1,1,1,1,1};
		int target = 3;
		int result = solution(numbers, target);
		System.out.println("답 : "+result);

	}

	public static int solution(int[] numbers, int target) {
		int answer = 0;
		for (int i = 0; i < Math.pow(2,numbers.length); i++) {
			int num = i; //부호
			int result = 0;
			for (int j = 0; j < numbers.length; j++) {
				if(num%2==1) {//+
					result += numbers[j];
					num = num/2;
				}else { //-
					result -= numbers[j];
					num = num/2;
					
				}
			}
			if (result==target) {
				answer++;
			}
		}
		return answer;
	}

}
