package com.lec.java.crawl00;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl00Main {

	public static void main(String[] args) throws IOException {
		System.out.println("Jsoup");
		
		Element element;
		Elements elements;
		File f = new File("data/hello.html"); //\쓰면 에러남
		Document doc = Jsoup.parse(f,"UTF-8");//throws IOException
		//파일 -> Document 변환(DOm구조 변환)
		
		 
		// Document 나 Element 객체의
		// select(), selectFirst() 메소드로 특정 element(들)을 추출
		
		element = doc.selectFirst("div"); //첫번째 div
		//System.out.println((element.outerHtml()));
		
		elements = doc.select("div");
//		System.out.println(elements.size());//3개
		
		//Elements의 get(2) --> n번째 Element 리턴
//		element = elements.get(3);
//		System.out.println(element.outerHtml());
		
//		for(int i = 0; i < elements.size(); i++) {
//			element = elements.get(i);
//			System.out.println(element.outerHtml());
//			System.out.println();
//		}
//		
//		
//		for(Element e : elements) { 
//			System.out.println(e.outerHtml());
//			System.out.println();
//		}
		
		element = doc.selectFirst("div#addr");
		System.out.println(element.outerHtml());
		elements = element.select("ul.favorite a");
		//System.out.println(elements.size()); //3개 OK
		//텍스트, 링크 뽑기
		for(Element e : elements) {
//			System.out.println(e.outerHtml());
			System.out.println(e.text().trim());// 텍스트 꺼내기 Element.text().trim()
			System.out.println(e.attr("href").trim());//href라는 attribute안의 값을 가져온다 
		}
		
		//Q 이미지 소스 url 출력하기
		System.out.println();
		for(Element img : doc.select("img")) {
			System.out.println(img.attr("src").trim());
		}
		
		
		
		//System.out.println(doc.outerHtml());
		System.out.println("\n프로그램 종료");
	}

}
