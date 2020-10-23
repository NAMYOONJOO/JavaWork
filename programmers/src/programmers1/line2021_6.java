package programmers1;

public class line2021_6 {

	public static void main(String[] args) {

		System.out.println("hello line");
		int[] result = solution(9);
		// System.out.println(result[0] + "," + result[1]);
		result = solution(10007);
		// System.out.println(result[0] + "," + result[1]);
		result = solution(73425);
		// System.out.println(result[0]+","+result[1]);

		int[] n = { 73425, 0 };
		route(n,0);

	}

	public static int[] solution(int n) {
		int[] answer = new int[2];
		int cnt = 0;
		int result = n;


		return answer;

	}

	public static void route(int[] n, int d) {
		int[] result = n;
		int min ;
		
		if (result[0] > 10) {
			int length = (int) (Math.log10(result[0]) + 1); // 자리수 (5)
			for (int i = 1; i < length; i++) {
				int flag = (int) Math.pow(10, i);
				result[0] = (result[0] / flag) + (result[0] % flag);
				result[1]++;
			}
			//System.out.println(result[0] + ":" + result[1]);

			route(result,d);
		} else {

			System.out.println(result[0] + ":" + result[1]);
			route(result,d+1);
			
		}
	}

}
