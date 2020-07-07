package com.lec.sts13_jdbc.board.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.sts13_jdbc.board.beans.BWriteDAO;

public class BDeleteCommand implements BCommand {

	@Override
	public void execute(Model model) {
		BWriteDAO dao = new BWriteDAO();
		Map<String ,Object> map = model.asMap();
		int uid = (int)map.get("uid");
		int result = dao.deleteByUid(uid);
		model.addAttribute("delete",result);


	}

}
