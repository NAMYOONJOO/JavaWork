package programmers1;

import java.util.Scanner;

class NHN2020_2 {
	private static void solution(int day, int width, int[][] blocks) {
		// TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
		int[] space = new int[width];
		for (int i = 0; i < space.length; i++) {
			space[i]=0;
		}
		
		int answer = 0;
		
		for (int i = 0; i < day; i++) {
			for (int j = 0; j < width; j++) {
				space[j]=space[j]+blocks[i][j];
				System.out.println(space[j]);
			}
			int Flag1 = 0;
			int Flag2 = 0;
			for (int j = 0; j < blocks[i].length-1; j++) {
				if(space[j]>space[j+1]) {
					Flag1=Flag2;
					Flag2 = j;
					if(Flag1!=0) {
						int min;
						if(space[Flag1]<space[Flag2]) {
							min = space[Flag1];
						}else {
							min = space[Flag2];
						}
						
						for(int x = Flag1+1;x<Flag2;x++) {
							answer+=min-space[x];
							space[x]=min;
						}
						
					}
				}
			}
			
		}
		System.out.println(answer);
	}

	private static class InputData {
		int day;
		int width;
		int[][] blocks;
	}

	private static InputData processStdin() {
		InputData inputData = new InputData();

		try (Scanner scanner = new Scanner(System.in)) {
			inputData.day = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
			inputData.width = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

			inputData.blocks = new int[inputData.day][inputData.width];
			for (int i = 0; i < inputData.day; i++) {
				String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
				for (int j = 0; j < inputData.width; j++) {
					inputData.blocks[i][j] = Integer.parseInt(buf[j]);
				}
			}
		} catch (Exception e) {
			throw e;
		}

		return inputData;
	}

	public static void main(String[] args) throws Exception {
		InputData inputData = processStdin();

		solution(inputData.day, inputData.width, inputData.blocks);
	}
}