package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.AjaxListCommand;
import com.command.CateListCommand;
import com.command.Command;

/**
 * Servlet implementation class AjaxController
 */
@WebServlet("*.ajax")
public class AjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//cate_list.ajax : 목록요청
		System.out.println("ajaxAction()");

		request.setCharacterEncoding("utf-8");

		// 컨트롤러는 다음 두개를 선택해야 한다.
		Command command = null; // 어떠한 커맨드-->어떠한 로직 수행
		// url에 담겨온다. 이름에서 찢어내야한다.

		// url 로 부터 URI,ContextPath, Command 분리
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());

		// 테스트 출력
		System.out.println("uri : " + uri);
		System.out.println("conPath : " + conPath);
		System.out.println("com : " + com);

		// 컨트롤러는 커맨드에 따라, 로직을 수행하고
		// 결과를 내보낼 view를 결정한다.
		switch (com) {
		case "/list.ajax":  //글 목록 AJAX 요청
			//글 목록 읽기
			new CateListCommand().execute(request,response);
			//읽어온 데이터를 다음 커맨드에 넘겨줌. (request에 담겨있다. )
			new AjaxListCommand().execute(request, response);
			break;
		}// end switch
	}

}
