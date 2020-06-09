package com.lec.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.D;

//DAO : Data Access Object
// DB 에 접속하여 트랜잭션을 수행하는 객체
public class FileDAO {
	
	   Connection conn = null;
	   Statement stmt = null;
	   PreparedStatement pstmt = null;
	   ResultSet rs = null; //SELECT 결과, excuteQuery()
	
	   public FileDAO() {

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
	   //ResultSet -->DTO 배열로 리턴
	    public FileDTO [] createArray(ResultSet rs) throws SQLException{
	    	
	    	FileDTO [] arr = null;
	    	List<FileDTO> list = new ArrayList<FileDTO>();
	    	
	    	while(rs.next()) {
	    		
	    		int uid = rs.getInt("bf_uid");
	    		String source = rs.getString("bf_source");
	    		String file = rs.getString("bf_file");
	    		
	    		FileDTO dto = new FileDTO(uid,source,file);
	    		list.add(dto);
	    		
	    	}//end while
	    	
	    	arr = new FileDTO[list.size()];
	    	list.toArray(arr);

	    	return arr;
	    	
	    	
	    }//end createArray()
	    
	    
	    
	   
	  
}
