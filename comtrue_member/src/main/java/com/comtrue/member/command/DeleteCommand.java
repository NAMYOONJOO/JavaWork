package com.comtrue.member.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.comtrue.member.C;
import com.comtrue.member.bean.WriteDAO;

public class DeleteCommand implements Command {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		int memberId = (Integer)map.get("memberId");

		WriteDAO dao = C.sqlSession.getMapper(WriteDAO.class);
		model.addAttribute("result", dao.deleteByMid(memberId));
	}

}














