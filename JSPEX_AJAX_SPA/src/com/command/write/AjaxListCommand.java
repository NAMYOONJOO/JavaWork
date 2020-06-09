package com.command.write;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lec.beans.AjaxWriteList;
import com.lec.beans.WriteDTO;

public class AjaxListCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
			WriteDTO[] dtoArr = (WriteDTO[])request.getAttribute("list");
			
			AjaxWriteList result = new AjaxWriteList();
			
			result.setStatus((String)request.getAttribute("status"));
			result.setMessage((String)request.getAttribute("message"));
			
			if(dtoArr!=null) {
				result.setCount(dtoArr.length);
				result.setList(Arrays.asList(dtoArr));
			}
			try {
			//페이징 할 때 필요한 것들
			result.setPage((Integer)request.getAttribute("page"));
			result.setTotalPage((Integer)request.getAttribute("totalPage"));
			result.setWritePages((Integer)request.getAttribute("writePages"));
			result.setPageRows((Integer)request.getAttribute("pageRows"));
			result.setTotalCnt((Integer)request.getAttribute("totalCnt"));
			}catch (Exception e) {
				// 무시  
			}
			
			ObjectMapper mapper = new ObjectMapper();//Json 매핑할 객체
			
			try {
				String jsonString = 
						mapper.writerWithDefaultPrettyPrinter()
						.writeValueAsString(result);
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

}
