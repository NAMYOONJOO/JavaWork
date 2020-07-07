package com.lec.sts16_interceptor.board.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.sts16_interceptor.board.beans.BWriteDAO;
import com.lec.sts16_interceptor.board.beans.BWriteDTO;

public class BUpdateCommand implements BCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		BWriteDTO dto = (BWriteDTO)map.get("dto");
		BWriteDAO dao = new BWriteDAO();
		int cnt = dao.update(dto);
		model.addAttribute("result", cnt);
	}

}












