package com.mvn.Junittest10;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App {
	// 실습 1
	// int[] 을 매개변수로 받아 배열의 내용을 오름차순으로 정렬하는 메소드 작성
	public void sortArr(int[] arr) {
		Arrays.sort(arr);
	}

	// 실습2
	//	int[] 을 매개변수로 받아 배열안에서 가장 큰 값과 가장 작은 값을 리턴
	public int max(int[] arr) {

		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		return max;
	}

	public int min(int[] arr) {
		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (min > arr[i]) {
				min = arr[i];
			}
		}
		return min;

	}

	// 실습3
	// String 을 매개변수 받아 숫자를 제외한 문자열을 제거하여 리턴
	public String toNumber(String str) {
		return str.replaceAll("[^0-9]", "");
	}
}
