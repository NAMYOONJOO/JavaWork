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
import java.util.List;

import javax.annotation.Generated;

import common.D;

//DAO : Data Access Object
// DB 에 접속하여 트랜잭션을 수행하는 객체
public class WriteDAO {
	
	   Connection conn = null;
	   Statement stmt = null;
	   PreparedStatement pstmt = null;
	   ResultSet rs = null; //SELECT 결과, excuteQuery()
	
	   public WriteDAO() {

		   try {
			   Class.forName(D.DRIVER);
			   conn=DriverManager.getConnection(D.URL, D.UID, D.UPW);
			   System.out.println("writeDAO생성");
		   }catch (Exception e) {
			// TODO: handle exception
			   e.printStackTrace();
		}
	   }//생성자
	   
	   //DB 자원 반납 메소드
	   public void close() throws SQLException{
		   if(rs!=null) rs.close();
		   if(pstmt !=null) pstmt.close();
		   if(stmt !=null) stmt.close();
		   if(conn !=null) conn.close();
		   
	   }
	   
	   //새글 작성<-- DTO
	   public int insert(WriteDTO dto)throws SQLException{
		   //Overloading
		   
		   String subject = dto.getSubject();
		   String content = dto.getContent();
		   String name = dto.getName();
		   
		   int cnt = this.insert(subject,content, name);
		   return cnt;
	   }
	   
	   //새글 작성 <-- 제목, 내용, 작성자
	  public int insert(String subject, String content, String name) throws SQLException{
		  int cnt = 0;
		  
		  try {
			  pstmt = conn.prepareStatement(D.SQL_WRITE_INSERT);
			  pstmt.setString(1,subject);
			  pstmt.setString(2,content);
			  pstmt.setString(3,name);
			  
			  cnt = pstmt.executeUpdate();
		  }finally {
			close();
		}
		  return cnt;
	  }
	  
	  //새글작성 <--제목, 내용, 작성자
//	  		<--첨부파일(들)
	  public int insert(String subject, String content, String name, 
			  List<String>originalFileNames, //원본파일명(들)
			  List<String>fileSystemNames //저장된 파일명(들)
			  ) throws SQLException{
		  int cnt = 0;
		  
		  int uid = 0;//INSERT 된 글의 wr_uid값
		  
		  try {
			  //자동생성된 컬럼의 이름(들)이 담긴 배열 준비(auto-generated keys)
			  String[] gerneratedCols = {"wr_uid"};
			  
			  //Statement 나 PreparedStatement 생성시 두번째 매개변수로 auto-generated keys 배열 넘겨줌
			  
			  
			  pstmt = conn.prepareStatement(D.SQL_WRITE_INSERT,gerneratedCols);
			  pstmt.setString(1,subject);
			  pstmt.setString(2,content);
			  pstmt.setString(3,name);
			  
			  cnt = pstmt.executeUpdate();
			  
			  // auto-generatedkeys 값 뽑아오기
			  rs = pstmt.getGeneratedKeys();
			  if(rs.next()) {
				 uid =  rs.getInt(1); //첫번째 컬럼
			  }
			  
			  pstmt.close();
			  
			  //첨부파일(들)  정보 테이블에 INSERT 하기
			  pstmt=conn.prepareStatement(D.SQL_FILE_INSERT);
			  
			   for(int i = 0;i<originalFileNames.size();i++)
			   {
				   pstmt.setString(1, originalFileNames.get(i));
				   pstmt.setString(2, fileSystemNames.get(i));
				   pstmt.setInt(3,uid);
				   pstmt.executeUpdate();
			   }
			  
		  }finally {
			close();
		}
		  return cnt;
	  }
	  
	  
	   
