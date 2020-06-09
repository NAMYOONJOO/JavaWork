package com.command.write;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;
import com.lec.beans.WriteDTO;

public class ViewCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		WriteDAO dao = new WriteDAO();// DAO 객체 설정
		WriteDTO[] arr = null;

		// ajax response 에 필요한 것들
		StringBuffer message = new StringBuffer();
		String status = "FAIL";// 기본 FAIL;

//		int uid = Integer.parseInt(request.getParameter("uid"));
		String param = request.getParameter("uid");
		
		//유효성 검사
		if(param==null) {
			message.append("[유효하지 않은 parameter 0 or null]");
			
		}else {
			
			try {
				int uid = Integer.parseInt(param);
				// 트랜잭션 수행
				arr = dao.readyByUid(uid);
				// "list"란 name 으로 request에 arr 값 전달
				// 즉 request 에 담아서 컨트롤러에 전달되는 셈
				if(arr==null) {
					message.append("[해당 데이터가 없습니다.]");
					
				}else {
					status="Ok";
				}
				
			} catch (SQLException e) {
				// 만약 CP 사용한다면
				// NamingException 도 처리 해야댐
//				e.printStackTrace();
				message.append("[트랜잭션 에러:"+e.getMessage()+"]");
			}catch (Exception e) {
				message.append("[예외발생:"+e.getMessage()+"]");
			}
			
		}

		request.setAttribute("list", arr);
		

		request.setAttribute("status", status);
		request.setAttribute("message", message.toString());

	}

}
