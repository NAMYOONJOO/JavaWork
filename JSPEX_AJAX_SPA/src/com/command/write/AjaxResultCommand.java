package com.command.write;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lec.beans.AjaxWriteResult;

public class AjaxResultCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		AjaxWriteResult result = new AjaxWriteResult();
		
		result.setStatus((String)request.getAttribute("status"));
		result.setMessage((String)request.getAttribute("message"));
		result.setCount((Integer)request.getAttribute("result"));		
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			String jsonString = mapper.writerWithDefaultPrettyPrinter()
								.writeValueAsString(result);
			
			response.setContentType("application/json; charset=utf-8"); 
			response.getWriter().write(jsonString);			
		} catch(JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	} // end execute()

} // end Command












