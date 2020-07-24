package com.mvn.Junittest10;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class AppTest {
	private App app = new App();

	@Test
	public void test1() {
		// 5개의 테스트 데이터를 준비하여 sortArr 결과, 배열이 오름차순이 되었으면 통과

		// 테스트 데이터
		int[] test1_1 = new int[] { 2, 3, 4, 5, 1 };
		int[] test1_2 = new int[] { 10, 20, 30, 40 };
		int[] test1_3 = new int[] { 11, 23, 5, -1 };
		int[] test1_4 = new int[] { 8, 5, 22, 66, 1 };
		int[] test1_5 = new int[] { 1, 3, 4, 88, 2, 3, 77, 2 };

		testsort(test1_1);
		testsort(test1_2);
		testsort(test1_3);
		testsort(test1_4);
		testsort(test1_5);
	}

	public void testsort(int[] arr) {
		app.sortArr(arr);

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[i - 1]) {
				fail();
			}
		}
	}

	// 실습 2
	@Test
	public void test2() {
		/*
		 * 테스트 실행하기전에 폴더 생성 /TEST 폴더 생성 3개의 테스트 데이터로 두 메소드 테스트 진행 테스트 통과화면 위 폴더에
		 * ‘report.txt’ 란 이름의 텍스트 파일을 생성 최대값과 최솟값을 저장해보기
		 */
		// 테스트 데이터
		int[] test2_1 = new int[] { 3, 4, 10 };
		int[] test2_2 = new int[] { 200, 100, -500, 600, 9999 };
		int[] test2_3 = new int[] { 4, 4, 4, 5, 5, 5, 7, 8, 10 };

		String message = "";
		message += testNum(test2_1);
		message += testNum(test2_2);
		message += testNum(test2_3);

		// 파일 저장
		File file = new File("TEST/report.txt");
		FileWriter writer = null;

		try {
			writer = new FileWriter(file, false);
			writer.write(message);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public String testNum(int[] arr) {
		int maxResult = app.max(arr);
		int minResult = app.min(arr);

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > maxResult)
				fail();
			if (arr[i] < minResult)
				fail();
		}

		// 저장할 test
		return String.format("최소값 : %d\n최대값 : %d\n-----------------\n", minResult, maxResult);

	}

}
