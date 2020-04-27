package com.lec.java.file02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteOrder;

/* FileIO
 Program <=== InputStream <=== Source
 Program ===> OutputStream ===> Source
 Program <=== FileInputStream <=== File
 Program ===> FileOutputStream ===> File

 java.io.InputStream
  |__ java.io.FileInputStream: 파일로부터 데이터를 읽어오는 통로
 java.io.OutputStream
  |__ java.io.FileOutputStream: 파일로 데이터를 쓰는 통로
*/

public class File02Main {

	public static void main(String[] args) {
		System.out.println("File IO");

		InputStream in = null;// InputStream 변수 선언
		OutputStream out = null; // Outputstrean 변수선언

		try {
			// FlleInputStream 인스턴스 생성
			in = new FileInputStream("temp/big_text.txt");

			// FileOutputStream 인스턴스 생성
			out = new FileOutputStream("temp/copy_big_text.txt");
			// 위 파일이 없으면 새로생성
			// ㅇ있으면 기존 파일 삭제후 다시 생성

			int dataRead;
			int bytesCopied = 0;

			long startTime = System.currentTimeMillis();
			// 파일복사 : 읽기 -> 쓰기
			while (true) {
				// 데이터 읽기: InputStream에 있는 read() 메소드 사용
				// read()는 InputStream 으로부터
				// 1byte 씩 읽어서 int(4byte) 에 담아 리턴한다
				// [ ... ][ ... ][ ... ][ 1byte ]

				dataRead = in.read();
				if (dataRead == -1) {// 더이상 읽을 것이 없으면 read()는 -1 리턴
					break;

				}
				// 데이터 쓰기: OutputStream에 있는 write() 메소드 사용
				// write() 는
				// int(4byte)에 1byte씩 담아 OutputStream에 쓴다
				// [ ... ][ ... ][ ... ][ 1byte ]

				out.write(dataRead);
				bytesCopied++;
			}
			long endTime = System.currentTimeMillis();
			long elapsedTime = endTime - startTime; // 경과시간

			System.out.println("읽고 쓴 바이트 : " + bytesCopied);
			System.out.println("경과시간 : " + elapsedTime);

		} catch (FileNotFoundException e) { ///*** 이거 참고 (파일이 없으면 이걸 발생)
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (out != null)
					out.close();
				if (in != null)
					in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("\n프로그램 종료");

	} // end main()

} // end class
