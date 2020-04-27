package com.lec.java.array05;

import java.util.Scanner;

/* 2차원 배열 (2-dimensional array)
 * 	직전의 예제와 같이 같이 배열 첨자를 하나만 쓰는 배열을 
 * 1차원 배열 (one-dimensional array) 이라고 함
 *   배열원소가 '1차원 배열' 들로 이루어진 배열을 2차원 배열 이라 한다
 *   배열원소가 '2차원 배열' 들로 이루어진 배열을 3차원 배열 이라 한다
*/

//배열의 원소가 배열을 갖는것 : 다차원 배열
public class Array05Main {

	public static void main(String[] args) {
		System.out.println("2차원 배열");

		// 1차원 배열들
		int[] arr1 = { 1, 2 };
		int[] arr2 = { 3, 4 };
		int[] arr3 = { 5, 6 };

		// 2차원 배열들 : (배열의 원소가 1차원 배열)
		int[][] array = { { 1, 2 },// <---array[0]
						  { 3, 4 },// <---array[1]
						  { 5, 6 } // <---array[2]
		};
		System.out.println(array[0][0]);
		System.out.println(array[0][1]);
		System.out.println(array[1][0]);
		System.out.println(array[1][1]);
		System.out.println(array[2][0]);
		System.out.println(array[2][1]);
		
		// * 흔히 2차원 배열을 '행' 과'열'로 표기 하기도 함
		//위array는 3행(row) x2열 (column)인 2차원 배열
		
		
		
		// 2차원 배열에서 length의 의미:
		// array.length: 2차원 배열의 원소, 즉 1차원배열의 개수 
		//  			행열의 개념에선 2차원 배열의 행(row)의 개수를 의미

		System.out.println("array.length : "+array.length);//3
		// array 의 타입 --> int[][]
		// array[0[ 의 타입 --> int[]
		//array [0][0]의 타입 --> int
		
		System.out.println("array[0].length : "+array[0].length);//2
		System.out.println("array[1].length : "+array[1].length);
		
		// 2차원 배열 원소 for
		for (int i = 0; i < array.length; i++) {//1차원배열 원소만큼
			for (int j = 0; j < array[i].length; j++) {//2차원 배열의 원소만큼
				System.out.print(array[i][j]+" ");
				
			}
			System.out.println();
		}
		
		
	
		// 2행 4열의 2차원 배열를 만들어서 
		// 아래와 같이 초기화하고 출력하기
		
		// 첫번째 배열 출력
		// 1 2 3 4
		// 5 6 7 8	
//==================================================================
		
		
		
		int[][] array1 = {{1,2,3,4},{5,6,7,8}};
	
		for (int i = 0; i < array1.length; i++) {
			for (int j = 0; j < array1[i].length; j++) {
				System.out.print(array1[i][j]+" ");
			}
			System.out.println();
		}
		
//==================================================================

		int [][] array2 = new int[2][4];
		int cnt = 1;
		for (int i = 0; i < array2.length; i++) {
			for (int j = 0; j < array2[i].length; j++) {
				array2[i][j] = cnt;
				cnt++;
			}
		}
		for (int i = 0; i < array2.length; i++) {
			for (int j = 0; j < array2[i].length; j++) {
				System.out.print(array2[i][j]+" ");
			}
			System.out.println();
		}
//=====================================================================	
		
		
		System.out.println();

		System.out.println(array);//[[I@15db9742
		System.out.println(array[0]);//[I@6d06d69c
		System.out.println(array[1]);//[I@7852e922
		System.out.println(array[2]);//[I@4e25154f


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	} // end main()

} // end class Array05Main

