package kr.ac.fcm.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.fcm.service.EmailServiceImpl;
import kr.ac.fcm.user.AccountRepository;

import java.io.IOException;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class MainController {
	
	@Autowired
	JavaMailSender javaMailSender;
	
	@Autowired
	AccountRepository accounts;


	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(HttpServletRequest req, Model model){
		model.addAttribute("message","default");
		return "service";
	}
	

	
	@RequestMapping(value="/mail", method=RequestMethod.POST)
	public String mail(HttpServletRequest req,HttpServletResponse res, Model model) throws IOException{
	

		EmailServiceImpl es=new EmailServiceImpl();
		
		es.setJavaMailSender(javaMailSender);
		
		boolean result=es.sendSimpleMessage("a1010100z@naver.com","헬스예약관리서비스 상담요청" , req.getParameter("email").toString());
		
		if(result){
			//메일 발송 성공 
			model.addAttribute("message","메일 전송 완료");
		}else{
			model.addAttribute("message","메일 전송 실패");
		}
		
		return "service";
	}
	
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginByGet(Model model,HttpServletRequest req, HttpServletResponse res){
		model.addAttribute("message","default");
		model.addAttribute("saved_id","");
		model.addAttribute("chk","");
		for(Cookie cookie: req.getCookies()){
			if(cookie.getName().equals("saved_username")){
				if(!cookie.getValue().toString().equals("")){
					model.addAttribute("saved_id",cookie.getValue().toString());
					model.addAttribute("chk","checked");
				}
			}
		}
		if(req.getParameter("error")!=null){
			//error
			model.addAttribute("message","아이디 또는 비밀번호를 확인해주세요!");
		}
		return "loginPage";
	}


	@GetMapping("/test")
	public String test(){
		return "testView";
	}
	

}