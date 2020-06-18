package com.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.CategoryDAO;
import com.lec.beans.CategoryDTO;

public class CateListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		CategoryDAO dao = new CategoryDAO();
		CategoryDTO[] arr = null;

		if (request.getParameter("parent")!= null && Integer.parseInt(request.getParameter("parent")) != 0&&
				request.getParameter("parent")!="") {
			int depth = Integer.parseInt(request.getParameter("depth"));
			int parent = Integer.parseInt(request.getParameter("parent"));

			try {

				arr = dao.selectFromRow(depth, parent);
			} catch (SQLException e) {
			}
			request.setAttribute("list", arr);
		} else {// parent 값이 0이거나 null일때
			try {
				arr = dao.selectFromRow();
			} catch (SQLException e) {
			}
			request.setAttribute("list", arr);
		}
		/*
		 * if (request.getParameter("parent")!= null &&
		 * Integer.parseInt(request.getParameter("parent")) != 0&&
		 * request.getParameter("parent")!="") { int depth =
		 * Integer.parseInt(request.getParameter("depth")); int parent =
		 * Integer.parseInt(request.getParameter("parent"));
		 * 
		 * try {
		 * 
		 * arr = dao.selectFromRow(depth, parent); } catch (SQLException e) { }
		 * request.setAttribute("list", arr); } else {// parent 값이 0이거나 null일때 try { arr
		 * = dao.selectFromRow(); } catch (SQLException e) { }
		 * request.setAttribute("list", arr); }
		 */
	}

}
