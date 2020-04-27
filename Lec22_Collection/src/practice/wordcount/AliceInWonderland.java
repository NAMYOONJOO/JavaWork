package practice.wordcount;

//import java.util.ArrayList;
import java.util.Collections;
//import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/* 1] 문서(문자열) 안의 단어의 빈도수를 계수해서 출력하기
 * 	- 대소문자 구분하지 않기 :   The 와 the 는 같은 단어
 *  - 2글자 이상만 계수하기
 *  - 구두점/기호 ",.\"\'`!?;:-()" 잘라내기
 *  - 공백 짤라내기
 * ex)
 * 	an : 234
 * 	the : 314
 * ...
 * 
 * hint]
 * 	split("\\s+")  --> String[]   
 * 	--> StringTokenizer  (혹은 정규표현식)
 *  	  --> HashMap<String, Integer>   <단어, 빈도수>  사용
 * ───────────────────────────────────────────────────────────    
 * 2] 빈도수 내림차순으로 정렬하여 출력하기
 * 	ex)
 *	1 the:113개
 *	2 she:95개
 *	3 to:85개
 *	...   
 *
 * hint]
 * 	Comparable<> 이나 Comparator<> 적용
 */

// TODO : 필요한 객체들 작성
// hint> 빈도수 담을 객체, Comparator<> ..
/* java.util.Collections 클래스
Collections 클래스는 여러 유용한 알고리즘을 구현한 메소드들을 제공
대부분 클래스메소드 (static) 형태로 제공됨

정렬(sort)
섞기(shuffle)
탐색(search)
*/

/* 1] 문서(문자열) 안의 단어의 빈도수를 계수해서 출력하기
 *    - 대소문자 구분하지 않기 :   The 와 the 는 같은 단어
 *  - 2글자 이상만 계수하기
 *  - 구두점/기호 ",.\"\'`!?;:-()" 잘라내기
 *  - 공백 짤라내기
 * ex)
 *    an : 234
 *    the : 314
 * ...
 * 
 * hint]
 *    split("\\s+")  --> String[]   
 *    --> StringTokenizer  (혹은 정규표현식)
 *       --> HashMap<String, Integer>   <단어, 빈도수>  사용
 * ───────────────────────────────────────────────────────────    
 * 2] 빈도수 내림차순으로 정렬하여 출력하기
 *    ex)
 *   1 the:113개
 *   2 she:95개
 *   3 to:85개
 *   ...   
 *
 * hint]
 *    Comparable<> 이나 Comparator<> 적용
 */

// TODO : 필요한 객체들 작성
// hint> 빈도수 담을 객체, Comparator<> ..
public class AliceInWonderland {

	public static void main(String[] args) {
		System.out.println("실습: 단어 발생 빈도");
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		String[] words = C.ALICE30.trim().toLowerCase().split("\\s+");

		// 발생빈도 작성
		hmap = setFreqHmap(words, hmap);
		// 결과 출력, 내림차순
		List<Word> list = new LinkedList<Word>();
		insertHmap(list, hmap);
		Collections.sort(list);
		listInfo(list);
		System.out.println("\n프로그램 종료");

	} // end main()

	public static HashMap<String, Integer> setFreqHmap(String[] words, HashMap<String, Integer> hmap) {
		for (int i = 0; i < words.length; i++) {
			StringTokenizer tokenizer = new StringTokenizer(words[i], ",.\"\'`!?;:-()");
			while (tokenizer.hasMoreTokens()) {
				// tokenizer.nextToken();
				String str = (tokenizer.nextToken());
				Integer v = hmap.get(str);
				if (hmap.get(str) == null) {
					hmap.put(str, 1);
				} else {
					hmap.put(str, v + 1);

				}
			}
		}
		return hmap;
	}

	public static void insertHmap(List<Word> list, HashMap<String, Integer> hmap) { 
		//List<Word> list1 = new ArrayList(hmap .values());   : Hashmap -> List

		for (Map.Entry<String, Integer> e : hmap.entrySet()) {
			if (e.getKey().length() >= 2) {
				list.add(new Word(e.getKey(), e.getValue()));
			}
		}
	}// end insertHmap

	public static void listInfo(List<Word> list) {
		int n = 1;
		for (Word e : list) {
			System.out.println(n+" "+e);
			n++;
		}
	}// end listInfo
} // end class

class Word implements Comparable<Word> {
	String key;
	int value;

	public Word(String key, int value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public int compareTo(Word o) {
		if (o.value < this.value)
			return -1;// 내가 더 작으면 음수
		if (this.value < o.value)
			return 1; // 내가 더 크면 양수

		return 0;
	}

	@Override
	public String toString() {
		return this.key + " : " + this.value + "개";
	}

}
