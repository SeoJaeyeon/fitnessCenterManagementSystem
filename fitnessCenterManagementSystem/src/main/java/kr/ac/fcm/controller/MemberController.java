package kr.ac.fcm.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.ac.fcm.DTO.ArticleDTO;
import kr.ac.fcm.DTO.user.Account;
import kr.ac.fcm.DTO.user.MemberDTO;
import kr.ac.fcm.service.BoardService;
import kr.ac.fcm.service.FindUserService;

@Controller
public class MemberController {
	
	private MemberDTO member;
	
	
	Logger logger=LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private FindUserService findUserService;

	
	@GetMapping("/member")
	public String showMemberView(@AuthenticationPrincipal Account account,Model model){
		this.member=findUserService.findMemberById(account.getId());
		this.member.setType(account.getType());
		model.addAttribute("schedule","active");
		return "/member/member";
	}

}
