package com.lec.java.test9;

import java.io.IOException;

import org.jsoup.Connection.Response;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;

import org.jsoup.select.Elements;

//https://movie.naver.com/movie/sdb/rank/rmovie.nhn

public class Test9 {

	public static void main(String[] args) throws IOException {

		System.out.println("영화 인기검색어");

		String url;

		Response response;

		Document doc;

		Element element;

		url = "https://movie.naver.com/movie/sdb/rank/rmovie.nhn";

		response = Jsoup.connect(url).execute();

		doc = response.parse();

		String outerHtml = doc.outerHtml();

		Element movieElement = doc.selectFirst("#assistant .r_ranking");

		Elements elements = movieElement.select("a");

	

		for (Element e : elements) {

			System.out.println(e.select("span").text()+" " + e.attr("title"));

		
 
		}

	}

}