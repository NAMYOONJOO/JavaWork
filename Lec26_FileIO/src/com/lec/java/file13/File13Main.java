package com.lec.java.file13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/* PrintWriter / 인코딩 
 * 
 * java.lang.Object
 *  └─ java.io.Writer
 *      └─ java.io.PrintWriter
 *  
 *  텍스트 파일 작성시는 PrintWriter 객체 편리
 *  	println(), print(), printf() ..
 *  텍스트 파일 읽을시는 BufferedReader 객체 편리
 *  	read(), read(버퍼), readLine()..
 *  
 *  PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("파일명" 혹은 File)));
 *  PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream("파일명" 혹은 File))));
 *  
 *  BufferedReader br = new BufferedReader(new FileReader("파일이름" 혹은 File));
 *  BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("파일이름" 혹은 File))));
 *  BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("파일이름" 혹은 File)));
 *  
 *  ★ 문자기반 출력시 꼭 끝에 flush() 해주자 ★
 * 
 *  인코딩 문제 
 *  	FIleReader, FileWriter 는 파일의 인코딩을 무조건 file.encoding 값으로 간주한다.
 * 		(ex: LINUX 는  UTF-8,  MacOS 는 한글상위의 경우 euc-kr, 윈도우즈는 Java 소스코드 인코딩 영향) 
 *  	
 *  인코딩 설정하기
 *  	InputStreamReader, OutputStreamWriter 를 사용해서 인코딩 변경을 해야 한다.
 *  
 *  	BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("파일이름" 혹은 File),"인코딩"));
 *  	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("파일이름" 혹은 File), "인코딩"));
 *   
 *  인코딩 : "UTF8", "euc-kr"
 *   
*/

public class File13Main {
	
	private static final String FILE1 = "temp/PrintData.txt";
	private static final String FILE2 = "temp/PrintData_euckr.txt";
	
	public static void main(String[] args) {
		System.out.println("PrintWriter / 인코딩 ");

		FileWriter fw = null;
		FileReader fr = null;
		
		PrintWriter out = null;
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
//			fw = new FileWriter(FILE1);
//			bw = new BufferedWriter(fw); //장착
//			out = new PrintWriter(bw);
			out = new PrintWriter(new BufferedWriter(new FileWriter(FILE1)));
			test_write(out);
			
			
			System.out.println();
			br = new BufferedReader(new FileReader(FILE1));
			test_read(br);
			
			//--------------------------------------------------
			out.close();
			br.close();
			//----------------------------------------------------
			
			System.out.println("현재 OS 인코딩 : "+System.getProperty("file.encoding"));
			// euc-kr로 인코딩, 저장
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FILE2), "euc-kr")));
			test_write(out);
			System.out.println();
			
			br = new BufferedReader(new InputStreamReader(new FileInputStream(FILE2), "euc-kr"));
			test_read(br);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			out.close();
			
			try {
				if(br!=null)br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("\n프로그램 종료");
		
	} // end main()
	
	public static void test_write(PrintWriter out) {
		out.println("안녕하세요 자바 한글이 자 ㄹ보이나요?");
		out.println((2000+20)+" "+3.14);
		out.println();
		out.printf("%d-%d-%d\n", 20,3,2);
		out.flush();// 까먹지 말자
	}
	
	public static void test_read(BufferedReader br) {
		String line;
		StringBuffer sb = new StringBuffer();
		try {
			while((line =  br.readLine())!=null) {
				sb.append(line+"\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(sb.toString());
	}
	
} // end class
