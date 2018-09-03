package kr.ac.fcm.controller;


import java.util.List;

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
import org.springframework.web.servlet.ModelAndView;

import kr.ac.fcm.DTO.ScheduleDTO;
import kr.ac.fcm.DTO.user.Account;
import kr.ac.fcm.DTO.user.MemberDTO;
import kr.ac.fcm.service.AccountService;
import kr.ac.fcm.service.FindUserService;
import kr.ac.fcm.service.ReviseMyInfoService;
import kr.ac.fcm.service.ScheduleService;
@Controller
public class MemberController {
	
	
	Logger logger=LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private ReviseMyInfoService reviseMemberInfoService;

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private FindUserService findUserService;
	
	@Autowired
	private ScheduleService scheduleService;
	
	@GetMapping("/member")
	public ModelAndView showMemberView(@AuthenticationPrincipal Account account,ModelAndView model){
		ModelAndView mv=new ModelAndView("/schedule");
		
		MemberDTO member=findUserService.findMemberById(account.getId());
		mv.addObject("schedule","active");
		mv.addObject("type",member.getType());
		List<ScheduleDTO> schedules=scheduleService.findThisWeekScheduleByMemberId(account.getId());
		mv.addObject("schedules",schedules);
		return mv;
	}
	
	@GetMapping("/member/mypage")
	public String myPageByGet(@AuthenticationPrincipal Account account, Model model, HttpServletRequest req){
		model.addAttribute("mypage","active");
		model.addAttribute("member",findUserService.findMemberById(account.getId()));
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
		// confirm password 
		if(!accountService.matchPassword(member.getId(),req.getParameter("cur_password"))){
			return "redirect:/member/mypage?pwerror";
		}
		try{
			accountService.updatePassword(member.getId(),member.getPassword());
			reviseMemberInfoService.reviseMyInfo(member);
		}catch(Exception e){
			return "redirect:/member/mypage?error";
		}
		model.addAttribute("mypage","active");
		model.addAttribute("member",member);
		return "redirect:/member/mypage?success";
	}

}
