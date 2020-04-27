package com.lec.java.db01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;

/*
JDBC (Java DataBase Connectivity) 사용
 0. 라이브러리(jar) 추가:
  1) 이클립스 프로젝트 폴더에 libs 폴더를 생성
  2) C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib\ojdbc6_g.jar
 파일을 libs 폴더로 복사
  3) 복사한 라이브러리를 빌드패스에 추가   
		BulidPath - Configure Build Path..
		Libraries 탭에서  [Add JARs..]   ->  위 libs 폴더의 ojdbc6_g.jar 파일 추가
		Order and Export 탭에서  우선순위 Up (권장)

 1. Oracle 연동을 위한 정보들(상수들)을 정의(세팅)
 2. JDBC 드라이버 클래스를 메모리에 로드
 3. DB와 connection(연결)을 맺음
 4. Statement 인스턴스를 생성 (SQL을 사용하기 위한 인스턴스)
 5. SQL 문장 작성(SELECT, INSERT, UPDATE, DELETE)
 6. SQL 문장을 DB 서버로 전송
 7. 실행 결과 확인
*/

// er-diagram 만들기
// http://ermaster.sourceforge.net/update-site


public class DB01Main {

	// 1.  1. Oracle 연동을 위한 정보들(상수들)을 정의(세팅)
	// JDBC 드라이버 클래스 정보 
	public static final String DRIVER = 
			"oracle.jdbc.driver.OracleDriver";
	
	// DB 서버 접속 주소 정보 
	public static final String URL ="jdbc:oracle:thin:@localhost:1521:XE";
	
	// DB 접속 사용자 계정정보
	public static final String USER ="scott0316";
	public static final String PASSWD ="tiger0316";
		
	public static void main(String[] args) {
		System.out.println("DB 1 : JDBC 프로그래밍");
		
		Connection conn = null; //java.sql.Connection
		
		Statement stmt = null; //java.sql.Statement;
		
		ResultSet rs = null; //java.sql.ResultSet;
		try {
			//2. JDBC 드라이버 클래스를 메모리에 로드
			Class.forName(DRIVER);//<-동적 클래스 로딩  //catch (ClassNotFoundException e)
			System.out.println("드라이버 클래스 로딩 성공");
			
			// 3. DB와 connection(연결)을 맺음
			conn = DriverManager.getConnection(URL,USER,PASSWD); // catch (SQLException e)
			System.out.println("DB Connect 연결");
			
			// 4. Statement 인스턴스를 생성 (SQL을 사용하기 위한 인스턴스)
			//(DB에 Query날리기)
			stmt = conn.createStatement();//conn으로부터 statement가 만들어진다.
			System.out.println("Statement생성 성공");
			//statement도 자원이기때문에 close해줘야한다. conn이 먼저 생성되었기 때문에 statement를 먼저 close해준다.
			
			// 5. SQL 문장 작성(SELECT, INSERT, UPDATE, DELETE)
			System.out.println();
			String sql_insert = "insert into test_member Values(100,'마징가',sysdate)";
			
//			int no = 200;
//			String name = "뽀로로";
//			sql_insert = "INSERT INTO test_member values("+no+",'"+name+"',sysdate)";
			
			System.out.println(sql_insert);
			int cnt = stmt.executeUpdate(sql_insert);// 'DML'명령은 executeUpdate() 로 실행
											// 리턴값은 정수 int
			System.out.println(cnt+"개 row(행)이 insert됨");
			
			System.out.println();
			String sql_select = "SELECT mb_no, mb_name,mb_birthdate From test_member";
			System.out.println(sql_select);
			
			rs = stmt.executeQuery(sql_select); // 'SELECT' 및 기타 쿼리(는 DDL을 말한다. ex table 생성가능)의 경우 excuteQuery()로 실행
											// select의 결과는 항상 table
											// 리턴값은 ResultSet객체 
			
											//rs도 자원이기 때문에 close
			
			// ResultSet 에 담겨 있는 record 확인
			// 7. 실행 결과 확인
			// 7-1 컬럼 이름으로 받기
			System.out.println();
//			while(rs.next()) { //next() 레코드 하나 추출하고 true 리턴, 더이상 뽑아낼 레코드 없으면 false 리턴
//				
//				String no = rs.getString("mb_no"); //getXXX() 에  '컬럼명' 혹은 '별명 명시 
//				String name = rs.getString("mb_name");
//				String birthdate = rs.getString("mb_birthdate");
//				
//				String result = no+"\t |"+name+"\t |"+birthdate;
//				System.out.println(result);
//				
//		
//				
//			}
			
			// 7-2 컬럼 인덱스로 받기
//			System.out.println();
//			while(rs.next()) { //next() 레코드 하나 추출하고 true 리턴, 더이상 뽑아낼 레코드 없으면 false 리턴
//				// DB의 인덱스는 1부터 시작!
//				String no = rs.getString(1); //getXXX() 에  인덱스 명시 가능 (1부터 시작!)
//				String name = rs.getString(2);
//				String birthdate = rs.getString(3);
//				
//				String result = no+"\t |"+name+"\t |"+birthdate;
//				System.out.println(result);
//				
//			}

			
			// 7-3 null처리
			// getXXX()로  가져온 데이터가 NULL값이면  null 리턴한다. 
			System.out.println();
			while(rs.next()) { //next() 레코드 하나 추출하고 true 리턴, 더이상 뽑아낼 레코드 없으면 false 리턴
				
				String no = rs.getString("mb_no"); //getXXX() 에  '컬럼명' 혹은 '별명 명시 
				if (no ==null)no = "";
				String name = rs.getString("mb_name");
				String birthdate = rs.getString("mb_birthdate");
				if (birthdate ==null)birthdate = "";
				
				String result = no+"\t |"+name+"\t |"+birthdate;
				System.out.println(result);
				
		
				
			}
			
			// 7-4 개별적인 타입으로 get하기 
//			System.out.println();
//			while(rs.next()) { //next() 레코드 하나 추출하고 true 리턴, 더이상 뽑아낼 레코드 없으면 false 리턴
//				
//				int no = rs.getInt("mb_no"); //getXXX() 에  '컬럼명' 혹은 '별명 명시 
//				// mb_no 컬럼이 null이면  0 리턴
//				
//				String name = rs.getString("mb_name");
//				
//				String birthdate ="";
//				if (birthdate ==null)birthdate = "";
//				
//				
//				//java.sql.Time;  //java.sql.Date;
//				Date d = rs.getDate("mb_birthdate"); //날짜만 가져옵니다
//				Time t = rs.getTime("mb_birthdate");//시간만 가져온다 
//				if(d !=null) {
//					birthdate = new SimpleDateFormat("yyyy년MM월dd일").format(d)+
//							" "+new SimpleDateFormat("hh:mm:ss").format(t);
//					
//				}
//				
//				String result = no+"\t |"+name+"\t |"+birthdate;
//				System.out.println(result);
//				
//		
//				
//			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// 나중에 만들어진 인스턴스부터 먼저 close()해주자 
				if(rs!=null)
					rs.close();
				if(stmt!=null)
					stmt.close();
				
				if(conn!=null)
					conn.close(); //trycatch로 잡기
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		

		System.out.println("프로그램 종료");
	} // end main()

} // end class DB01Main













