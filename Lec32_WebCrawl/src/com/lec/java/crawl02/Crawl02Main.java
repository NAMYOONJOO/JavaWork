package com.lec.java.crawl02;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl02Main { 

	public static void main(String[] args) throws IOException {
		System.out.println("네이트 인기검색어"); 
		
		String url = "https://www.nate.com/";
		Response response = Jsoup.connect(url).execute();
		Document doc = response.parse();
		System.out.println(response.statusMessage());
		//System.out.println(doc.outerHtml());
		Elements elements = doc.select("div.search_keyword dd a");
		//elements = elements.select("a");
		for(Element e:elements) {
			System.out.println(e.text().trim());
		}

	}

}
