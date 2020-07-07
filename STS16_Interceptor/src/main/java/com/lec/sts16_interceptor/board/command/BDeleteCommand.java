package com.lec.sts16_interceptor.board.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.sts16_interceptor.board.beans.BWriteDAO;

public class BDeleteCommand implements BCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		int uid = (Integer)map.get("uid");
		BWriteDAO dao = new BWriteDAO();
		
		int cnt = dao.deleteByUid(uid);
		model.addAttribute("result", cnt);		
		
	}

}














