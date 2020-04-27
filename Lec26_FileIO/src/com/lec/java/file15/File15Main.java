package com.lec.java.file15;

import java.io.File; //주로 디렉터리 관련된 작업을 한다. 

public class File15Main {

	public static void main(String[] args) {
		System.out.println("디렉토리 정보 확인");
		System.out.println();
		// current working directory : 현재작업경로
		String curWorkingDir = System.getProperty("user.dir");
		System.out.println("현재작업폴더 : "+ curWorkingDir);
		
		System.out.println();
		// 현재 작업 디렉토리의 파일 리스트 출력
		// File 클래스: 파일(txt, doc, ...) 객체 또는 디렉토리(폴더) 객체
		File curDir = new File(curWorkingDir);// 현재 작업 디렉토리 객체 (디렉토리는 파일을 담는다. 디렉토리와 파일은 다른것이당) 
		// 디렉토리를 담는지 폴더를 담는지 파일을 담는지 명확하게 구분해야한다. 
		File[] list =curDir.listFiles(); //listFiles() : 디렉토리 안에 있는 '파일 과 '디렉토리'를 File배열로 리턴
		System.out.println(list.length); //디렉토리가 5개 파일이 2개 (파일 과 디렉토리의 갯수)
		for (int i = 0; i < list.length; i++) {
			if(list[i].isDirectory()) {
				// isDirectory(): File 객체가 디렉토리이면 true 리턴
				// isFile(): File 객체가 파일이면 true 리턴
				
				//파일인지 디렉토리인지 구분
				System.out.print("DIR\t");
			}else System.out.print("FILE\t");
			System.out.print(list[i].getName()+"\t");
			System.out.println(list[i].length()+" byte"); //length()_파일의 크기(byte)
												// '디렉토리' 인 경우는 의미 없다

		}
	
		
		System.out.println();
		// 디렉토리의 내용 출력, enhanced for 문 이용
//		File tempDir = new File("temp");//현재작업경로 기준 temp----->>>**상대경로**를 이용한 File객체 생성
		//절대경로(absolute path)'를 ㅇㅣ용한 File 객체 생성
		String tempDirPath = System.getProperty("user.dir") 
				+ File.separator      // 윈도우 (\),  LINUX, Mac (/)
				+ "temp";
		System.out.println("절대경로 : "+ tempDirPath);
		File tempDir = new File(tempDirPath);
		//D:\JavaApp1\Dropbox\Java10\JavaWork\Lec26_FileIO \ temp
		
		
		File [] list1 = tempDir.listFiles();
		for(File e : list1) {
			if(e.isDirectory()) {
				System.out.print("DIR\t");
			}else System.out.print("FILE\t");
			System.out.print(e.getName()+"\t");
			System.out.println(e.length()+" byte");
			
		}
		
		
		System.out.println();
		// 파일 하나에 대한 정보
		String path = "dummy.txt";
		File f = new File ( path); //상대경로 ,current Directory 에 대한 dummy.txt
		//새로운 File 객체 생성
		//새로 파일이 생기지 않는다. (착각 ㄴㄴ)
		//명심할 것 :		
		// ★ File 객체를 생성(new) 했다고 해서
		// 물리적인 파일/디렉토리가 만들어지는게 아니다!~~~~~~~~
		
		System.out.println("파일 이름 : "+ f.getName());//상대경로가 뽑히는 것이다. 
		System.out.println("절대경로 뽑기 : "+ f.getAbsolutePath());//절대경로명
		//실제로는 존재 ㄴㄴ
		
		System.out.println("파일이 있을 까? "+ f.exists());//boolean타입 리턴
		//파일이 읍다~~ false
		
		
		
		
		System.out.println("\n프로그램 종료");
		
	} // end main()

} // end File11Main

















