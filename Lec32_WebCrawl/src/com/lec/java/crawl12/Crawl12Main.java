package com.lec.java.crawl12;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

/*
 * Jsoup 를 사용한 XML 파싱
 * 
 * http://openapi.seoul.go.kr:8088/6561536751626864373042464d4356/xml/CardSubwayStatsNew/1/5/20181001
 */
public class Crawl12Main {

	public static final String REQ_SERVICE = "CardSubwayStatsNew";
	public static final String API_KEY = "4d46796d7366726f3833774a774955"; // 너의 key 값은?

	public static void main(String[] args) throws IOException {
		System.out.println("서울시 지하철호선별 역별 승하차 인원 정보");
		String url = buildUrlAddress("xml", 1, 5, "20200329");
		
		//XML파싱할때는 xml parser 사용
		Document doc = Jsoup.connect(url).parser(Parser.xmlParser()).get();
		//Jsoup
		
		Elements elements = doc.select("row");
		
		for(Element e : elements) {
			String LINE_NUM = e.select("LINE_NUM").text().trim();
			String SUB_STA_NM = e.select("SUB_STA_NM").text().trim();
			String RIDE_PASGR_NUM= e.select("RIDE_PASGR_NUM").text().trim();
			String ALIGHT_PASGR_NUM= e.select("ALIGHT_PASGR_NUM").text().trim();
			
			System.out.printf("%5s : %8s역 [승차:%6s 하차:%6s]\n", 
        			LINE_NUM, SUB_STA_NM, RIDE_PASGR_NUM, ALIGHT_PASGR_NUM);
			
			
		}
		
		
	} // end main()

	public static String buildUrlAddress(String reqType, int startIndex, int endIndex, String date) {

		String url_address = String.format("http://openapi.seoul.go.kr:8088/%s/%s/CardSubwayStatsNew/%d/%d/%s", API_KEY,
				reqType, startIndex, endIndex, date);

		return url_address;
		
	} // end buildUrlAddress()

}  // end class
		
		

