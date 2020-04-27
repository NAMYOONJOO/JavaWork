package com.lec.java.file17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/* HTML 데이터, 웹데이터 (텍스트)
 * Java 에서 웹 연결을 위한 객체 두가지
 * 	1. URL : 웹 상의 주소, 
 * 	2. HttpURLConnection : 웹연결
 * 		URLConnection
 * 		 └─ HttpURLConnection
 * 
 * 	java.io.Reader    프로그램이 '문자 단위' 데이터를 읽어들이는(read) 통로
 * 		├─ java.io.InputStreamReader    // 스트림 기반의 reader
 * 		└─ java.io.BufferedReader 		// 문자(character) 기반 reader
 */

public class File17Main {

	public static void main(String[] args) {
		System.out.println("웹데이터 가져오기(텍스트)");

		String url = "https://www.daum.net";
//		String url = "https://www.naver.com/srchrank?frm=main&ag=all&gr=1&ma=-2&si=0&en=0&sp=0";
		// 실검 데이터를 뽑는 부눈
		StringBuffer sb = readFromUrl(url);
//		System.out.println(sb.toString().substring(0, 200)); : 앞에 200자만 출력
		System.out.println(sb);

		System.out.println("\n프로그램 종료");
	} // end main()

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

} // end class
