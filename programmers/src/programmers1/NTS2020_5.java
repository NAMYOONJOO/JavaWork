package programmers1;

public class NTS2020_5 {

	public static void main(String[] args) {

		System.out.println("hello line");
		int result = solution(3);
		System.out.println(result);
	}

	public static int solution(int N) {
	

		
		return fibo(N+1);

	}

	public static int fibo(int n) {

		if (n <= 1)

			return n;

		else

			return fibo(n - 2) + fibo(n - 1);

	}

}
