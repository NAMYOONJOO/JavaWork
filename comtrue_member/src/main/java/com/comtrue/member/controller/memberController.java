package com.comtrue.member.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.comtrue.member.C;
import com.comtrue.member.bean.WriteDTO;
import com.comtrue.member.command.Command;
import com.comtrue.member.command.DeleteCommand;
import com.comtrue.member.command.ListCommand;
import com.comtrue.member.command.UpdateCommand;
import com.comtrue.member.command.ViewCommand;
import com.comtrue.member.command.WriteCommand;


@Controller
public class memberController {
	
	private Command command;
	// MyBabatis
	private SqlSession sqlSession;

	public memberController() {
		super();
	}

	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		C.sqlSession = sqlSession;
	}
	
	
	@RequestMapping("/list.y")
	public String list(Model model) {
		command = new ListCommand();
		command.execute(model);
		return "list";
	}
	@RequestMapping("/write.y")
	public String write() {
		return "write";
	}
	
	@RequestMapping(value = "/writeOk.y", method = RequestMethod.POST)
	public String writeOk(WriteDTO dto, Model model) {
		model.addAttribute("dto", dto);
		new WriteCommand().execute(model);
		return "writeOk";
	}
	@RequestMapping(value = "/update.y", method = RequestMethod.GET)
	public String view(int memberId, Model model) {
		model.addAttribute("memberId", memberId);
		new ViewCommand().execute(model);
		return "update";
	}
	
	@RequestMapping(value = "/updateOk.y",method = RequestMethod.POST)
	public String updateOk(WriteDTO dto, Model model) {
		model.addAttribute("dto", dto);
		new UpdateCommand().execute(model);
		return "updateOk";
	}
	
	@RequestMapping("/deleteOk.y")
	public String deleteOk(int memberId, Model model) {
		model.addAttribute("memberId", memberId);
		new DeleteCommand().execute(model);
		return "deleteOk";
	}
}
