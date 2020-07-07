package com.lec.sts13_jdbc.board.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.sts13_jdbc.board.beans.BWriteDAO;
import com.lec.sts13_jdbc.board.beans.BWriteDTO;

public class BUpdateCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String ,Object> map = model.asMap();
		BWriteDTO dto = (BWriteDTO)map.get("dto");
		BWriteDAO dao = new BWriteDAO();
		int result = dao.update(dto);
		
		model.addAttribute("update",result);
	}

}
