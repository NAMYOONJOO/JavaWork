package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.write.*;

@WebServlet("*.do")
public class WriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WriteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo() 호출");
		
		request.setCharacterEncoding("UTF-8");
		
		// 컨트롤러는 다음 두개를 선택해야 한다.
		String viewPage = null;   // 어떠한 뷰? --> 페이지
		Command command = null;   // 어떠한 커맨드? --> 어떠한 로직 수행.
		
		// URL로부터 URI, ContextPath, Command 분리 
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		// 테스트 출력
		System.out.println("uri: " + uri);
		System.out.println("conPath: " + conPath);
		System.out.println("com: " + com);
		
		// 컨트롤러는 커맨드에 따라, 로직을 수행하고
		// 결과를 내보낼 view 를 결정한다
		switch(com) {
		case "/list.do":
			command = new ListCommand();
			command.execute(request, response);
			viewPage = "list.jsp";
			break;
		case "/write.do":
			viewPage = "write.jsp";
			break;
			
		case "/writeOk.do":
			command = new WriteCommand();
			command.execute(request, response);
			viewPage = "writeOk.jsp";
			break;		
			
		case "/view.do":
			command = new ViewCommand();
			command.execute(request, response);
			viewPage = "view.jsp";

			break;			
		case "/update.do":
			command = new SelectCommand();  // '수정' 이지만, 일단 읽어오는것부터 시작이다.
			command.execute(request, response);
			viewPage = "update.jsp";
			break;

		case "/updateOk.do":
			command = new UpdateCommand();
			command.execute(request, response);
			viewPage = "updateOk.jsp";
			break;  // 디버깅 훈련, 이 break를 없애고, 찾아보기

		case "/deleteOk.do":
			command = new DeleteCommand();
			command.execute(request, response);
			viewPage = "deleteOk.jsp";
			break;	
		} // end switch
		
		// request 를 위에서 결정된 view 에 forward 해줌.
		if(viewPage != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
		
		
	} // end actionDo()

}





























