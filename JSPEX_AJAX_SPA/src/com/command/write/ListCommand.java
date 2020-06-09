package com.command.write;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;
import com.lec.beans.WriteDTO;

public class ListCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		WriteDAO dao = new WriteDAO();// DAO 객체 생성
		//아까 DAO 와 다른점 : 생성된 위치가 다르다
		WriteDTO [] arr = null;
		
		//ajax response 에 필요한 것들
		StringBuffer message = new StringBuffer();
		String status = "FAIL";//기본 FAIL;
		
		
		//페이징 관련 세팅값들
		int page = 1; //현재페이지 (디폴트는 1page)
		int pageRows = 8;//한 '페이지'에 몇개의 글을 리스트?(디폴트8 개)
		int writePages = 10;//한 '페이지'에 몇개의 '페이지'룰 표시?(디폴트 10개)
		int totalCnt = 0; //글은 총 몇개임지?
		int totalPage = 0; //총 몇'페이지' 분량인지?
		
		String param;
		// page값 : 현재 몇페이지?
		param = request.getParameter("page");
		if(param!=null && param.trim().length()!=0) {
			try {
				page = Integer.parseInt(param);
				
			}
			catch(NumberFormatException e) {
				//별도의 예외처리 안함
			}
		}
		//pageRows값 :'한 페이지'에 몇개의 글?
		
		param = request.getParameter("pageRows");
		if(param!=null && param.trim().length()!=0) {
			try {
				pageRows = Integer.parseInt(param);
			}
			catch(NumberFormatException e) {
				//별도의 예외처리 안함
			}
		}
		
		
		try {
			//글 전체 개수 구하기
			totalCnt = dao.countAll();
			//총 몇페이지 분량인가?
			totalPage = (int)Math.ceil(totalCnt/(double)pageRows);
			//몇번째 row 부터?
			int fromRow = (page-1)*pageRows+1;//Oracle은 1부터 rownum 시작
			
			//두번쓸때  새로 생성해야함
			dao = new WriteDAO();
			arr = dao.selectFromRow(fromRow, pageRows);
			
			if(arr==null) {
				message.append("[리스트할 데이터가 없습니다.]");
				
			}else {
				status="OK";
			}
		}catch (SQLException e) {
			message.append("[트랜잭션에러:"+e.getMessage()+"]");
		}
		
		request.setAttribute("status", status);
		request.setAttribute("message", message.toString());
		request.setAttribute("list", arr);

		request.setAttribute("page", page);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("writePage", writePages);
		request.setAttribute("pageRow", pageRows);
		request.setAttribute("totalCnt", totalCnt);
		
	}

}
