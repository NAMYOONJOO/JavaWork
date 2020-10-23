package programmers1;

public class kakao2020_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello world");
		System.out.println(solution("aabbaccc")); // 7
		System.out.println(solution("abcabcabcabcdededededede")); // 9
		System.out.println(solution("1")); // 9
		System.out.println(solution("a")); // 9
		// 2ab2cd2ab2cd
		// 2ababcdcd

	}

	public static int solution(String s) {
		int answer = 0;
		answer = s.length() + 1;
		for (int i = 1; i <= s.length() / 2; i++) {
			// i : 몇개로 자를 것인지 '
			String str = "";

			int cnt = 1;
			String string = s.substring(0, i);

			for (int j = i; j < s.length() + 1; j += i) {
				if (j + i > s.length()) {
					if(cnt ==1) {
						str +=string;
					}else {
						
						str += cnt + string;
					}
					cnt = 1;
					str = str + s.substring(j, s.length());
				}

				// String.substring(start,end) //문자열 start위치 부터 end전까지 문자열 발췌
				else if (string.equals(s.substring(j, j + i))) {
					cnt++;
				} else {
					if(cnt ==1) {
						str +=string;
					}else {
						
						str += cnt + string;
					}
					cnt = 1;
					string = s.substring(j, j + i);
				}
			}

			
			if (str.length() < answer) {
				answer = str.length();
			}
		}

		return answer;
	}

}
