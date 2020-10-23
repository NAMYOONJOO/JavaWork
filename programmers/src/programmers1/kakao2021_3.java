package programmers1;

import java.util.Arrays;

public class kakao2021_3 {

	public static void main(String[] args) {

		System.out.println("hello kakao");

		String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210",
				"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
				"python backend senior chicken 50" };
		String[] query = { "java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
				"- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };

		long[] result = solution(info, query);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
		}
	}

	public static long[] solution(String[] info, String[] query) {
		long[] answer = new long[query.length];

		for (long i = 0; i < query.length; i++) {
			String content = query[(int)i].replaceAll("and", "");
			String[] condition = content.split("\\s+");
			if(condition.length<5)continue;
			
			for (long j = 0; j < 5; j++) {// 조건
				long trueCnt = 0;
				for (long j2 = 0; j2 < info.length; j2++) {
					long testCnt = 0;

					String[] test = info[(int)j2].split("\\s+");
					
					if(Integer.parseInt(condition[4])<=Integer.parseInt(test[4])){
						testCnt++;
					}else continue;
					
					boolean test_b = true;
					for (int k = 0; k < 4&&test_b; k++) {
					
						
						if(condition[k].equals("-")) {
							testCnt++;
						}else if (condition[k].equals(test[k])) {
							testCnt++;
						}else{
							test_b = false;
							break;
						}

					}
					
					
					if (testCnt==5) {
						trueCnt++;
					}
					
				}
				answer[(int)i] = trueCnt;
			}

			System.out.println();
		}

		return answer;
	}

}
