package programmers1;

public class NAVER2020_1 {

	public static void main(String[] args) {
		System.out.println("hello naver");
		String m = "kkaxcbycyz";
		String k = "abc";

		String result = solution(m, k);
		System.out.println(result);

	}

	public static String solution(String m, String k) {
		String answer = "";

		String[] kk = k.split("");
		String[] mm = m.split("");
		int cnt = 0;
		for (int i = 0; i < mm.length; i++) {
			if (cnt < 3) {
				if (mm[i].equals(kk[cnt])) {
					cnt++;
				} else {
					answer += mm[i];
				}
			}
			else {
				answer += mm[i];
				
			}

		}

		return answer;
	}

}
