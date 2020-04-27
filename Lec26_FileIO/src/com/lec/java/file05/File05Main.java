package com.lec.java.file05;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* Buffered Stream + Buffer 예제
Program <=== FilterInputStream <=== InputStream <=== Source
					↓ 상속					↓ 상속
Program <=== BufferedInputStream <=== FileInputStream <=== File

Program ===> FilterOutputStream ===> OutputStream ===> Source
					↓ 상속					↓ 상속
Program ===> BufferedOutputStream ===> FileOutputStream ===> File

java.io.InputStream
 |__ java.io.FilterInputStream
      |__ java.io.BufferedInputStream

java.io.OutputStream
 |__ java.io.FilterOutputStream
      |__ java.io.BufferedOutputStream
*/

public class File05Main {

	public static void main(String[] args) {
		System.out.println("Buffered Stream + Buffer");

		try (InputStream in = new FileInputStream("temp/big_text.txt");
				BufferedInputStream bin = new BufferedInputStream(in); // 장착
				OutputStream out = new FileOutputStream("temp/copy_big_text.txt");
				BufferedOutputStream bout = new BufferedOutputStream(out);) {
			byte[] buff = new byte[1024];
			int lengthRead = 0; // 버퍼에 읽어드린 바이트 수
			int byteCopied = 0; //
			long startTime = System.currentTimeMillis();
			// 파일복사
			while (true) {
				lengthRead = bin.read(buff);
				if (lengthRead == -1)
					break;

				bout.write(buff, 0, lengthRead); // 직전에 읽어들인 데이터만큼 write
				byteCopied += lengthRead;
			}
			long endTime = System.currentTimeMillis();
			long elapsedTime = endTime - startTime; // 경과시간

			System.out.println("읽고 쓴 바이트 : " + byteCopied);
			System.out.println("경과시간 : " + elapsedTime);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("\n프로그램 종료");

	} // end main()

} // end class File05Main
