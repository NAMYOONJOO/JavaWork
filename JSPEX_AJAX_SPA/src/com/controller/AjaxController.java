package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.write.*;

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
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ajaxAction(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ajaxAction(request, response);
	}
	
	protected void ajaxAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("ajaxAction() 호출");
			
			request.setCharacterEncoding("utf-8");
			
			//컨트롤러는 다음 두개를 선택해야 한다. 
			Command command = null; //어떠한 커맨드-->어떠한 로직 수행
			//url에 담겨온다. 이름에서 찢어내야한다. 
			
			//url 로 부터 URI,ContextPath, Command 분리
			String uri = request.getRequestURI();
			String conPath = request.getContextPath();
			String com = uri.substring(conPath.length());
			
			//테스트 출력
			System.out.println("uri : "+uri);
			System.out.println("conPath : "+conPath);
			System.out.println("com : "+com);
			
			switch (com) {
			case "/list.ajax": //글목록(페이징)
				new ListCommand().excute(request, response);
				new AjaxListCommand().excute(request, response);
				break;
			case "/view.ajax": // 글읽기
				new ViewCommand().excute(request, response);
				new AjaxListCommand().excute(request, response);
				break;
			case "/writeOk.ajax"://글작성
				new WriteCommand().excute(request, response);
				new AjaxResultCommand().excute(request, response);
				
				break;
			case "/updateOk.ajax"://수정
				new UpdateCommand().excute(request, response);
				new AjaxResultCommand().excute(request, response);

				break;
			case "/deleteOk.ajax"://글삭제
				new DeleteCommand().excute(request, response);
				new AjaxResultCommand().excute(request, response);
				
				break;

			default:
				break;
			}//end Switch
	}

}
