package com.lec.sts16_interceptor.board.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.lec.sts16_interceptor.board.C;

public class BWriteDAO {
	JdbcTemplate template;
	
	public BWriteDAO() {
		this.template = C.template;
	}
	
	// 전체 SELECT
	public List<BWriteDTO> select(){
		
		// 이렇게나 간단해진다!
		return template.query(C.SQL_WRITE_SELECT, 
				new BeanPropertyRowMapper<BWriteDTO>(BWriteDTO.class));
		
	}
	
	
	public int insert(final BWriteDTO dto) {
		
		/* 
		// 1. update() + PreparedStatementSetter() 
		return
		template.update(C.SQL_WRITE_INSERT, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, dto.getSubject());
				ps.setString(2, dto.getContent());
				ps.setString(3, dto.getName());				
			}
		} );
		*/
		
		// 2. update() + PreparedStatementCreator()
		return
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				
				PreparedStatement ps = con.prepareStatement(C.SQL_WRITE_INSERT);
				ps.setString(1, dto.getSubject());
				ps.setString(2, dto.getContent());
				ps.setString(3, dto.getName());
	
				return ps;
			}
		});
		
	} // end insert()
	
	
	public BWriteDTO readByUid(final int uid){
		BWriteDTO dto = null;
		
		// 조회수 증가.
		template.update(C.SQL_WRITE_INC_VIEWCNT, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, uid);
			}
		});
		
		// 읽기
		List<BWriteDTO> list = 
		template.query(C.SQL_WRITE_SELECT_BY_UID, new PreparedStatementSetter() {	
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1,  uid);
			}
		}, new BeanPropertyRowMapper<BWriteDTO>(BWriteDTO.class));
		
		if(list.size() > 0) dto = list.get(0);  // 읽어온 글 (첫번째 아이템)
		
		
		return dto;
	} // end readByUid()
	
	public BWriteDTO selectByUid(final int uid){
		BWriteDTO dto = null;
		
		// 읽기
		List<BWriteDTO> list = 
		template.query(C.SQL_WRITE_SELECT_BY_UID, new PreparedStatementSetter() {	
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1,  uid);
			}
		}, new BeanPropertyRowMapper<BWriteDTO>(BWriteDTO.class));
		
		if(list.size() > 0) dto = list.get(0);  // 읽어온 글 (첫번째 아이템)
		
		
		return dto;
	} // end readByUid()
	
	public int update(final BWriteDTO dto) {
		int cnt = 0;
		
		cnt = 
		template.update(C.SQL_WRITE_UPDATE, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, dto.getSubject());
				ps.setString(2, dto.getContent());
				ps.setInt(3, dto.getUid());
			}
		});
		
		return cnt;
	}
	
	public int deleteByUid(final int uid) {
		int cnt = 0;
		
		cnt = 
		template.update(C.SQL_WRITE_DELETE_BY_UID, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, uid);
				
			}
		});		
		
		return cnt;
	}
	
	
	
	
} // end DAO











