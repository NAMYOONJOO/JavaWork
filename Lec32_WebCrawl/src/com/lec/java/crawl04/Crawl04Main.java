package com.lec.java.crawl04;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Scanner;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl04Main {

	public static void main(String[] args) throws IOException {
		System.out.println("네이버 연관 검색어");
		String url = "";
		Document doc;
		Response response;
		Elements elements;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("검색어를 입력하세요");
		String searchKeyword = sc.nextLine();
		sc.close();
		String encoded = URLEncoder.encode(searchKeyword,"utf-8");//네이버 검색페이지는 utf-8로 인코드 함
		
		
		url = "https://search.naver.com/search.naver?sm=top_hty&fbm=0&ie=utf8&query="
				+encoded;
		response = Jsoup.connect(url).execute();
		doc = response.parse();
		//System.out.println(doc.outerHtml());
		elements = doc.select("ul._related_keyword_ul a");
		for(Element e:elements) {
			System.out.println(e.text().trim());
		}
		System.out.println("\n프로그램 종료");
		
		
	}

}
