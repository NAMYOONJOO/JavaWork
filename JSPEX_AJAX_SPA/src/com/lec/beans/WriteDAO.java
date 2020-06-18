package com.lec.beans;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import common.D;

// DAO : Data Access Object
//   DB 에 접속하여 트랜잭션을 수행하는 객체

// 다루는 데이터 소스의 종류에 따라 DAO는 여러개 정의 사용 가능

public class WriteDAO {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;   // SELECT 결과, executeQuery()
	
	// DAO 객체가 생성될때 Connection 도 생성된다.
	public WriteDAO() {
		
		try {
			Class.forName(D.DRIVER);
			conn = DriverManager.getConnection(D.URL, D.USERID, D.USERPW);
			System.out.println("WriteDAO 생성, 데이터 베이스 연결!");
		} catch(Exception e) {
			e.printStackTrace();
			// throw e;
		}		
		
	} // 생성자

	// DB 자원 반납 메소드,
	public void close() throws SQLException {
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(stmt != null) stmt.close();
		if(conn != null) conn.close();
	} // end close()
	
	// 새글 작성 <-- DTO
	public int insert(WriteDTO dto) throws SQLException {
		String subject = dto.getSubject();
		String content = dto.getContent();
		String name = dto.getName();
		
		int cnt = this.insert(subject, content, name);
		return cnt;
	}
	
	// 새글 작성 <-- 제목, 내용, 작성자 
	public int insert(String subject, String content, String name) throws SQLException {
		int cnt = 0;
		
		try {			
			pstmt = conn.prepareStatement(D.SQL_WRITE_INSERT);
			pstmt.setString(1, subject);
			pstmt.setString(2, content);
			pstmt.setString(3, name);
			
			cnt = pstmt.executeUpdate();
		} finally {
			close();			
		}

		return cnt;
	}
	
	// ResultSet --> DTO 배열로 리턴
	public WriteDTO [] createArray(ResultSet rs) throws SQLException {
		WriteDTO [] arr = null;  // DTO 배열
		
		ArrayList<WriteDTO> list = new ArrayList<WriteDTO>();
		
		while(rs.next()) {
			int uid = rs.getInt("wr_uid");
			String subject = rs.getString("wr_subject");
			String name = rs.getString("wr_name");
			String content = rs.getString("wr_content");
			int viewCnt = rs.getInt("wr_viewcnt");
			Date d = rs.getDate("wr_regdate");
			Time t = rs.getTime("wr_regdate");
			
			String regDate = "";
			if(d != null){
				regDate = new SimpleDateFormat("yyyy-MM-dd").format(d) + " "
						+ new SimpleDateFormat("hh:mm:ss").format(t);
			}
			
			WriteDTO dto = new WriteDTO(uid, subject, content, name, viewCnt);
			dto.setRegDate(regDate);
			list.add(dto);
			
		} // end while
		
		int size = list.size();
		
		if(size == 0) return null;
		
		arr = new WriteDTO[size];
		list.toArray(arr);  // List -> 배열		
		return arr;
	}
	
	// 전체 SELECT
	public WriteDTO [] select() throws SQLException {
		WriteDTO [] arr = null;
		
		try {
			pstmt = conn.prepareStatement(D.SQL_WRITE_SELECT);
			rs = pstmt.executeQuery();
			arr = createArray(rs);
		} finally {
			close();
		}		
		
		return arr;
	} // end select()
	
	// 페이징 관련
	// 몇번째 from 부터 몇개 rows 를 SELECT
	public WriteDTO [] selectFromRow(int from, int rows) throws SQLException {
		WriteDTO [] arr = null;
		
		try {
			pstmt = conn.prepareStatement(D.SQL_WRITE_SELECT_FROM_ROW);
			pstmt.setInt(1,  from);
			pstmt.setInt(2,  from + rows);
			rs = pstmt.executeQuery();
			arr = createArray(rs);			
		} finally {
			close();
		} // end try
		
		return arr;
	} // end selectFromRow()
	
	// 전체 글의 개수
	public int countAll() throws SQLException {
		int cnt = 0;
		
		try {
			pstmt = conn.prepareStatement(D.SQL_WRITE_COUNT_ALL);
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt(1);
		} finally {
			close();
		} // end try
		
		return cnt;
	} // countAll()
	
	
	
	
	// 특정 uid 의 글 내용 읽기, 조회수 증가
	// viewCnt 도 1 증가 해야 하고, 글 읽어와야 한다 --> 트랜잭션 처리
	public WriteDTO [] readByUid(int uid) throws SQLException{
		int cnt = 0;
		WriteDTO [] arr = null;
		
		try {
			// 트랜잭션 처리
			// Auto-commit 비활성화
			conn.setAutoCommit(false);
			
			// 쿼리들 수행
			pstmt = conn.prepareStatement(D.SQL_WRITE_INC_VIEWCNT);
			pstmt.setInt(1, uid);
			cnt = pstmt.executeUpdate();
			
			pstmt.close();
			
			pstmt = conn.prepareStatement(D.SQL_WRITE_SELECT_BY_UID);
			pstmt.setInt(1, uid);
			rs = pstmt.executeQuery();
			
			arr = createArray(rs);
			conn.commit();
			
		} catch(SQLException e) {
			conn.rollback();
			throw e;
		} finally {
			close();
		}
		
		return arr;
	} // end readByUid()
	
	
	// 특정 uid 의 글 만 SELECT (조회수 증가 없슴!)
	public WriteDTO [] selectByUid(int uid) throws SQLException {
		WriteDTO [] arr = null;
		
		try {
			pstmt = conn.prepareStatement(D.SQL_WRITE_SELECT_BY_UID);
			pstmt.setInt(1, uid);
			rs = pstmt.executeQuery();
			arr = createArray(rs);
		} finally {
			close();
		}
		return arr;
	}
	
	
	// 특정 uid 의 글 수정 (제목, 내용)
	public int update(int uid, String subject, String content) throws SQLException {
		int cnt = 0;
		try {
			pstmt = conn.prepareStatement(D.SQL_WRITE_UPDATE);
			pstmt.setString(1, subject);
			pstmt.setString(2, content);
			pstmt.setInt(3, uid);
			
			cnt = pstmt.executeUpdate();
		} finally {
			close();
		}		
		
		return cnt;
	} // end update()
	
	// 특정 uid 글 삭제하기
	public int deleteByUid(int uid) throws SQLException {
		int cnt = 0;
		try {
			pstmt = conn.prepareStatement(D.SQL_WRITE_DELETE_BY_UID);
			pstmt.setInt(1, uid);
			cnt = pstmt.executeUpdate();
		} finally {
			close();
		}		
		return cnt;
	} // end deleteByUid()
	
	// 특정 uid 글(들) 삭제하기
	public int deleteByUid(int [] uids) throws SQLException {
		if(uids == null || uids.length == 0) return 0;
		
		int cnt = 0;
		
		try {
			StringBuffer sql = new StringBuffer("DELETE FROM test_write WHERE wr_uid IN (");
			for(int uid : uids) {
				sql.append(uid + ",");
			}
			sql.deleteCharAt(sql.lastIndexOf(","));  // 맨 끝의 콤마 삭제
			sql.append(")");
			
			stmt = conn.createStatement();
			cnt = stmt.executeUpdate(sql.toString());
					
		} finally {
			close();
		} // end try		
		
		return cnt;
	} // end deleteByUid()
	
	
	
	
} // end DAO










