package com.comtrue.member.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.comtrue.member.C;
import com.comtrue.member.bean.WriteDAO;
import com.comtrue.member.bean.WriteDTO;

public class UpdateCommand implements Command {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		WriteDTO dto = (WriteDTO) map.get("dto");

		WriteDAO dao = C.sqlSession.getMapper(WriteDAO.class);
		model.addAttribute("result",dao.update(dto));
	//	model.addAttribute("result",dao.update(dto.getMemberId(),dto.getName(),
		//		dto.getPosition(),dto.getPhoneNum(),dto.getEmail()));

	}

}
