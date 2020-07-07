package com.lec.sts14_transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

public class TicketDAO1 {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public TicketDAO1() {
		super();
	}
	
	//티켓 구매
	public void buyTicket(final TicketDTO dto) {
		System.out.println("buyTicket()");
		System.out.println("user id : "+dto.getUserId());
		System.out.println("ticket count : "+dto.getTicketCount());
		
		//카드 결제
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String query = "INSERT INTO test_card VALUES (?,?)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, dto.getUserId());
				pstmt.setInt(2, dto.getTicketCount());
				
				return pstmt;
			}
		});
		//티켓발권
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String query = "INSERT INTO test_ticket VALUES (?,?)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, dto.getUserId());
				pstmt.setInt(2, dto.getTicketCount());
				
				return pstmt;
			}
		});
	}
}
