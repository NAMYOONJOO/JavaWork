package com.lec.java.string01;

import java.util.Arrays;
import java.util.Scanner;

/* 문자열 (String) 관련 메소드들
 * 
 * https://docs.oracle.com/javase/8/docs/api/java/lang/String.html
 * - 문자열 메소드는 꼭 정독해보세요.
 * - 매개변수의 의미, 동작의 의미, 리턴값의 의미 꼭 숙지해주세요
 * - 인스턴스 메소드 인지, 클래스 메소드(static) 인지 구분 
 */
public class String01Main {

	public static void main(String[] args) {
		System.out.println("String 클래스의 메소드들");

		String str1 = "AbCdEfg";
		String str2 = "안녕하세요~";

		System.out.println();
		System.out.println("length()"); // 문자의 개수

		System.out.println("str1 길이 " + str1.length());
		System.out.println("str2 길이 " + str2.length());
		// 자바는 한글, 영어 둘다 한글자씩

		System.out.println();
		System.out.println("concat()"); // 문자열 연결 (concatenation)
		System.out.println(str1.concat(str2));
		System.out.println(str2.concat(str1));
		System.out.println(str1.concat(str2).concat(str1));
		String str3 = str1.concat(str2);
		System.out.println(str3.length());// 6+7

		// ★주의★
		// 문자열(String) 은 변경불가(immutable) 이기 때문에
		// 메소드 수행했다고 하여 원본이 변경되지 않는다.
		str1.concat(str2);
		System.out.println(str1);// 원본 str1에 변화 없다.

		str1 = str1.concat(str2);
		System.out.println(str1);// 변경하려면 이와 같이 덮어쓰기 해야한다.

		// ★주의★
		// empty 문자열과 null 은 다르다
		// null 인 경우 메소드 수행하면 NullPointerException 발생!
		str3 = "";// empty문자열, String객체는 존재하나 비어있는 문자열
		System.out.println(str3.length());// 0
		str3 = null; // null, String객체가 존재하지 않음
		// System.out.println(str3.length());//0

		System.out.println();
		System.out.println("charAt(index)"); // 문자열 안의 특정위치(index)의 문자 리턴, 인덱스 범위 벗어나면 StringIndexOutOfBoundsException
												// 문자열 인덱스는 0 부터 시작!
		// System.out.println(str1.charAt(40));//error StringIndexOutOfBoundsException
		System.out.println(str1.charAt(1));

		System.out.println();
		System.out.println("indexOf(char), indexOf(String)"); // 문자열 안에서 특정 문자(char) 혹은 문자열(String)의 위치(index), 발견 못하면
																// -1 리턴
		System.out.println(str1.indexOf('C'));
		System.out.println(str2.indexOf('요'));
		System.out.println(str2.indexOf("하세"));

		System.out.println();
		System.out.println("toUpperCase(), toLowerCase"); // 대문자 변환, 소문자 변환
		System.out.println(str1.toUpperCase());
		System.out.println(str1.toLowerCase());
		
		
		System.out.println();
		System.out.println("startWith()"); // 문자열이 주어진 prefix문자열로 시작하는지 여부 true/false 리턴
		String prefix = "http://";
		String url = "www.google.com";
		System.out.println(url.startsWith(prefix));
		if(!url.startsWith(prefix)) {
			String newUrl = prefix.concat(url);
			System.out.println(newUrl);
		}
		
		
		System.out.println();
		System.out.println("split(regex)"); // 문자열을 주어진 문자열로 쪼개어 String[] 리턴
		String str4 = "HH:MM:SS";
		String[] strings = str4.split(":");//:기준으로 쪼갠다는 뜻
		System.out.println(Arrays.toString(strings)); //[HH, MM, SS]

		// 공백기준으로 쪼갤때는 정규표현식의 \\s+ 사용하기 : 공백, 탭, 줄바꿈
		str4 = "    Hello \t    \nmy     \n\nWorld";
		strings = str4.split("\\s+");
		System.out.println(Arrays.toString(strings)); //[Hello, my, World]

		// 단! "|" 을 할경우는 주의, ※ split(정규표현식) 을 사용하는 메소드임
		String str5 = "HH|MM|SS";
		strings = str5.split("\\|");
		for(String x : strings) {
			System.out.println(x);
		}
		
		// 년, 월, 일, 시, 분, 초, 분리하기
		str4 = "2018-08-16 14:34:52";
		String date = str4.split("\\s+")[0];
		String time = str4.split("\\s+")[1];
		System.out.println("date = " + date);
		System.out.println("time = " + time);
		String year = date.split("-")[0];
		System.out.println("year = " + year);
		//여기 다시해보기
		
		System.out.println(Arrays.toString(strings)); //[Hello, my, World]

		// String.join()
		// 문자열들, 문자열 배열 --> 하나의 문자열로 합하기 split() 과 반대
		System.out.println();
		System.out.println("String.join(delimeter, elements ...)");
		String[] str7 = { "Alice", "Bob", "Carol" };
		System.out.println(String.join(" - ", str7));
		//split과 반대

		System.out.println();
		System.out.println("substring(beginIndex, endIndex)"); // 문자열의 일부분 추출 beginIndex ~ endIndex직전 까지, 인덱스 범위 벗어마면
																// IndexOutOfBoundsException
		String str8 = "Hello Java";
		System.out.println(str8.substring(2,5));//ll0
		System.out.println(str8.substring(6));//6부터 끝까지 Java

		System.out.println();
		System.out.println("trim()"); // 좌우의 여백 제거
		String str9 = "   김동후   ";
		System.out.println("["+str9+"]");
		System.out.println("["+str9.trim()+"]");//김동후

		System.out.println();
		System.out.println("replace(target, replacement)"); // 문자열 치환 target → replacement
		String str10 = "Hello Language My Language";
		System.out.println(str10.replace("My", "Our"));//Hello Language Our Language
		System.out.println(str10.replace("Language", "Java"));//Hello Java My Java//모두 치환

		System.out.println();
		System.out.println("replaceAll(regex, replacement), replaceFirst(regex, replacement)"); // 정규표현식 사용버젼 ,
		System.out.println();																	// replaceAll() 매칭되는것 전부
																								// 치환, replaceFirst()
																								// 첫매칭만 치환
		System.out.println(str10.replaceAll("Language", "자바"));
		System.out.println(str10.replaceFirst("Language", "자바"));  // 첫 매칭만 치환
				

		System.out.println();
		System.out.println("equals(), equalsIgnoreCase()"); // 문자열 비교
		String str11 = "Java";
		String str12 = "java";
		System.out.println(str11.equals(str12));//햇던거 넘어가요~

		System.out.println();
		System.out.println("String.format()");
		// 했던거 넘어가요~
		
		//응용도 연습해야한다.

		// 연습 : id /pw 입력받고요
		// 로그인 성공 여부를 출력해주세요

		Scanner sc = new Scanner(System.in);

		// TODO

		sc.close();

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
