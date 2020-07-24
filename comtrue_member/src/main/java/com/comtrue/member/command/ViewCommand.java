package com.comtrue.member.command;

import java.util.Arrays;
import java.util.Map;

import org.springframework.ui.Model;

import com.comtrue.member.C;
import com.comtrue.member.bean.WriteDAO;


public class ViewCommand implements Command {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		int memberId = (Integer) map.get("memberId");

		// MyBatis 사용
		WriteDAO dao = C.sqlSession.getMapper(WriteDAO.class);
		model.addAttribute("list", Arrays.asList(dao.selectByMid(memberId)));
	}

}
