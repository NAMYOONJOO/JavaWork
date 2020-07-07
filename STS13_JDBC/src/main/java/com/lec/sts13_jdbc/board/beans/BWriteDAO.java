package com.lec.sts13_jdbc.board.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.lec.sts13_jdbc.board.C;

public class BWriteDAO {
	JdbcTemplate template;

	public BWriteDAO() {
		this.template = C.template;
	}

	// 전체 select

	public List<BWriteDTO> select() {
		return template.query(C.SQL_WRITE_SELECT, new BeanPropertyRowMapper<BWriteDTO>(BWriteDTO.class));

	}

	public int insert(BWriteDTO dto) {
		/*
		 * //1. update()+PreparedStatementSetter
		 * 
		 * return template.update(C.SQL_WRITE_INSERT,new PreparedStatementSetter() {
		 * 
		 * @Override public void setValues(PreparedStatement ps) throws SQLException {
		 * ps.setString(1, dto.getSubject()); ps.setString(2, dto.getContent());
		 * ps.setString(3, dto.getName()); } });
		 */

		// 2. update()+PreparedStatementCreator()
		return template.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(C.SQL_WRITE_INSERT);
				ps.setString(1, dto.getSubject());
				ps.setString(2, dto.getContent());
				ps.setString(3, dto.getName());
				return ps;
			}
		});
	}

	public List<BWriteDTO> readByUid(int uid) {
		int result = template.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(C.SQL_WRITE_INC_VIEWCNT);
				ps.setInt(1, uid);
				return ps;
			}
		});
		if (result >= 1) {

			return template.query(C.SQL_WRITE_SELECT_BY_UID, new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setInt(1, uid);

				}
			}, new BeanPropertyRowMapper<BWriteDTO>(BWriteDTO.class));
		} else {
			return null;
		}
	}

	public List<BWriteDTO> selectByUid(int uid) {
		return template.query(C.SQL_WRITE_SELECT_BY_UID, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, uid);

			}
		}, new BeanPropertyRowMapper<BWriteDTO>(BWriteDTO.class));

	}

	public int update(BWriteDTO dto) {

		return template.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(C.SQL_WRITE_UPDATE);
				ps.setString(1, dto.getSubject());
				ps.setString(2, dto.getContent());
				ps.setInt(3, dto.getUid());
				return ps;
			}
		});
	}

	public int deleteByUid(int uid) {

		return template.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(C.SQL_WRITE_DELETE_BY_UID);
				ps.setInt(1, uid);
				return ps;
			}
		});
	}
}
