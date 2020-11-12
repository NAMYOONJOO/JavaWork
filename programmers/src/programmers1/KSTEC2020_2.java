package programmers1;

public class KSTEC2020_2 {

	/*
	 * for (int i = 0; i < arr.length-1; i++) { for (int j = i+1; j < arr.length;
	 * j++) { if(arr[i]+arr[j]==n)return true; } }
	 */

	public static void main(String[] args) {
		System.out.println(true && false);
	}
	//[5, 3, 9, 13]
	public static boolean solution(int[] arr, int n) {
		boolean answer = false;

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == n)
					return true;
			}
		}

		return answer;
	}

}
