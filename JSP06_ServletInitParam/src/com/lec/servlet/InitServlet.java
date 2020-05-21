package com.lec.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitServlet
 */
@WebServlet(urlPatterns= {"/InitS"},
initParams = {
		@WebInitParam(name="id",value = "test11"),
		@WebInitParam(name="pw",value = "1000"),
		@WebInitParam(name="local",value = "Pusan")
})
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//ServletConfig 의 메소드를 사용
		String id = getInitParameter("id");
		String pw = getInitParameter("pw");
		String local = getInitParameter("local");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
      out.println("id : "+id+"<br>");
      out.println("pw : "+pw+"<br>");
      out.println("local : "+local+"<br>");
		
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
