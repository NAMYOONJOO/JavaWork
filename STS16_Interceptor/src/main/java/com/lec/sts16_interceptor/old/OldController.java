package com.lec.sts16_interceptor.old;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import old.*;

@Controller
@RequestMapping("/old")
public class OldController {
	
	@RequestMapping("/list.do")
	public String list(HttpServletRequest request, HttpServletResponse response) {
		new ListCommand().execute(request, response);
		return "old/list";
	}
	

	@RequestMapping("/write.do")
	public String write(HttpServletRequest request, HttpServletResponse response) {
		return "old/write";
	}
	
	@RequestMapping("/writeOk.do")
	public String writeOk(HttpServletRequest request, HttpServletResponse response) {
		new WriteCommand().execute(request, response);
		return "old/writeOk";
	}
	
	@RequestMapping("/view.do")
	public String view(HttpServletRequest request, HttpServletResponse response) {
		new ViewCommand().execute(request, response);
		return "old/view";
	}
	
	@RequestMapping("/update.do")
	public String update(HttpServletRequest request, HttpServletResponse response) {
		new SelectCommand().execute(request, response);
		return "old/update";
	}
	
	@RequestMapping("/updateOk.do")
	public String updateOk(HttpServletRequest request, HttpServletResponse response) {
		new UpdateCommand().execute(request, response);
		return "old/updateOk";
	}
	
	@RequestMapping("/deleteOk.do")
	public String deleteOk(HttpServletRequest request, HttpServletResponse response) {
		new DeleteCommand().execute(request, response);
		return "old/deleteOk";
	}
	
	
}
















