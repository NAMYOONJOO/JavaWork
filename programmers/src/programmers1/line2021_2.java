package programmers1;

import java.util.ArrayList;
import java.util.List;

public class line2021_2 {

	public static void main(String[] args) {

		System.out.println("hello line");
		int[] ball = { 1, 2, 3, 4, 5, 6 };
		int[] order = { 6, 2, 5, 1, 4, 3 };
		int[] result = solution(ball, order);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
		}
	}

	public static int[] solution(int[] ball, int[] order) {
		int[] answer = new int[order.length];

		List<Integer> list = new ArrayList<>(ball.length);
		for (int temp : ball) {
			list.add(temp);
		}
		int aSize = 0;

		while (list.size() > 0) {
			for (int i = 0; i < order.length; i++) {

				if (list.get(0) == order[i]) {
					answer[aSize] = list.get(0);
					list.remove(0);
					aSize++;
					break;
				} else if (list.get(list.size() - 1) == order[i]) {
					answer[aSize] = list.get(list.size() - 1);
					list.remove(list.size() - 1);
					aSize++;
					break;

				}
			}
		}
		return answer;
	}

}
