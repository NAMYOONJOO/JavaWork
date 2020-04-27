package com.lec.java.crawl03;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl03Main {

	public static void main(String[] args) throws IOException {
		System.out.println("다음 실시간검색어");
		
		
			String url = "https://www.daum.net/";
			Response response = Jsoup.connect(url).execute();
			Document doc = response.parse();
			System.out.println(response.statusMessage());
			
			Elements elements = doc.select("div.slide_favorsch a");
			//elements = elements.select("a");
			for(Element e:elements) {
				System.out.println(e.text().trim());
			}
	}
	

}
 