	  // ResultSet-->DTO 배열로 리턴
	  public WriteDTO [] createArray(ResultSet rs) throws SQLException{
		  WriteDTO[] arr = null; //DTO 배열

		  ArrayList<WriteDTO> list = new ArrayList<WriteDTO>();
		  
		  while(rs.next()) {
			  
				
				int uid = rs.getInt("wr_uid");
				String subject= rs.getString("wr_subject");
				String name= rs.getString("wr_name");
				String content = rs.getString("wr_content");
				int viewCnt = rs.getInt("wr_viewcnt");
				Date d = rs.getDate("wr_regdate");
				Time t = rs.getTime("wr_regdate");
				//java.sql로 import **//(애매)
				
				
				String regDate = "";
				if(d != null){
					regDate = new SimpleDateFormat("yyyy-MM-dd").format(d)+""
							+ new SimpleDateFormat("hh:mm:ss").format(t);
				}
				
				WriteDTO dto = new WriteDTO(uid,subject,content,name,viewCnt);
				dto.setRegDate(regDate);
				
				list.add(dto);
		  }
				int size = list.size();
				if(size==0)return null;
				
				arr = new WriteDTO[size];
				list.toArray(arr); //List -> 배열
				return arr;
				
		
	  }
	  //전체 SELECT
	  public WriteDTO [] select() throws SQLException{
		  WriteDTO [] arr = null;
		  
		  try {
			  pstmt = conn.prepareStatement(D.SQL_WRITE_SELECT);
			  rs = pstmt.executeQuery();
			  arr = createArray(rs);
		  }finally {
			close();
		}
		  
		  return arr;
	  }
	   
	  //특정 uid 의 글 내용 읽기 , 조회수 증가 
	  // viewCnt 도 1 증가 해야하고, 읽어와야한다. -->트랜잭션 처리
	  public WriteDTO[] readyByUid(int uid) throws SQLException{
		  int cnt = 0;
		  WriteDTO [] arr = null;
		  
		  try {
			  //트랜잭션 처리
			  //Auto-commit 비활성화
			  conn.setAutoCommit(false);
			  //쿼리들수행
			  pstmt = conn.prepareStatement(D.SQL_WRITE_INC_VIEWCNT);
			  pstmt.setInt(1,uid);
			  cnt = pstmt.executeUpdate();
			  
			  pstmt.close();
			  
			  pstmt = conn.prepareStatement(D.SQL_WRITE_SELECT_BY_UID);
			  pstmt.setInt(1,uid);
			  rs = pstmt.executeQuery();
			  
			  arr = createArray(rs);
			  conn.commit();
		  }catch (SQLException e) {
			  conn.rollback();
			  throw e;
			  
		  }finally {
			  close();
		  }
		  
		  
		  return arr;
	  }
	  //특정 uid의 글만 SELECT
	  public WriteDTO[] selectByUid(int uid) throws SQLException{
		  WriteDTO[] arr = null;
		  try {
			  pstmt = conn.prepareStatement(D.SQL_WRITE_SELECT_BY_UID);
			  pstmt.setInt(1,uid);
			  rs = pstmt.executeQuery();
			arr = createArray(rs);
			
		  }finally {
			  close();
		  }
		  return arr;
		  
	  }
	  
	  //특정 uid
	  public int update(int uid,String subject, String content)throws SQLException{
		  int cnt = 0;
		  
		  try {
			  pstmt = conn.prepareStatement(D.SQL_WRITE_UPDATE);
			  pstmt.setString(1,subject);
			  pstmt.setString(2,content);
			  pstmt.setInt(3,uid);
			  
			  cnt = pstmt.executeUpdate();
		  }finally {
			  close();
		  }
		  
		  return cnt;
	  }
	  
	//특정 uid 글 삭제하기
		public int deleteByUid(int uid) throws SQLException{
			int cnt = 0;
			
			try {
				pstmt = conn.prepareStatement(D.SQL_WRITE_DELETE_BY_UID);
				pstmt.setInt(1, uid);
				cnt = pstmt.executeUpdate();
			}finally {
				close();
			}
			
			return cnt;
		}

}
