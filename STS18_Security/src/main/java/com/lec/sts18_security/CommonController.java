package com.lec.sts18_security;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommonController {
	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		System.out.println("access Denied : "+auth);
		model.addAttribute("msg","접근 권한 거부");
		
	}
	
	@GetMapping("/customLogin")
	public void loginInput(String error, String logout, Model model) {
		System.out.println("error : "+ error);
		System.out.println("logout : "+ logout);
		
		if(error != null) {
			model.addAttribute("error", "Login Error Check Your Account");
		}
		if(logout != null) {
			model.addAttribute("logout", "logout!!");
		}
	}
	@GetMapping("/customLogout")
	public void logoutGET() {
		System.out.println("customlogout");
	}
	
	@PostMapping("/customLogout")
	public void logoutPost() {
		System.out.println("post Custom logout");
	}
}
