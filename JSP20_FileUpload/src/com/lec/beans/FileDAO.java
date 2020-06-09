package com.lec.beans;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import common.D;
import oracle.net.aso.p;

// DAO : Data Access Object
//   DB 에 접속하여 트랜잭션을 수행하는 객체

// 다루는 데이터 소스의 종류에 따라 DAO는 여러개 정의 사용 가능

public class FileDAO {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null; // SELECT 결과, executeQuery()

	// DAO 객체가 생성될때 Connection 도 생성된다.
	public FileDAO() {

		try {
			Class.forName(D.DRIVER);
			conn = DriverManager.getConnection(D.URL, D.UID, D.UPW);
			System.out.println("WriteDAO 생성, 데이터 베이스 연결!");
		} catch (Exception e) {
			e.printStackTrace();
			// throw e;
		}

	} // 생성자

	// DB 자원 반납 메소드,
	public void close() throws SQLException {
		if (rs != null)
			rs.close();
		if (pstmt != null)
			pstmt.close();
		if (stmt != null)
			stmt.close();
		if (conn != null)
			conn.close();
	} // end close()

	// ResultSet --> DTO 배열로 리턴
	public FileDTO[] createArray(ResultSet rs) throws SQLException {
		FileDTO[] arr = null;
		List<FileDTO> list = new ArrayList<FileDTO>();

		while (rs.next()) {
			int uid = rs.getInt("bf_uid");
			String source = rs.getString("bf_source");
			String file = rs.getString("bf_file");

			FileDTO dto = new FileDTO(uid, source, file);
			list.add(dto);
		} // end while

		arr = new FileDTO[list.size()];
		list.toArray(arr);
		return arr;
	} // end createArray()

	// 특정 글 (wr_uid) 의 첨부파일(들) SELECT
	public FileDTO[] selectFilesByWrUid(int wrUid) throws SQLException {
		FileDTO[] arr = null;
		try {
			pstmt = conn.prepareStatement(D.SQL_FILE_SELECT);
			pstmt.setInt(1, wrUid);
			rs = pstmt.executeQuery();
			arr = createArray(rs);
		} finally {
			close();
		}
		return arr;
	} // end selectFilesByWrUid

	// 특정 파일 (bf_uid) 의 첨부파일 하나 SELECT
	public FileDTO[] selectByUid(int uid) throws SQLException {
		FileDTO[] arr = null;
		try {
			pstmt = conn.prepareStatement(D.SQL_FILE_SELECT_BY_UID);
			pstmt.setInt(1, uid);
			rs = pstmt.executeQuery();
			arr = createArray(rs);
		} finally {
			close();
		}
		return arr;
	} // end selectFilesByWrUid

	// 특정글 (wr-uid)의 첨부파일(들) 삭제
	// DB삭제, 파일삭제
	public int deleteByWrUid(int wrUid, HttpServletRequest request) throws SQLException {
		int cnt = 0;

		FileDTO[] arr = null;

		try {
			// 1.물리적인 파일 삭제
			pstmt = conn.prepareStatement(D.SQL_FILE_SELECT);
			pstmt.setInt(1, wrUid);
			rs = pstmt.executeQuery();

			arr = createArray(rs);

			// 물리적인 경로
			ServletContext context = request.getServletContext();
			String saveDirectory = context.getRealPath("upload");

			for (FileDTO dto : arr) {
				File f = new File(saveDirectory, dto.getFile());
				System.out.println("삭제시도--->" + f.getAbsolutePath());

				if (f.exists()) {
					if (f.delete()) { // 삭제 !
						System.out.println("삭제성공");
					} else {
						System.out.println("삭제실패");
					}
				} else {
					System.out.println("파일이 존재하지 않습니다.");
				}
			}

			// 2. test_file 테이블 내용 삭제
			pstmt.close();
			rs.close();

			pstmt = conn.prepareStatement(D.SQL_FILE_DELETE_BY_UID);
			pstmt.setInt(1, wrUid);
			cnt = pstmt.executeUpdate();
			System.out.println("첨부파일" + cnt + "개 삭제");

		} finally {
			close();
		}
		return cnt;
	}// end DeleteByWrUid

	// 여러개의 bf_uid의 파일(들) 제거
	public int deleteByUid(int[] uids, HttpServletRequest request) throws SQLException {
		int cnt = 0;
		// 101, 204, 319 번 파일을 지우려면?
		// DELETE FROM test_file WHERE bf_uid
		// request받는 이유는 물리적인 파일 삭제하려고
		if (uids == null || uids.length == 0)
			return 0;

		try {
			// 1.물리적인 파일 삭제
			StringBuffer sql = new StringBuffer("SELECT FROM test_file WHERE bf_uid IN (");
			for (int uid : uids) {
				sql.append(uid + ",");
			}
			sql.deleteCharAt(sql.lastIndexOf(","));// 맨끝 콤마삭제
			sql.append(")");

			stmt = conn.createStatement();
			stmt.executeQuery(sql.toString());
			rs = stmt.executeQuery(sql.toString());

			// 물리적인 경로 획득
			ServletContext context = request.getServletContext();
			String saveDirectory = context.getRealPath("upload");

			while (rs.next()) {
				String fileName = rs.getString("bf_file"); // 삭제할 파일명
				File f = new File(saveDirectory, fileName);

				System.out.println("삭제시도--->" + f.getAbsolutePath());

				if (f.exists()) {
					if (f.delete()) { // 삭제 !
						System.out.println("삭제성공");
					} else {
						System.out.println("삭제실패");
					}
				} else {
					System.out.println("파일이 존재하지 않습니다.");
				}
			}

			// 2. test_file 테이블 삭제
			sql = new StringBuffer("DELETE FROM test_file WHERE bf_uid In (");
			for (int uid : uids) {
				sql.append(uid + ",");
			}
			sql.deleteCharAt(sql.lastIndexOf(","));
			sql.append(")");

			System.out.println("파일삭제 : " + sql);

			cnt = stmt.executeUpdate(sql.toString());

		} finally {
			close();
		}

		return cnt;
	}
	
	
	//특정 글(wr_uid) 에 첨부파일들 추가 
	public int insert(int wrUid,
			List<String> orginalFileNames,
			List<String> fileSystemNames
			) throws SQLException {
		int cnt = 0;
		
		
		//첨부파일 정보 추가(저장)하기
		pstmt = conn.prepareStatement(D.SQL_FILE_INSERT);
		for (int i = 0; i < orginalFileNames.size(); i++) {
			pstmt.setString(1, orginalFileNames.get(i));
			pstmt.setString(2, fileSystemNames.get(i));
			pstmt.setInt(3, wrUid);
			cnt += pstmt.executeUpdate();
		}
		
		
		return cnt;
	}

} // end DAO
