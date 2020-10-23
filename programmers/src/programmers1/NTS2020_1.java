package programmers1;

import java.util.HashMap;
import java.util.Map;

public class NTS2020_1 {

	public static void main(String[] args) {

		System.out.println("hello NTS");
		int[][] flowers = { { 2, 5 }, { 3, 7 }, { 10, 11 } };
	
		int result = solution(flowers);
		System.out.println(result);
		
		
		
	}

	public static int solution(int[][] flowers) {
		int answer = 0;

		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();

		// 발생빈도
		for (int i = 0; i < flowers.length; i++) {
			
			for(int j = flowers[i][0];j<flowers[i][1];j++) {
				Integer v = hmap.get(j);
				if (v == null) {// 기존에 해당 key값이 없었다면 (즉! 첫 등장이면)
					hmap.put(j, 1);
				} else {
					hmap.put(j, v + 1);// 기존 등장횟수에 +1
				}
			}
			
		}
		// 결과출력
	
		answer = hmap.size();
		return answer;
	}

}
