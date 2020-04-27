package practice.isogram;

import java.util.Arrays;
import java.util.Scanner;

/*	Isogram
	 문자열을 입력받으면 isogram 여부를 판단하여 true/false 를 출력하다가, quit 가 입력되면 종료
	isogram 이란?  : 중복된 알파벳이 없는 단어
	
	 isogram 예) Machine, isogram, Alphabet, quit
 */
public class Isogram {

	// substring() 과 indexOf(), charAt() 사용
    static boolean is_isogram2(String str) {
    	str = str.toLowerCase();
    	for(int i = 0; i < str.length() - 1; i++) {
    		if(str.substring(i + 1).indexOf(str.charAt(i)) != -1) return false;
    	}
    	return true;
    }
  
    public static void main(String[] args) 
    {
    	Scanner sc = new Scanner(System.in);
    	String word;
    	while(true) {
    		word = sc.next();
    		if(word.equalsIgnoreCase("quit")) break;
    		System.out.println(is_isogram2(word));
    	}
    	sc.close();
    } // end main()
} // end class





