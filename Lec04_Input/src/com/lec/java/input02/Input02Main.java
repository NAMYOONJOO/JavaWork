package com.lec.java.input02;

import java.util.Scanner;

//CTRL + SHIFT + O = 자동 import 생성

//문자열(String)
//char 입력
public class Input02Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("표준입력 : String, char");
		
		Scanner sc = new Scanner(System.in);
		/*
		//String 입력
		System.out.print("이름을 입력하세요 : ");
		String name = sc.nextLine(); // 엔터를 입력할때까지의 모~든 문자들을 문자열로 리턴 
		
		System.out.print("별명을 입력하세요 : ");
		String nick = sc.nextLine();
		
		//System.out.println("이름은 :"+ name+"\n별명은 : "+ nick);
		
		// char 입력
		// .nextChar() ? 라는 명령은 없다!
		System.out.print("성별을 입력하세요 M/F");
		char gender = sc.next().charAt(0); //"공식처럼 외워주세용~"
		System.out.println("이름은 : "+ name+"\n별명은 : "+ nick+"\n성별은 : "+ gender);
		
		System.out.println();
		*/
		
		//수업설명------------------------------------------------------------------------
		//키보드 버퍼라는 공간이 있다. 
		// 수행 88 입력시 88,enter 총 3개가 입력된다. 
		//nextInt가 수행되고 8, 8 까지 두개를 꺼내가게 된다. 그후 int 타입으로 변형되고 키보드 버퍼에는 enter가 남아있다. 
		//그다음 NextLine 실행되고 nextline은 엔터 입력시까지 입력을 바덱 된다 하지만 키보드 버퍼에는 엔터가 남아 있다. 
		//------------------------------------------------------------------------------
		
		System.out.println("나이를 입력하세요 : ");
		int age = sc.nextInt();
		
		
		System.out.println("주소를 입력해주세요 : ");
		
		//숫자 입력 받은 뒤에 문자열 입력시에는 반드시 '\n'을 consume(버퍼에서 제거) 해야 한다.
		sc.nextLine(); //\n제거
		
		String addr = sc.nextLine();
		System.out.println("나이 : "+ age+"\n주소 : "+ addr);
		
		
		
		
		
		
		
		sc.close();
		
	}//end main


}//end class
