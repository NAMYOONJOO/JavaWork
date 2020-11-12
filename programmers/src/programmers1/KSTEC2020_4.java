package programmers1;

import java.util.ArrayList;
import java.util.List;

public class KSTEC2020_4 {

	/*
	 * for (int i = 0; i < arr.length-1; i++) { for (int j = i+1; j < arr.length;
	 * j++) { if(arr[i]+arr[j]==n)return true; } }
	 */

	public static void main(String[] args) {

	}

	public static boolean solution(int[] arr, int n) {
		boolean answer = false;
		
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < arr.length; i++) {
			if(arr[i]<n) {
				list.add(arr[i]);
			}
		}
		
		int[] array = new int[list.size()];

	    for (int i=0; i < list.size(); i++)
	    {
	    	array[i] = list.get(i).intValue();
	    }
		
		for (int i = 0; i < array.length - 1; i++) {
				for (int j = i + 1; j < array.length; j++) {
						if (array[i] + array[j] == n)
							return true;
				}
		}

		return answer;
	}

}
