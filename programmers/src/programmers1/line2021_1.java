package programmers1;

import java.util.HashMap;
import java.util.Map;

public class line2021_1 {

	public static void main(String[] args) {

		System.out.println("hello line");
		System.out.println(5 % 2);
	}

	public static int solution(int[][] boxes) {
		int answer = 0;

		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();

		// 발생빈도
		for (int i = 0; i < boxes.length; i++) {
			for (int j = 0; j < 2; j++) {
				
				Integer v = hmap.get(boxes[i][j]);
				if (v == null) {
					hmap.put(boxes[i][j], 1);
				} else {
					hmap.put(boxes[i][j], v + 1);
				}
			}
		}
		// 결과출력
		for (Map.Entry<Integer, Integer> e : hmap.entrySet()) {
			//System.out.println(e.getKey() + " : " + e.getValue() + "개");
			if(e.getValue()%2==1)answer++;
			
		}

		answer = answer / 2;
		return answer;
	}

}
