package com.command;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lec.beans.AjaxWriteResult;
import com.lec.beans.CategoryDTO;

public class AjaxListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
			responseJSON(request, response); //Jackson 사용
	}// end execute

	private void responseJSON(HttpServletRequest request, HttpServletResponse response) {
		CategoryDTO [] dtoArr = (CategoryDTO [])request.getAttribute("list");
		//AjaxWriteList list = new AjaxWriteList();//respㅐnse 할 Java 객체
		AjaxWriteResult list = new AjaxWriteResult();//respㅐnse 할 Java 객체
		
		if(dtoArr==null) {
			list.setStatus("FAIL");
		}else {
			list.setStatus("OK");
			list.setCount(dtoArr.length);
			list.setList(Arrays.asList(dtoArr));
		}
		ObjectMapper mapper = new ObjectMapper();//Json으로 매핑할 Mapper 객체
		try {
			//Java객체 --> Json 문자열로 변환
			String jsonString = mapper.writeValueAsString(list);
			response.setContentType("application/json; charset=utf-8");
			response.getWriter().write(jsonString);
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	

} // end Command














