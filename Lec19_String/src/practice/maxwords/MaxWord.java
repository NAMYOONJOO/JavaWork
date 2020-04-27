package practice.maxwords;

import java.util.Scanner;
import java.util.StringTokenizer;

/* MaxWrod
	여러문장으로 구성된 문자열을 입력받은뒤 
	문자열에서 가장 단어의 개수가 많은 문장을 찾아서, 
	그 문장과 문장의 단어의 개수를 출력
	'문장'의 구분은  .(마침표) !(느낌표) ?(물음표) 로 한다.
	'단어'구분은 '공백' 으로 한다
	
	입력예]
	We test coders. Give us a try. Can you make it out? It's awesome.
	
	출력예]
	5개
	Can you make it out
 */
public class MaxWord {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println();

		System.out.println("문장입력");
		
		String longLine = sc.nextLine();
		String[] smallLine = longLine.split("\\?|\\.|\\!");
		System.out.println();

		int maxWord = 0; //최대단어수
		int maxLine = 0; //최대단어를 가진 문장 : String smallLine[maxLine]
		for (int i = 0; i < smallLine.length; i++) {
			StringTokenizer tokenizer = new StringTokenizer(smallLine[i], " ");
			if (tokenizer.countTokens() >= maxWord) {
				maxWord = tokenizer.countTokens();
				maxLine = i;
			}
		}
		System.out.println(maxWord + "개"); //최대단어수 출력

		StringTokenizer tokenizer = new StringTokenizer(smallLine[maxLine].trim(), " ");
		while (tokenizer.hasMoreTokens()) {
			System.out.print(tokenizer.nextToken() + " ");//가장 단어의 개수가 많은 문장 출력
		}
		sc.close();
	} // end main

	 
} // end class
