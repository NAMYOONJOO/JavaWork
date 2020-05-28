package com.command.write;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;
import com.lec.beans.WriteDTO;

public class DeleteCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		int cnt = 0;
		WriteDAO dao = new WriteDAO();
		
		int uid = Integer.parseInt(request.getParameter("uid"));
		try {
				cnt = dao.deleteByUid(uid);
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
		  
		  request.setAttribute("delete", cnt);
	}

}
