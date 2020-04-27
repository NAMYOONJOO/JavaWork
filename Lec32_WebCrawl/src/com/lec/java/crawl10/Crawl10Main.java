package com.lec.java.crawl10;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



/* XML, Json 파싱1
 * 
 * ■서울시 지하철호선별 역별 승하차 인원 정보 
 * http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-12914&srvType=A&serviceKind=1&currentPageNo=1
 * 
 * 샘플url
 * XML 버젼
 * http://openapi.seoul.go.kr:8088/키값을넣으세요/xml/CardSubwayStatsNew/1/5/20181001
 * 예) http://openapi.seoul.go.kr:8088/6561536751626864373042464d4356/xml/CardSubwayStatsNew/1/5/20181001
 *   
 * JSON 버젼
 * http://openapi.seoul.go.kr:8088/키값을넣으세요/json/CardSubwayStatsNew/1/5/20181001
 * 예) http://openapi.seoul.go.kr:8088/6561536751626864373042464d4356/json/CardSubwayStatsNew/1/5/20181001 
 * */

/* JSON 파싱
java.io.Reader    프로그램이 '문자 단위' 데이터를 읽어들이는(read) 통로
	├─ java.io.InputStreamReader    // 스트림 기반의 reader
 	└─ java.io.BufferedReader 		// 문자(character) 기반 reader
 */

public class Crawl10Main {
	public static final String REQ_SERVICE = "CardSubwayStatsNew";
	public static final String API_KEY = "6561536751626864373042464d4356";

	public static void main(String[] args) {
		System.out.println("서울시 지하철호선별 역별 승하차 인원 정보");

		int startIndex; // 요청시작위치 정수 입력 (페이징 시작번호 입니다 : 데이터 행 시작번호)
		int endIndex; // 요청종료위치 정수 입력 (페이징 끝번호 입니다 : 데이터 행 끝번호)
		String date; // 날짜 yyyymmdd 형식

		StringBuffer sb; // response 받은 텍스트

		startIndex = 1;
		endIndex = 5;
		date = "20200329";
		String url_address;
		//26강 17번 패키지 참고!!!!!!!!!
		System.out.println("------XML Parsing ------");
		url_address = buildUrlAddress("xml", startIndex, endIndex, date);
		sb = readFromUrl(url_address);
		parseXML(sb.toString());
		
		
		
		System.out.println("------JSON Parsing ------");
		url_address = buildUrlAddress("json", startIndex, endIndex, date);
		sb = readFromUrl(url_address);
		parseJSON(sb.toString());
		

		
		
		
		
		
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

	public static String buildUrlAddress(String reqType, int startIndex, int endIndex, String date) {
		String url_address = String.format("http://openapi.seoul.go.kr:8088/%s/%s/CardSubwayStatsNew/%d/%d/%s",
				API_KEY, reqType, startIndex, endIndex, date);
		
		return url_address;
	}
	/**
	 * 
	 * @param urlAddress : 주어진 url주소
	 * @return 서버로부터 받은 텍스트데이터(HTML) 리턴
	 */
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
	
	public static void parseXML(String xmlText) {
		//DoMd을 Parsing하는 객체들
		DocumentBuilderFactory dbFactory;
		DocumentBuilder dBuilder;//DocumentBuilderFactory를 경우에서 만들어야 한다
		
		//DOC parser 객체 생성
		try {
			dbFactory = DocumentBuilderFactory.newInstance();//생성자따로 없다. 
			dBuilder = dbFactory.newDocumentBuilder();
			
			//String->InputStream 변환
			InputStream in = new ByteArrayInputStream(xmlText.getBytes("utf-8"));//utf-8로 인코딩된 
			
			//InputStream ---> DOM객체 생성
			Document dom = dBuilder.parse(in);
			//import org.w3c.dom.Document;//
			
			//DOM최상위 document element 추출
			Element docElement = dom.getDocumentElement();//DOM의 최상위 Element
			//import org.w3c.dom.Element;
			
			//파싱하기전 normalize()
			docElement.normalize(); // 흩어진 text node 들을 정렬하는 등의 절차
								    // XML을 파싱하기 전 꼭 nomalize해주기
			//DOM내의 데이터 파싱
			NodeList nList = dom.getElementsByTagName("row");   ///<row?//</row> element 들로 구성된 NodeList 리턴
			///노드 '들'로 이루어진 리스트
			System.out.println("<row>갯수 : "+nList.getLength());
			
			System.out.println();
			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);	 // row element가 담긴다.
//				System.out.println("node타입 : "+node.getNodeType()); //1 : element node
				if (node.getNodeType()!=node.ELEMENT_NODE)continue; //ELEMENT_NODE = 1
				Element rowElement = (Element)node;
//				System.out.println(rowElement.getTextContent());
				String LINE_NUM = rowElement.getElementsByTagName("LINE_NUM").item(0).getChildNodes().item(0).getNodeValue().trim(); //한기든 여러개든 elements 리턴
				String SUB_STA_NM = rowElement.getElementsByTagName("SUB_STA_NM").item(0).getChildNodes().item(0).getNodeValue().trim(); //한기든 여러개든 elements 리턴
				String RIDE_PASGR_NUM = rowElement.getElementsByTagName("RIDE_PASGR_NUM").item(0).getChildNodes().item(0).getNodeValue().trim(); //한기든 여러개든 elements 리턴
				String ALIGHT_PASGR_NUM = rowElement.getElementsByTagName("ALIGHT_PASGR_NUM").item(0).getChildNodes().item(0).getNodeValue().trim(); //한기든 여러개든 elements 리턴
				
				System.out.printf("%5s : %8s역 [승차 : %6s 하차 : %6s]\n",LINE_NUM,SUB_STA_NM,RIDE_PASGR_NUM,ALIGHT_PASGR_NUM);
				
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}//end parseXML
	public static void parseJSON(String jsonText) {
		// org.json  라이브러리 다운로드
		// https://mvnrepository.com/artifact/org.json/json
		// 최신버젼 클릭후, Files 항목 클릭해서 다운로드
		JSONObject jObj = new JSONObject(jsonText);  // JSON파싱 : JSONObject <- string
		JSONArray row = jObj.getJSONObject("CardSubwayStatsNew").getJSONArray("row");
		System.out.println("row의 갯수 " + row.length());
		for(int i = 0 ;i<row.length();i++) {
			JSONObject station = row.getJSONObject(i);
			
			String LINE_NUM=station.getString("LINE_NUM");
			String SUB_STA_NM=station.getString("SUB_STA_NM");
			int RIDE_PASGR_NUM = station.getInt("RIDE_PASGR_NUM");
			int ALIGHT_PASGR_NUM = station.getInt("ALIGHT_PASGR_NUM");
			
			System.out.printf("%5s : %8s역 [승차 : %6d 하차 : %6d]\n",LINE_NUM,SUB_STA_NM,RIDE_PASGR_NUM,ALIGHT_PASGR_NUM);

			
		}
	
	}
} // end class
