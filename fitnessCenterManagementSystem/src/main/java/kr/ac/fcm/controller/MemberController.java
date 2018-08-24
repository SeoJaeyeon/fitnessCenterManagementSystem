package kr.ac.fcm.controller;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.ac.fcm.DTO.user.Account;
import kr.ac.fcm.DTO.user.MemberDTO;

import kr.ac.fcm.service.FindUserService;
import kr.ac.fcm.service.ReviseMyInfoService;
@Controller
public class MemberController {
	
	private MemberDTO member;
	
	
	Logger logger=LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private FindUserService findUserService;
	
	@Autowired
	private ReviseMyInfoService reviseMemberInfoService;

	
	@GetMapping("/member")
	public String showMemberView(@AuthenticationPrincipal Account account,Model model){
		this.member=findUserService.findMemberById(account.getId());
		this.member.setType(account.getType());
		model.addAttribute("schedule","active");
		model.addAttribute("type",member.getType());
		return "/schedule";
	}
	
	@GetMapping("/member/mypage")
	public String myPageByGet( Model model, HttpServletRequest req){
		model.addAttribute("mypage","active");
		model.addAttribute("member",member);
		if(req.getParameter("pwerror")!=null)
			model.addAttribute("message","패스워드를 다시한번 확인해주세요!!");
		else if(req.getParameter("error")!=null)
			model.addAttribute("message","예기치못한 오류가 발생하였습니다!!");
		else if(req.getParameter("success")!=null)
			model.addAttribute("message","정상적으로 변경되었습니다!!");
		else
			model.addAttribute("message","");
		return "/member/mem_mypage";
	}
	
	@PostMapping("/member/mypage")
	public String myPageByPost(@Valid @ModelAttribute("member") MemberDTO member, BindingResult bindingResult, HttpServletRequest req,Model model){
		if(bindingResult.hasErrors()){
			logger.info(Integer.toString(bindingResult.getErrorCount()));
			logger.info(bindingResult.getAllErrors().get(0).toString());
			return "/member/mem_mypage";
		}
		String result=reviseMemberInfoService.reviseMyInfo(req.getParameter("cur_password"), member);
		model.addAttribute("mypage","active");
		model.addAttribute("member",member);
		return "redirect:/member/mypage?"+result;
	}

}
