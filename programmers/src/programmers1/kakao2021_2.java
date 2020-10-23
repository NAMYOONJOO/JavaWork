package programmers1;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class kakao2021_2 {

	public static void main(String[] args) {

		System.out.println("hello kakao");
	
		String[] order = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD" };
		int[] course = {2, 3, 5};
		String[] answer = solution(order, course);
		for (int i = 0; i < answer.length; i++) {
			System.out.println("'"+answer[i]+"'");
		}
	}

	static String x = "";

	public static String[] solution(String[] orders, int[] course) {
		String[] answer = {};
		String answer_a = "";

		for (int j = 0; j < course.length; j++) {
			HashMap<String, Integer> hmap = new HashMap<String, Integer>();

			int max = 2;

			for (int i = 0; i < orders.length; i++) {
				String[] com = {};
				String[] arr = orders[i].split("");

				int n = arr.length;
				boolean[] visited = new boolean[n];

				//System.out.println("\n" + n + " 개 중에서 " + course[j] + " 개 뽑기");
				// System.out.println(comb(arr, visited, 0, n, course[j]));
				com = comb(arr, visited, 0, n, course[j]).trim().split("\\s+");

				for (int iii = 0; iii < com.length && com[iii].length() != 0; iii++) {
					// System.out.println(com[iii]);
					Integer v = hmap.get(com[iii]);
					if (v == null) {// 기존에 해당 key값이 없었다면 (즉! 첫 등장이면)
						hmap.put(com[iii], 1);
						if (1 > max) {
							max = 1;
						}
					} else {
						hmap.put(com[iii], v + 1);// 기존 등장횟수에 +1
						if (v + 1 > max) {
							max = v + 1;
						}
					}

				}
			}

			//System.out.println("max :"+ max);

			for (Map.Entry<String, Integer> e : hmap.entrySet()) {
				//System.out.println(e.getKey() + " : " + e.getValue() + "개");
				if(e.getValue()==max) {
					answer_a += e.getKey()+" ";
				}
			}
		}
		//System.out.println(answer_a);
		answer_a = answer_a.trim();
		answer = answer_a.split("\\s+");
		
		Arrays.sort(answer);
		return answer;
	}

	public static String comb(String[] arr, boolean[] visited, int depth, int n, int r) {
		String answer = "";
		if (r == 0) {
			answer += print(arr, visited, n);
			return answer;
		}

		if (depth == n) {
			return answer;
		}

		visited[depth] = true;
		answer += comb(arr, visited, depth + 1, n, r - 1);

		visited[depth] = false;
		answer += comb(arr, visited, depth + 1, n, r);

		return answer;
	}

	public static String print(String[] arr, boolean[] visited, int n) {
		String course = "";
		for (int i = 0; i < n; i++) {
			if (visited[i]) {
				// System.out.print(arr[i] + " ");
				course += arr[i];
			}
		}

		String[] co = course.split("");

		Arrays.sort(co);
		
		String result = "";
		for (int i = 0; i < co.length; i++) {
			result+=co[i];
		}
		result += " ";
		// System.out.println(course);
		return result;

	}

}
