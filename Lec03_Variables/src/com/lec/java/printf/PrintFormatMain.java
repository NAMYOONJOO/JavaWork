package com.lec.java.printf;
/* 서식화된 문자열 (formatted string)
 *  ● 화면에 출력할때는 -> printf()
 *    
 *    printf("서식문자열", 값1, 값2....)
 *    
 *  ● 문자열(String)으로 만들때는 -> String.format()
 *       	
 *    String.format("서식문자열", 값1, 값2....)
 *    
 *  ● format specifier (서식 지정자)
 *  	%d  :  십진수 정수로 출력
 *  	%f  :  실수 출력
 *  	%s  :  문자열 출력
 *  	%c  :  '문자하나' 출력
 *  	%x  :  16진수 정수로 출력
 *  	%%  :  % 출력
*/


public class PrintFormatMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("서식화된 출력 : printf(), String.format()");
		
		
		double pi = Math.PI;//Math.Pi : 원주율
		
		System.out.println("pi : " + pi);
		// printf : print with format
		// printf("서식 문자열", 값1. 값2...)
		// 서식문자열 안에는 %로 시작하는 서식지정자들 
		
	    System.out.printf("원주율 %f\n",pi);
	    System.out.printf("원주율 %.2f\n",pi);//소수점 두자리까지 출력
	    
	    int age = 10;
	    short grade = 3;
	    
	    System.out.printf("제 나이는 %d살 입니다. 학년은  %d학년 입니다. \n",age, grade);//차례대로 대입된다.
	    System.out.println("김우경은 안기여운데 기여운척을 오지게 합니다 ");
		
	    
	    //소수점 이하 제한
	    double height = 159.9;
	    System.out.printf("저는 %d살 입니다. 키는 %fcm입니다. \n", age, height);
	    System.out.printf("저는 %d살 입니다. 키는 %.1fcm입니다. \n", age, height);// 소수점 한자리까지 출력
		
		
		//출력 폭 지정 , 좌우 졍렬
	    System.out.printf("|%d|%d|%d|\n",100,200,300);
	    System.out.printf("|%5d|%5d|%5d|\n",100,200,300);// 출력폭 5칸, 우축정렬(기본)
	    System.out.printf("|%-5d|%-5d|%-5d|\n",100,200,300);// 출력폭 5칸, 좌측정렬
	    
	    System.out.printf("제 이름은 [%10s]입니다. 혈액형은 %c형 입니다. \n", "김봉준", 'B');
	    
	    //%출력
	    double rate = 134423.0/345678.0;
	    System.out.printf("합격률은 %.1f%%입니다. ", rate);
	    
	    //숫자에 패딩
	    System.out.printf("|%05d|%05d|%05d|\n",100,200,300);
	    
	    //format 문자열을 따로 설정해서 운영
	    String fmt = "주소 : %s, 우편번호 [%05d]";
	    
	    
	    System.out.printf(fmt+"\n", "서울",12345);
	    System.out.printf(fmt+"\n", "인천",12345);
	    System.out.printf(fmt+"\n", "천안",12345);
	    System.out.printf(fmt+"\n", "우경이 뱃속",12345);
	    
	    System.out.println();
	    
	    //String.format()
	    String.format("합격률은 %.1f%%입니다", rate); //화면 출력용 아님
	    String result = String.format("합격률은 %.1f%%입니다", rate);// String 타입에 담기
	    
	    System.out.println(result);
	    
	    
	    //요기까지 변수단원 끝 --------------------------------------------------//
	    
	}//end main

}//end class
