package programmers1;

public class NTS2020_2 {

	public static void main(String[] args) {

		System.out.println("hello line");
		int result = solution(3);
		System.out.println(result);
	}

	public static int solution(int N) {
		int answer = 0;

		for (int i = 0; i <= N / 2; i++) { // i는 2의 갯수
			int one = N - (i * 2);// 1의 갯수
			int sum = i + one;
			double com =1;
			if (one > i) {
				for (int j = sum; j > one; j--) {
					com = com*j;
					com = com/fact(i);
				}
			}else {
				for (int j = sum; j > i; j--) {
					com = com * j;
					com = com/fact(one);

				}
			}
			//double com = fact(sum) / (fact(one) * fact(i));

			answer += com;
		}

		return answer;
	}

	public static int fact(int n) {

		if (n <= 1)

			return 1;

		else

			return fact(n - 1) * n;

	}

}
