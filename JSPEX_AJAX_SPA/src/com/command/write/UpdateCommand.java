package com.command.write;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;

public class UpdateCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int cnt = 0;

		WriteDAO dao = new WriteDAO();
		
		// ajax response 에 필요한 값들
		StringBuffer message = new StringBuffer();
		String status = "FAIL";   // 기본 FAIL

		//입력한 값을 받아오기
		String param = request.getParameter("uid");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");

		// 유효성 체크
		if(param == null) {
			message.append("[유효하지 않은 parameter 0 or null]");
		} else if (subject == null || subject.trim().length() == 0) {
			message.append("[유효하지 않은 parameter : 글제목 필수]");
		} else {
			try {		
				int uid = Integer.parseInt(param);
				
				cnt = dao.update(uid, subject, content);
				status = "OK";
				
				if(cnt == 0) {
					message.append("[0 update]");
				}				
				
			} catch (SQLException e) {
				//e.printStackTrace();
				message.append("[트랜잭션 에러:" + e.getMessage() + "]");
			} catch (Exception e) {
				message.append("[유효하지 않은 parameter] " + param);
			}

		} // end if

		request.setAttribute("result", cnt);
		request.setAttribute("status", status);
		request.setAttribute("message", message.toString());

	}

}










