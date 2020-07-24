package com.comtrue.member.command;

import org.springframework.ui.Model;

import com.comtrue.member.C;
import com.comtrue.member.bean.WriteDAO;


public class ListCommand implements Command {

	@Override
	public void execute(Model model) {

		WriteDAO dao = C.sqlSession.getMapper(WriteDAO.class);
		model.addAttribute("list", dao.select());
	}

}
