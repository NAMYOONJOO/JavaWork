package com.lec.sts10_request.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/member")//->/member로 시작하는 request만 처리
public class MemberController {
	
	@RequestMapping(value = "/save")//->/member+/save =>/member/save
	public String saveMember() {
		return"member/save";
	}
	
	@RequestMapping(value = "/load")
	public String loadMember() {
		return "member/load";
	}
	//@RequestMapping(value = "/search")
	//public String searchMember() {
	//	return "member/search";
	//}

}
