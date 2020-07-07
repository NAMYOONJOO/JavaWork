package com.lec.sts14_transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class TicketDAO3 {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	// TransactionTemplate 사용
	TransactionTemplate transactionTemplate;
	
	public void setTransactionTemplate(TransactionTemplate transationTemplate) {
		this.transactionTemplate = transationTemplate;
	}

	public TicketDAO3() {
		System.out.println(template);
	}
	
	// 티켓 구매
	public void buyTicket(final TicketDTO dto) {
		System.out.println("buyTicket()");
		System.out.println("user id : " + dto.getUserId());
		System.out.println("ticket count : " + dto.getTicketCount());
		
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				// 이 안의 작업들은 하나의 트랜잭션으로 동작한다.
				// 카드결제
				template.update(new PreparedStatementCreator() {
					
					@Override
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
						String query = "INSERT INTO test_card VALUES (?, ?)";
						PreparedStatement pstmt = con.prepareStatement(query);
						pstmt.setString(1, dto.getUserId());
						pstmt.setInt(2, dto.getTicketCount());
						return pstmt;
					}
				});
				
				// 티켓 발권
				template.update(new PreparedStatementCreator() {
					
					@Override
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
						String query = "INSERT INTO test_ticket VALUES (?, ?)";
						PreparedStatement pstmt = con.prepareStatement(query);
						pstmt.setString(1, dto.getUserId());
						pstmt.setInt(2, dto.getTicketCount());
						return pstmt;
					}
				});
		
				
			}
		});
		
		
		
		
	}
	
	
	
	
}















