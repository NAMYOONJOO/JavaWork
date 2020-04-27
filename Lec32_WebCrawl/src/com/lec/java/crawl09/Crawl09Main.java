package com.lec.java.crawl09;
// 연습
// 네이버 
// 블로그
//	-post title
//	-post url
//	-blog title

import java.io.IOException;
import java.net.URLEncoder;

import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

// 페이징 구현
public class Crawl09Main {

	public static void main(String[] args) throws IOException {
		System.out.println("네이버 페이징 : Pagination");
		
		for(int i = 1;i<=10;i++) {
			crawlNaverBlog("파이썬", i);
		}

		
	}
	public static void crawlNaverBlog(String search, int page) throws IOException {
		//크롤링 할 내용
		//post title
		//post link url
		//blog title
		
		//매개변수 검증
		if (search == null || search.trim().length() == 0 || page < 1)
			return;
		
		String url;
		Document doc;
		Response response;
		Elements elements;
		Elements rowElements;
		
		System.out.println(page +"페이지");
		
//		url = String.format("https://search.daum.net/search?w=blog&DA=PGD&enc=utf8&q=%s&page=%d",URLEncoder.encode(search, "utf-8"),page);
		url = String.format("https://search.naver.com/search.naver?date_from=&date_option=0&date_to=&dup_remove=1&nso=&post_blogurl=&post_blogurl_without=&query=%s&sm=tab_pge&srchby=all&st=sim&where=post&start=%d", URLEncoder.encode(search, "utf-8"),(page-1)*10+1);
//		System.out.println(url);
		doc = Jsoup.connect(url).execute().parse();
		elements = doc.select("#elThumbnailResultArea .sh_blog_top");
		for(Element e : elements) {
			String postTitle = e.selectFirst("li .sh_blog_title").text().trim();
			//System.out.println(postTitle);
			String blogTitle = e.selectFirst(".txt_block a").text().trim();
//			System.out.println(blogTitle);
			String postUrl = e.selectFirst("li .sh_blog_title").attr("href").trim();
//			System.out.println(postUrl);
			System.out.println(postTitle + " : "+blogTitle+" : "+postUrl);


		}
		System.out.println();
		
	}

}
