package programmers1;

import java.util.HashMap;

public class kakao2020_4 {

	public static void main(String[] args) {
		int[][] build_frame = { { 1, 0, 0, 1 }, { 1, 1, 1, 1 }, { 2, 1, 0, 1 }, { 2, 2, 1, 1 }, { 5, 0, 0, 1 },
				{ 5, 1, 0, 1 }, { 4, 2, 1, 1 }, { 3, 2, 1, 1 } };
		int[][] result = solution(5, build_frame);

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(result[i][j]);

			}
			System.out.println();
		}
		System.out.println("hi");
	}

	public static int[][] solution(int n, int[][] build_frame) {
		int[][] answer = {};

		HashMap<Integer[], Integer> hmap = new HashMap<Integer[], Integer>();

		for (int i = 0; i < build_frame.length; i++) {
			Integer[] key = { build_frame[i][0], build_frame[i][1], build_frame[i][2] };
			switch (build_frame[i][3]) {

			case 0:// 삭제
				if (hmap.get(key) != null) {
					switch (build_frame[i][2]) {
					case 0:// 기둥삭제

						break;
					case 1:// 보삭제

						break;

					default:
						break;
					}
				}
				break;

			/*
			 * 기둥은 바닥 위에 있거나 보의 한쪽 끝 부분 위에 있거나, 또는 다른 기둥 위에 있어야 합니다. 
			 * 보는 한쪽 끝 부분이 기둥 위에 있거나,
			 * 또는 양쪽 끝 부분이 다른 보와 동시에 연결되어 있어야 합니다.
			 */
			case 1:// 생성
				if (hmap.get(key) == null) {
					switch (build_frame[i][2]) {
					case 0:// 기둥생성
						int[] line1 = { key[0] - 1, key[1], 1 };
						int[] line2 = { key[0], key[1], 1 };
						int[] line3 = { key[0], key[1]-1,0};
						if (key[1] == 0 || hmap.get(line1) != null || hmap.get(line2) != null|| hmap.get(line3) != null) {
							hmap.put(key,0);
						}

							break;
					case 1:// 보생성
						
						int[] line4 = { key[0] , key[1]-1, 0 };
						int[] line5 = { key[0]+1, key[1]-1, 0 };
						int[] line6 = { key[0]-1, key[1],1};
						int[] line7 = { key[0]+1, key[1],1};
						if(hmap.get(line4) != null||hmap.get(line5) != null||hmap.get(line6) != null||hmap.get(line7) != null) {
							hmap.put(key,0);
						}
						break;

					default:
						break;
					}
				}
				break;

			default:
				break;
			}

		}
		return answer;
	}
}
