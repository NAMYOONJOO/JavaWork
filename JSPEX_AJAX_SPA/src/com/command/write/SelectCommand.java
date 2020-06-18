package com.command.write;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;
import com.lec.beans.WriteDTO;
public class SelectCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		WriteDAO dao = new WriteDAO();
		WriteDTO [] arr = null;
		int uid = Integer.parseInt(request.getParameter("uid"));  // 매개변수 검증 필요

		try {
			arr = dao.selectByUid(uid);  // 읽기 only
			request.setAttribute("list", arr);
		} catch (SQLException e) { // 만약 ConnectionPool 을 사용한다면 여기서 NamingException 도 catch 해야 한다  
			e.printStackTrace();
		}
	}

}
