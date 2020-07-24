package com.comtrue.member.command;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.ui.Model;

import com.comtrue.member.C;
import com.comtrue.member.bean.WriteDAO;
import com.comtrue.member.bean.WriteDTO;

import oracle.net.aso.d;

public class WriteCommand implements Command {

	@Override
	public void execute(Model model) {

		Map<String, Object> map = model.asMap();
		WriteDTO dto = (WriteDTO) map.get("dto");

		String email = dto.getEmail();
		String phoneNum = dto.getPhoneNum();

		Pattern emailP = Pattern.compile("^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$");
		Pattern phoneP = Pattern.compile("^01(?:0|1[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$");
		Matcher e = emailP.matcher(email);
		Matcher p = phoneP.matcher(phoneNum);

		WriteDAO dao = C.sqlSession.getMapper(WriteDAO.class);
		dao.selectByMid(dto.getMemberId());
		
		if (e.matches() && p.matches()) {
			model.addAttribute("result", dao.insert(dto));
		}else {
		
			model.addAttribute("result", -1);
		}

	}

}
