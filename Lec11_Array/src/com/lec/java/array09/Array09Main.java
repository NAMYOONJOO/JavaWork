
package com.lec.java.array09;

/* ragged array: column(열)의 개수가 일정하지 않은 배열

	가변 배열 선언 방법: 행의 개수만 지정을 하고, 열의 개수는 비워둠
	열(column)이 몇 개가 될 지 모르기 때문에 메모리 할당이 되지 않습니다.
 */
public class Array09Main {

	public static void main(String[] args) {
		System.out.println("Ragged Array(가변 배열)");

//		int[][] arr = new int[3][2];
		int[][] arr = new int[3][]; //3개짜리 2차원배열 객체만 생성
		arr[0] = new int[] {10}; //length = 1
		arr[1] = new int[] {11,12}; //length = 2
		arr[2] = new int[] {20, 30, 40}; //length = 3
		
		int[] temp = arr[1];
		arr[1] = arr[2];
		arr[2] = temp; //서로 바꾸는거 가능
		
		// int[] arr[];
		// iny arr[][];//가능은하다
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
			
		}
	} // end main()

} // end class Array09Main
