package com.lec.java.crawl16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//https://www.yogiyo.co.kr/api/v1/restaurants-geo/?items=20&lat=37.5108593855466&lng=127.029258482886&order=rank&page=0&search=
public class Crawl16Main {

	public static void main(String[] args) throws IOException, JsonProcessingException {
		System.out.println("요기요 맛집 정보 : header 추가");
		
		String url = "https://www.yogiyo.co.kr/api/v1/restaurants-geo/?items=20&lat=37.4936151279937&lng=127.032670651995&order=rank&page=0&search=";
		
		StringBuffer sb = readFromUrl(url);
		//System.out.println(sb);
		
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		Restaurants restaurants=mapper.readValue(sb.toString(), Restaurants.class);
		//맛집이름,
		//평점
		
		for(Info e : restaurants.getrestaurants()) {
			System.out.printf("%-30s%.1f\n",e.getName(),e.getReviewAvg());
		}
		
		System.out.println("\n프로그램 종료");
		
		
		
	}
	public static StringBuffer readFromUrl(String urlAddress) {

		StringBuffer sb = new StringBuffer(); // response 받은 데이터 담을 객체
		// StringBuffer -> append() : 차곡차곡 넣는 동작 --->최적화
		// String ->concat()
		// URL 객체 생성
		URL url = null; // java.net.URL (import)
		HttpURLConnection conn = null; // java.net.HttpURLConnection

		InputStream in = null; // 바이트 단위
		InputStreamReader reader = null; // 바이트 스트림을 --->문자기반 Reader
		BufferedReader br = null;

		char[] buf = new char[512];// 문자용 버퍼

		// BufferedReader(버퍼)<-InputStreamReader(단어)<-inputStream (바이트단위)
		// <-HttpURLConnection

		// 1. URL 객체 만들기
		try {
			url = new URL(urlAddress);
			conn = (HttpURLConnection) url.openConnection();
			if (conn != null) { // 여러가지 상황에서 null이 발생될 수 있다. 서버가 존재하지 않을때 등등
				conn.setConnectTimeout(2000);// 2초 이내에 연결이 수립안되면
												// java.net.SocketTimeoutException 발생

				conn.setRequestMethod("GET");// GET방식 request
												// "GET", "POST"
				conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
				conn.setUseCaches(false);// URL사용할때 캐시사용을 안하겠습니다.

				
				
				//헤더 정보 추가 ***********************************
				conn.setRequestProperty("X-ApiKey", "iphoneap");
				conn.setRequestProperty("x-apisecret", "fe5183cc3dea12bd0ce299cf110a75a2");
				
				//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				
				
				
				
				
				
				
				
				System.out.println("request 시작 :" + urlAddress);
				conn.connect();// 커넥트 시작
				// request 발생 ----->이후 response 받을 때까지 delay
				System.out.println("response완료");

				// resopnse 코드값 확인 : int형
				// response 받은 후 가장 먼저 response code확인 (200이 정상)
				// 200 : 정상적인 response 나머지 : 에러사항, 사른 처리
				int responseCode = conn.getResponseCode();
				// 참고 : response code MDN
				// 참조 사이트 : https://developer.mozilla.org/ko/docs/Web/HTTP/Status

				System.out.println("response code : " + responseCode);

				if (responseCode == HttpURLConnection.HTTP_OK) {// 정상 //코드값 200
					//// BufferedReader(버퍼)<-InputStreamReader(단어)<-inputStream (바이트단위)
					in = conn.getInputStream();// InputStream <- HttpURLConnection //InputStreamReader(단어)<-inputStream
												// (바이트단위)
					reader = new InputStreamReader(in, "utf-8");//// InputStreamReader(단어)<-inputStream (바이트단위)
					br = new BufferedReader(reader);// BufferedReader(버퍼)<-InputStreamReader(단어)
					int cnt;// 읽은 글자의 갯수
					while ((cnt = br.read(buf)) != -1) {// 읽을것이 없으면 -1 리턴
						sb.append(buf, 0, cnt);// response 받은 텍스트를 stringBuffer 에 추가
					}
				} else {
					System.out.println("response 실패");
					return null;
				}
			} else { // connection null 커넥션 자체가 잡히지 않음
				System.out.println("conn null");
				return null;
			}
		} catch (MalformedURLException e) { // URL이 잘못되어있다.(정규표현식으로 확인된다. )
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
			}
			if (conn != null)
				conn.disconnect(); // 커넥션도 자원이다
			// 작없끝나고 Connection 해제
		}

		return sb;
	}
}
@JsonIgnoreProperties(ignoreUnknown = true)
class Restaurants{
	private ArrayList<Info> restaurants;

	public Restaurants() {
	}
	public Restaurants(ArrayList<Info> restaurants) {
		this.restaurants = restaurants;
	}
	public ArrayList<Info> getrestaurants() {
		return restaurants;
	}
	public void setrestaurants(ArrayList<Info> restaurants) {
		this.restaurants = restaurants;
	}

	
	
	
}
@JsonIgnoreProperties(ignoreUnknown = true)
class Info{
	@JsonProperty("slug")
	String name;
	@JsonProperty("review_avg")
	double reviewAvg;
	public Info() {
		super();
	}
	public Info(String name, double reviewAvg) {
		super();
		this.name = name;
		this.reviewAvg = reviewAvg;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getReviewAvg() {
		return reviewAvg;
	}
	public void setReviewAvg(double reviewAvg) {
		this.reviewAvg = reviewAvg;
	}
	
	
	
	
}

