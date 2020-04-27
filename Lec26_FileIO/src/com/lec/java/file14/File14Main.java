package com.lec.java.file14;

import java.nio.charset.Charset;

public class File14Main {

	public static void main(String[] args) {
		System.out.println("시스템 정보 확인");
		
		System.out.println();
		System.out.println(System.getProperty("os.name"));//Windows 10
		System.out.println(System.getProperty("os.arch"));//64bit
		System.out.println(System.getProperty("os.version"));
		
		System.out.println();
		System.out.println(System.getProperty("java.home"));//C:\Program Files\Java\jre1.8.0_241
		//JRE 경로 : Java Runtime Environment <----JVM
		System.out.println(System.getProperty("java.version"));
		
		System.out.println();
		// current working directory //현재작업경로
		System.out.println(System.getProperty("user.dir")); //user home과 구분하기
		
		
		// user home directory("내 문서"가 있는 폴더)
		System.out.println(System.getProperty("user.home"));
		
		System.out.println();
		System.out.println(System.getProperty("file.separator"));
		//윈도우에서는 \

		//os의 기본 인코딩 값
		System.out.println("Default charset = " + Charset.defaultCharset());
		System.out.println("File.encoding = "+System.getProperty("file.encoding"));
		
		System.out.println("\n프로그램 종료");
		
	} // end main()

} // end class














