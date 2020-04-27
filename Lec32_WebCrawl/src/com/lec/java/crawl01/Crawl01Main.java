package com.lec.java.crawl01;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl01Main {
/*
 * 외부 라이브러리를 사용한 자바 프로젝트
 * 
 * 1. 라이브러리 다운로드
 * 
 * 2. 프로젝트 내 (혹은 특정경로)에 라이브러리 저장
 * 
 * 3. 프로젝트의 Build Path 설정
 * 
 * (----------------------->어제 보여준 문제 답이다)
 */
	
/*
 * 1. https://jsoup.org/  에서 다운로드 
 * 2. 프로젝트에 폴더 만들고 (ex : libs ) 라이브러리 복사
 * 3. 프로젝트 우클릭 - Configure Build Path - Library탭 - Add Jars (혹은 라이브러리 추가) - 추가할 라이브러리 선택
 * 
 */
	
/* 네이버 뉴스 캐스트 (상단의 실시간뉴스)
 * 
 */
	//남윤주
	public static void main(String[] args) throws IOException {
		System.out.println("네이버 뉴스 캐스트 크롤링");
		
		String url; // 크롤링할 주소 url
		Response response; // response 객체 
		Document doc;  //JSOUP의  Document object model 객채
		Element element; //HTML의 ELEMENT 표현 객체 //크롤링도 element 단위로 이루어진다.
		
		url = "http://www.naver.com";
		response = Jsoup.connect(url).execute(); //throws IOException
		// GET방식 request는 다음과 같이 해도 된다.
		// Jsoup.connect(url).get();
		
		//아까ㅣ 여러줄 한것을 한줄에 끝냄 
		 
		System.out.println(response.statusCode()); //200 이 정상
		
//		request 결과코드
//		200 성공 
//		404 url 존재하지 않음
//		500 서버 내부 
//		400 Bad Request : request 문법상의 오류
//		401 권한에러 : 권한 관현 적절한 header 정보가 없는 경우 많이 발생
//		402 권한에러 : 자원에 대한 접근 권한 에러
//		403  권한에러 Forbidden : 파일권한, 읽기권한, SSL, IP, 등...  <--- 웹 크롤링 하다가 은근히 자주 마주치게 되는 에러
	
		System.out.println(response.statusMessage());//200 -> ok
		
		doc = response.parse(); 
		
		//기본적으로 할 수 있는 것들
		System.out.println(doc.title()); //<tilte> element 의 텍스트 
		System.out.println(doc.location()); //현재 문서의 URL
		//"http://www.naver.com";--->https://www.naver.com/
		
		String outerHtml = doc.outerHtml(); // 현재 node의 outer html 텍스트
		//System.out.println(outerHtml);
		//System.out.println(outerHtml.substring(0, 200)+ "...");
		
		
		
		//여기까지는 기본적인거 보여준거다
		
		
		
		// Document 나 Element 객체의
		// select(), selectFirst() 메소드로 특정 element(들)을 추출
		System.out.println("[네이버 뉴스케스트]");
		
		element = doc.selectFirst("#news_cast");  // 검색된 Element 들 중 최초 1개만 Element 로 리턴 
		//System.out.println(element.outerHtml());  //li class="ca_item" 는 자손이다
		
		Elements newsElements= doc.select("#news_cast li.ca_item"); //검색된 Element 들이 담겨 있는 Elements 리턴
 		
		// 복수개의 목록 크롤링 할 시, 내가 원하는 개수만큼 크롤링 되었는지 우선 확인해보자!!!!
		
		System.out.println(newsElements.size()+"개");
		
		for(Element e:newsElements) {
			//System.out.println(e.outerHtml());
			element = e.selectFirst("a");
			System.out.println(element.text());// elementdml text() -> text들을 묶어서 하나로 리턴;
			// 특정 attribute 꺼낼 때는 (아래)
			System.out.println(element.attr("href"));
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("시스템 종료");
		
	}//end main()

}//end class
