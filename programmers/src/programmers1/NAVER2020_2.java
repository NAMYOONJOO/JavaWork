package programmers1;

public class NAVER2020_2 {

	public static void main(String[] args) {
		System.out.println("hello naver");
		int[][] blocks = { { 0, 50 }, { 0, 22 }, { 2, 10 }, { 1, 4 }, { 4, -13 } };
		int[] result = solution(blocks);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

	public static int[] solution(int[][] blocks) {
		int size = size(blocks.length);
		int answer[] = new int[size];
		for (int i = 0; i < blocks.length; i++) { // 층 반복
			int myposition = size(i) + blocks[i][0];
			answer[myposition] = blocks[i][1];
			// System.out.println(answer[myposition]);
			for (int j = blocks[i][0] - 1; j >= 0; j--) {
				int position = size(i) + j;
				int parent = size(i - 1) + j;
				answer[position] = answer[parent] - answer[position + 1];
				// System.out.println(answer[position]);
			}
			for (int j = blocks[i][0] + 1; j <= i; j++) {
				int position = size(i) + j;
				int parent = size(i - 1) + j - 1;
				answer[position] = answer[parent] - answer[position - 1];
				// System.out.println(answer[position]);

			}
		}

		return answer;
	}

	public static int size(int n) {
		int size = 0;
		size += (n / 2) * (1 + n);
		if (n % 2 == 1) {
			size += (n / 2) + 1;
		}
		return size;
	}

}
