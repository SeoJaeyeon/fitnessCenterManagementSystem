package kr.ac.fcm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
	
	@GetMapping("/member")
	public String showMemberView(){
		return "/member/member";
	}

}
