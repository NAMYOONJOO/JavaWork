package com.product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.product.Query;

public class product implements Query{

	public static void main(String[] args) {
		setProductList();//세팅		
		
		
		String clientId = "Fd5OqnTUuUF6qX27jBWS"; // 애플리케이션 클라이언트 아이디값"
		String clientSecret = "7xhDrhhGUJ"; // 애플리케이션 클라이언트 시크릿값"

		String []category = new String[] {"쇼파","침구","커튼","책상"};
		
		for (int i = 0; i < category.length; i++) {
			
			String text = null;
			try {
				text = URLEncoder.encode(category[i], "UTF-8");
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException("검색어 인코딩 실패", e);
			}

			String apiURL = "https://openapi.naver.com/v1/search/shop?query=" + text + "&display=100"; // json 결과

			Map<String, String> requestHeaders = new HashMap<>();
			requestHeaders.put("X-Naver-Client-Id", clientId);
			requestHeaders.put("X-Naver-Client-Secret", clientSecret);
			String responseBody = get(apiURL, requestHeaders);

			//System.out.println(responseBody);

			parseJSON(responseBody,i);
			
		}
		
		
	}
	
	//초기실행
	private static void setProductList() {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// OracleDriver 클래스를 메모리에 로딩
			Class.forName(DRIVER);
			System.out.println("드라이버 클래스 로딩 성공");
			
			// DB Connection
			conn = DriverManager.getConnection(URL, USER, PASSWD);
			System.out.println("DB Connection 성공");
			
			// Statement 작성
			stmt = conn.createStatement();
			
			// 1. Connection 의 auto commit 을 해제
			// TODO
			conn.setAutoCommit(false);
			
			// 2. 쿼리연산(들) 수행
			// TODO
			stmt.executeUpdate(SQL_DROP_TABLE);
			stmt.executeUpdate(SQL_DROP_SEQ);
			stmt.executeUpdate(SQL_CREATE_SEQ);
			stmt.executeUpdate(SQL_CREATE_TABLE);
			
			

			// 3. 정상적으로 완료되면 commit() 실행
			// TODO  
			System.out.println("commit실행");
			conn.commit();
			
		
			
						
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQL 에러: " + e.getMessage());
			e.printStackTrace();
			
			// 4. 예외 발생등으로 실패 rollback() 실행
			if(conn != null) {
				try {
					System.out.println("rollback ㅅㄱ~");
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} // end try-catch

	}
	
	
	

	private static String get(String apiUrl, Map<String, String> requestHeaders) {
		HttpURLConnection con = connect(apiUrl);
		try {
			con.setRequestMethod("GET");
			for (Map.Entry<String, String> header : requestHeaders.entrySet()) {
				con.setRequestProperty(header.getKey(), header.getValue());
			}

			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
				return readBody(con.getInputStream());
			} else { // 에러 발생
				return readBody(con.getErrorStream());
			}
		} catch (IOException e) {
			throw new RuntimeException("API 요청과 응답 실패", e);
		} finally {
			con.disconnect();
		}
	}

	private static HttpURLConnection connect(String apiUrl) {
		try {
			URL url = new URL(apiUrl);
			return (HttpURLConnection) url.openConnection();
		} catch (MalformedURLException e) {
			throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
		} catch (IOException e) {
			throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
		}
	}

	private static String readBody(InputStream body) {
		InputStreamReader streamReader = new InputStreamReader(body);

		try (BufferedReader lineReader = new BufferedReader(streamReader)) {
			StringBuilder responseBody = new StringBuilder();

			String line;
			while ((line = lineReader.readLine()) != null) {
				responseBody.append(line);
			}

			return responseBody.toString();
		} catch (IOException e) {
			throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
		}
	}

	public static void parseJSON(String jsonText,int pcode) {
		JSONObject jObj = new JSONObject(jsonText);
		JSONArray items = jObj.getJSONArray("items");
		
		for (int i = 0; i < items.length(); i++) {
			JSONObject product = items.getJSONObject(i);
			String ptitle = product.getString("title").split("<b>")[0];
			String pimage = product.getString("image");
			int pprice =  Integer.parseInt(product.getString("hprice"));
			String pbrand = product.getString("brand");


			if(pprice==0||ptitle.equals("")||pimage.equals("")||pbrand.equals(""))continue;
			//--------------------------------------------------
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String [] generatedCols = {COL_LABEL_PID};
			
			try {
				// OracleDriver 클래스를 메모리에 로딩
				Class.forName(DRIVER);
			//	System.out.println("드라이버 클래스 로딩 성공");
				
				// DB Connection
				conn = DriverManager.getConnection(URL, USER, PASSWD);
			//	System.out.println("DB Connection 성공");
				
				//System.out.println();
				//System.out.println("INSERT");
				// Statement 나 PreparedStatement 생성시 두번째 매개변수로 auto-generated keys 배열 넘겨줌
				
				pstmt = conn.prepareStatement(SQL_INSERT_SEQ, generatedCols);
				pstmt.setString(1, ptitle);
				pstmt.setInt(2, pprice);
				pstmt.setString(3, pbrand);
				pstmt.setString(4, pimage);
				pstmt.setInt(5, pcode+1);
				pstmt.executeUpdate();
				//System.out.println(cnt + "개 행 INSERT 성공");
				
				
				// auto-generated keys 값 뽑아오기
				rs = pstmt.getGeneratedKeys();
				if(rs.next()) {
					long genkey= rs.getLong(1);
					//System.out.println("자동생성된 key값 = "+genkey);
				}
				
				rs.close();
				pstmt.close();
				
			} catch (ClassNotFoundException e) {
				//e.printStackTrace();
			} catch (SQLException e) {
				// SQL 에러 메세지는 SQLException 에서 확인가능
			//	System.out.println("SQL 에러: " + e.getMessage());
				//e.printStackTrace();
			} finally {
				try {
					if (rs != null) {
						rs.close();
					}
					if (pstmt != null) {
						pstmt.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					//e.printStackTrace();
				}
			} // end try-catch
			

		}
	}
}

