package com.lec.java.file16;

import java.io.File;
import java.io.IOException;

public class File16Main {

	public static final String TEST_DIRECTORY = "test";
	public static final String TEMP_DIR = "temp";
	public static final String TEST_FILE = "dummy.txt";
	public static final String TEST_RENAME = "re_dummy.txt";

	public static void main(String[] args) {
		System.out.println("폴더/파일 생성, 이름변경, 삭제");
		System.out.println();

		String path = System.getProperty("user.dir") + File.separator + TEST_DIRECTORY;
		System.out.println("절대경로 : " + path);
		// File 객체 생성 ---> 디스크에 물리적인 파일/디렉토리가 만들어진 것은 아니다!0
		File f = new File(path); // 물리적으로 만들어지지 않는다.

		System.out.println();
		// 폴더 생성: mkdir() --> 실제적으로 만드는것
		// 없을때만 만들어야 된다
		if (!f.exists()) {// 디렉토리가 존재하는지 확인
			// 디렉토리가 존재하지 않는다면 생성!
			if (f.mkdir()) { // 성공하면 true 실패하면 false리턴
				System.out.println("폴더 생성 성공");
			} else
				System.out.println("폴더 생성 실패"); // ---> 디렉토리를 만들 권한이 없을 때, 물리적으로 디스크상에 문제가 생겼을 때, 용량 문제
		} else {
			System.out.println("폴더가 이미 존재합니다.");
		}

		System.out.println();
		// 파일 생성 : createNewFile()
		File f2 = new File(f, TEST_FILE);
		// f :test라는 디렉토리를 표현하는 파일 객체
		// dummy.txt
		// "test/dummy.txt"를 표현한 것이다.
		// File( 디렉토리 File, 파일 명 )
		// dummy.txt 가 물리적으로 생기지 않는 다 객체만 생성
		System.out.println(f2.getAbsolutePath());
		if (!f2.exists()) {// 파일이 존재하지 않을때만 생성
			// 파일이 존재하지 않으면 생성
			try {
				if (f2.createNewFile()) {
					System.out.println("파일생성 성공");
				} else {
					System.out.println("파일생성 실패");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			// 파일이 존재한다면
			System.out.println("파일이 이미 존재한다능");
		}
		
		
		System.out.println();
		// 파일 이름 변경: renameTo()
		// renameTo()를 이용해서 다른 폴더로 이동(move)를 할 수도 있다.
		File f3 = new File(f, TEST_RENAME);//"test\re_dummy.txt"
		// 이걸로 바꿀겁니다 하는 객체를 만든 것이다. dummy---->re_dummy
		System.out.println(f3.getAbsolutePath());
		if(f2.exists()) { // "test\dummy.txt 가 존재하는지 체크
			//변경
			if(f2.renameTo(f3)) {//성공하면 true
				 System.out.println("변경성공");
			}else {
				System.out.println("변경실패");//re_dummy.txt가 이미존재할때 실패한다
			}
		}else {
			
			System.out.println("변경할 파일이 없습니다.");
			
		}
		
		System.out.println();
		// 파일 삭제: delete()
		//re_dummy.txt 삭제
		File f4 = new File(f, TEST_RENAME);  // "re_dummy.txt"
		System.out.println(f4.getAbsolutePath());
		if(f4.exists()) {
			// 파일이 존재하면 삭제
			if(f4.delete()) {
				System.out.println("파일 삭제 성공!");
			} else {
				System.out.println("파일 삭제 실패!");
			}
		} else {
			System.out.println("삭제할 파일이 없습니다");
		}
		
		
		System.out.println("\n프로그램 종료");

	} // end main()

} // end class
