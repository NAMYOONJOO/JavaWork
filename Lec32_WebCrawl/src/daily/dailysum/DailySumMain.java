package daily.dailysum;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * 연습 : 자치구단위 서울 생활인구 일별 집계표
 * ■자치구단위 서울 생활인구 일별 집계표
 * 	http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-15379&srvType=S&serviceKind=1&currentPageNo=1
 * 	http://openapi.seoul.go.kr:8088/(인증키)/(요청파일타입)/SPOP_DAILYSUM_JACHI/(요청시작INDEX)/(요청종료INDEX)/(기준일ID)/(시군구코드)
 * 
 * 샘플url
 * 	XML 버젼
 * 	http://openapi.seoul.go.kr:8088/(인증키)/xml/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/20190101
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/20190101/11000
 * 
 * 	JSON 버젼
 * 	http://openapi.seoul.go.kr:8088/(인증키)/json/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/	
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/20190101
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/20190101/11000
 * 
 * ※ 한번에 1000개 까지의 데이터만 볼수 있슴
 * 
 */

/*  입력예]
 *  날짜입력: 20190101
 *  시작Index : 1
 *  끝Index: 5
 *  
 *  [XML]
 *  날짜             구ID        총생활인구수           일최대이동인구수
 *  ----------------------------------------------------------------------
 *  20190101	11000    11121182.98210      4764635.18080 
 *  20190101    11110    274919.65940        177877.95000 
 *  20190101    11140    267096.65940        149729.45840 
 *  20190101    11170    315220.18480        149329.14120 
 *  20190101    11200    351993.77950        153738.94490
 *   
 *  [JSON]
 *  날짜             구ID        총생활인구수           일최대이동인구수
 *  ----------------------------------------------------------------------
 *  20190101	11000    11121182.98210      4764635.18080 
 *  20190101    11110    274919.65940        177877.95000 
 *  20190101    11140    267096.65940        149729.45840 
 *  20190101    11170    315220.18480        149329.14120 
 *  20190101    11200    351993.77950        153738.94490 
 * 
 */

// ★ 주목 ★
// XML 은 Jsoup 를 활용하여 파싱하세요
// JSON 은  jackson 을 활용하여 파싱하세요

public class DailySumMain {

	public static void main(String[] args) throws IOException {
		System.out.println("자치구단위 서울 생활인구 일별 집계표");
		Scanner sc = new Scanner(System.in);

		System.out.print("날짜입력 : ");
		int date = sc.nextInt();
		System.out.print("시작Index : ");
		int startIndex = sc.nextInt();
		System.out.print("끝Index : ");
		int endIndex = sc.nextInt();

		// Jsoup
		System.out.println("\n[Pasing by jsoup]");
		String url = buildUrlAddress("xml", startIndex, endIndex, date);
		Document doc = Jsoup.connect(url).parser(Parser.xmlParser()).get();

		Elements elements = doc.select("row");
		System.out.println("날짜             구ID        총생활인구수           일최대이동인구수");
		System.out.println("---------------------------------------------------------------------");
		for (Element e : elements) {
			String STDR_DE_ID = e.select("STDR_DE_ID").text().trim();
			String SIGNGU_CODE_SE = e.select("SIGNGU_CODE_SE").text().trim();
			String TOT_LVPOP_CO = e.select("TOT_LVPOP_CO").text().trim();
			String DAIL_MXMM_MVMN_LVPOP_CO = e.select("DAIL_MXMM_MVMN_LVPOP_CO").text().trim();

			System.out.printf("%-9s%-7s%-15s%-15s\n", STDR_DE_ID, SIGNGU_CODE_SE, TOT_LVPOP_CO,
					DAIL_MXMM_MVMN_LVPOP_CO);

		}
		// =======================================================
		// jackson
		System.out.println("\n[Pasing by jackson]");
		url = buildUrlAddress("json", startIndex, endIndex, date);

		URL url2 = new URL(url);
		ObjectMapper mapper = new ObjectMapper();
		Seoul seoul = mapper.readValue(url2, Seoul.class);

		System.out.println("날짜             구ID        총생활인구수           일최대이동인구수");
		System.out.println("---------------------------------------------------------------------");

		for (RowList e : seoul.getDailySum().getRow()) {
			System.out.printf("%-9s%-7s%-15s%-15s\n", e.getId(), e.getCode(), e.getTotal(), e.getDaily());

		}

	} // end main

	public static String buildUrlAddress(String reqType, int startIndex, int endIndex, int date) {

		String url_address = String.format(
				"http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/%s/SPOP_DAILYSUM_JACHI/%d/%d/%d",
				reqType, startIndex, endIndex, date);

		return url_address;

	} // end buildUrlAddress()

} // end class

@JsonIgnoreProperties(ignoreUnknown = true)
class Seoul {
	@JsonProperty("SPOP_DAILYSUM_JACHI")
	Population dailySum;

	public Population getDailySum() {
		return dailySum;
	}

	public void setDailySum(Population dailySum) {
		this.dailySum = dailySum;
	}

}

@JsonIgnoreProperties(ignoreUnknown = true)
class Population {
	private ArrayList<RowList> row;

	public ArrayList<RowList> getRow() {
		return row;
	}

	public void setRow(ArrayList<RowList> row) {
		this.row = row;
	}

}

@JsonIgnoreProperties(ignoreUnknown = true)
class RowList {
	@JsonProperty("STDR_DE_ID")
	private String id;
	@JsonProperty("SIGNGU_CODE_SE")
	private String code;
	@JsonProperty("TOT_LVPOP_CO")
	private String total;
	@JsonProperty("DAIL_MXMM_MVMN_LVPOP_CO")
	private String daily;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getDaily() {
		return daily;
	}

	public void setDaily(String daily) {
		this.daily = daily;
	}

}