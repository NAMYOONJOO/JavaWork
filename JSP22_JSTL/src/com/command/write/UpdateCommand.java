package com.command.write;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;

public class UpdateCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		int cnt = 0;
		WriteDAO dao = new WriteDAO();
		
		  int uid = Integer.parseInt(request.getParameter("uid"));
		  String subject = request.getParameter("subject");
		  String content = request.getParameter("content");
		  
		  try {
				cnt = dao.update(uid,subject,content);
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
		  
		  request.setAttribute("update", cnt);
		
	}

}
