package com.lec.sts16_interceptor.board.command;

import java.util.Arrays;
import java.util.Map;

import org.springframework.ui.Model;

import com.lec.sts16_interceptor.board.beans.BWriteDAO;
import com.lec.sts16_interceptor.board.beans.BWriteDTO;

public class BSelectCommand implements BCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		int uid = (Integer)map.get("uid");
		BWriteDAO dao = new BWriteDAO();
		BWriteDTO dto = dao.selectByUid(uid);
		model.addAttribute("list", Arrays.asList(dto));
		

	}

}















