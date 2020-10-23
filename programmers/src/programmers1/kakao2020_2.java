package programmers1;

public class kakao2020_2 {

	public static void main(String[] args) {
		int[][] key = { { 0, 0, 0 }, { 1, 0, 0 }, { 0, 1, 1 } };
		int[][] lock = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		System.out.println(solution(key, lock));
	}

	public static boolean solution(int[][] key, int[][] lock) {
		//boolean answer = false;

		int[][] rotation_k = key;
		for (int i = 0; i < 4; i++) {
			rotation_k = rotation90(rotation_k);
			for (int x = -rotation_k.length; x < rotation_k.length; x++) {
				for (int y = -rotation_k.length; y < rotation_k.length; y++) {
					int[][] rotation_xy = rotation_k;
					
					//rotation_xy = rotation_x(x, rotation_xy);
					//rotation_xy = rotation_y(y, rotation_xy);
					rotation_xy = rotation_xy(x,y, rotation_xy);
					
					
					int cnt = 0;
					for (int row = 0; row < lock.length; row++) {

						for (int col = 0; col < lock.length; col++) {
							if(rotation_xy[row][col]+lock[row][col]==1) {
								cnt++;	
							}else {
								break;
								
							}
							
							//System.out.print(rotation_xy[row][col]+lock[row][col]);
						}
						//System.out.println();
					}
					//System.out.println();
					if(cnt==lock.length*lock.length)return true;
				}
			}

		}

		return false;
	}

	public static int[][] rotation90(int[][] key) {
		int M = key.length;
		int[][] answer = new int[M][M];

		for (int row = 0; row < key.length; row++) {

			for (int col = 0; col < key.length; col++) {
				answer[row][col] = key[col][M - 1 - row];
				//System.out.print(answer[row][col]);

			}
			//System.out.println();
		}
		return answer;

	}

	public static int[][] rotation_y(int x, int[][] key) {
		int M = key.length;
		int[][] answer = new int[M][M];

		for (int row = 0; row < key.length; row++) {

			for (int col = 0; col < key.length; col++) {

				if (row - x < M && row - x >= 0) {
					answer[row][col] = key[row - x][col];
				} else {
					answer[row][col] = 0;
				}
				//System.out.print(answer[row][col]);
				//System.out.print(key[row][col]);
			}
			//System.out.println();

		}
		return answer;
	}

	public static int[][] rotation_x(int y, int[][] key) {
		int M = key.length;
		int[][] answer = new int[M][M];

		for (int row = 0; row < key.length; row++) {

			for (int col = 0; col < key.length; col++) {
				if (col - y < M && col - y >= 0) {
					answer[row][col] = key[row][col-y];
				} else {
					answer[row][col] = 0;
				}
				//System.out.print(answer[row][col]);
				// System.out.print(key[row][col]);

			}
			//System.out.println();
		}
		return answer;
	}
	
	public static int[][] rotation_xy(int x,int y, int[][] key) {
		int M = key.length;
		int[][] answer = new int[M][M];

		for (int row = 0; row < key.length; row++) {

			for (int col = 0; col < key.length; col++) {

				if (row - x < M && row - x >= 0&&col - y < M && col - y >= 0) {
					answer[row][col] = key[row - x][col-y];
				} else {
					answer[row][col] = 0;
				}
				//System.out.print(answer[row][col]);
				//System.out.print(key[row][col]);
			}
			//System.out.println();

		}
		return answer;
	}
	
	

}
