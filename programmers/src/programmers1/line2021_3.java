package programmers1;

public class line2021_3 {

	public static void main(String[] args) {

		int[] result = solution(10009);
//		int[] result = solution(73425);
		System.out.println(result[0] + "," + result[1]);

	}

	public static int[] solution(int n) {
		int[] answer = new int[2];

		int result = n;
		buble(n, 0);
		// buble(9,0);
		// 73425, 5
		return answer;
	}

	public static void buble(int n, int step) {
		
		int result;
		// n은 몇자리 수인가
		int length = (int) (Math.log10(n) + 1);
		for (int i = 0; i < length; i++) {
			int flag = (int) Math.pow(10, i);
			// System.out.println(flag);
			if (n%flag/(int) Math.pow(10, i)!=0) {
				result = (n / flag) + (n % flag);
				if (result < 10) {
					System.out.println("[" + result + "," + step + "]");
				} else {
					System.out.print("[" + result + "," + step + "]");
					buble(result, step + 1);

				}
			}else {
				continue;
			}
		}

	}

}
