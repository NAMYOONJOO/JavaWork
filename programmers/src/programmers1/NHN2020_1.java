package programmers1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class NHN2020_1 {
	private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames,
			int[] numOfMovesPerGame) {
		// TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.

		int[] count = new int[numOfAllPlayers];
		char[] index = new char[numOfAllPlayers];

		int cnt = 0;
		for (char c = 'B'; c <= 'Z'; ++c) {
			index[cnt] = c;
			count[cnt] = 0;
			cnt++;
			if (cnt >= numOfAllPlayers - 1)
				break;

		}

		int tempCount = 1;
		char tempChar = 'A';// 술레

		int flag = 0;// 시작

		for (int i = 0; i < numOfGames; i++) {
			int step = numOfMovesPerGame[i];
			if (step < 0) {
				step = numOfAllPlayers - 1 - step;
			}
			flag = (flag + step) % (numOfAllPlayers - 1);
			//flag = flag
			boolean check = true;

			for (int j = 0; j < namesOfQuickPlayers.length; j++) {

				if (index[flag] == namesOfQuickPlayers[j]) {
					check = false;
				}
			}
			if (check) {
				int tempI = tempCount;
				char tempC = tempChar;

				tempChar = index[flag];
				tempCount = count[flag] + 1;

				index[flag] = tempC;
				count[flag] = tempI;
			}
		}

		for (int i = 0; i < count.length; i++) {
			System.out.println(index[i] + " " + count[i]);
		}
		System.out.println(tempChar + " " + (tempCount + 1));

	}

	private static class InputData {
		int numOfAllPlayers;
		int numOfQuickPlayers;
		char[] namesOfQuickPlayers;
		int numOfGames;
		int[] numOfMovesPerGame;
	}

	private static InputData processStdin() {
		InputData inputData = new InputData();

		try (Scanner scanner = new Scanner(System.in)) {
			inputData.numOfAllPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

			inputData.numOfQuickPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
			inputData.namesOfQuickPlayers = new char[inputData.numOfQuickPlayers];
			System.arraycopy(scanner.nextLine().trim().replaceAll("\\s+", "").toCharArray(), 0,
					inputData.namesOfQuickPlayers, 0, inputData.numOfQuickPlayers);

			inputData.numOfGames = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
			inputData.numOfMovesPerGame = new int[inputData.numOfGames];
			String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
			for (int i = 0; i < inputData.numOfGames; i++) {
				inputData.numOfMovesPerGame[i] = Integer.parseInt(buf[i]);
			}
		} catch (Exception e) {
			throw e;
		}

		return inputData;
	}

	public static void main(String[] args) throws Exception {
		InputData inputData = processStdin();

		solution(inputData.numOfAllPlayers, inputData.numOfQuickPlayers, inputData.namesOfQuickPlayers,
				inputData.numOfGames, inputData.numOfMovesPerGame);
	}
}