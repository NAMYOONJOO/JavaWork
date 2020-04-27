package com.lec.java.regexp05;
//********** 구글링 **************
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 대표적인 정규 표현식 
 *  구글링 하면 대표적인 정규표현식들이 많이 구할수 있습니다.
 *  각 정규표현식들을 작성해보고
 *	매칭되는 문자열과 그렇지 않은 것들을 출력해봅시다.   
 */
public class RegExp05Main {

	public static void main(String[] args) {
		System.out.println("많이 쓰는 정규표현식");

		String regex, intput, title;
		String [] arrInput;
		
		//─────────────────────────────────────────
		title = "URL";
		regex = "^(https?):\\/\\/([^:\\/\\s]+)(:([^\\/]*))?((\\/[^\\s/\\/]+)*)?\\/?([^#\\s\\?]*)(\\?([^#\\s]*))?(#(\\w*))?$"; // TODO
		arrInput = new String[] {
			"http://www.daum.net",
			"http://www.naver.com/",
			"http://www.google.com"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		
		//─────────────────────────────────────────
		title = "email";
		regex = "^[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*\\.[a-zA-Z]{2,3}$";
		arrInput = new String[] {
			"bhd4445@naver.com",
			"yjnam2865@gmail.com"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		//─────────────────────────────────────────
		title = "주민등록번호";
		regex = "\\d{6} \\- [1-4]\\d{6}"; 
		arrInput = new String[] {
			"970502 - 2159019"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);
		
		//─────────────────────────────────────────
		title = "날짜 YYYY-MM-DD";
		regex = "^[0-9]{4}\\-[0-9]{2}\\-[0-9]{2}$"; // TODO
		arrInput = new String[] {
				"1997-05-02",
				"1968-06-08",
				"97-05-02"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);
	
		//─────────────────────────────────────────
		title = "자연수";
		regex = "^[1-9][0-9]*$"; // TODO
		arrInput = new String[] {
			"9","100","0.1","-8"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		//─────────────────────────────────────────
		title = "정수";
		regex = "^(0|-?[1-9][0-9]*)$"; // TODO
		arrInput = new String[] {
				"9","100","0.1","-8"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		//─────────────────────────────────────────
		title = "소수";
		regex = "^[0-9]+(.[0-9]+)?$"; // TODO
		arrInput = new String[] {
				"100","0.1","-8","3.14"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		//─────────────────────────────────────────
		title = "소숫점 둘째자리까지";
		regex = "^[0-9]+(.[0-9]{1,2}+)?$"; // TODO
		arrInput = new String[] {
				"0.1","-8","3.14"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		//─────────────────────────────────────────
		title = "통화표시 (￦)";
		regex = "\\p{Sc}"; // TODO
		arrInput = new String[] {
			"￦","&","%"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		System.out.println("프로그램 종료");

	} // end main()

	// 도우미 함수
	public static void regExpTest(String regex, String[] arrInput) {
		for (String input : arrInput)
			regExpTest(regex, input);
	}

	public static void regExpTest(String regex, String input) {
		System.out.println("[정규표현식 매칭 테스트]-----------------");
		System.out.println("정규표현식: " + regex);
		System.out.println("입력문자열: " + input);

		if(Pattern.matches(regex, input)) {
			System.out.println("   ●매칭●");
		} else {
			System.out.println("   Ⅹ매칭 없슴Ⅹ");
		}
		
		System.out.println();
	} // end regExpTest()

} // end class
