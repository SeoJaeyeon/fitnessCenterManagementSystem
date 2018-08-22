package kr.ac.fcm.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.fcm.DTO.user.Account;
import kr.ac.fcm.DTO.user.CenterDTO;
import kr.ac.fcm.DTO.user.ManagerDTO;
import kr.ac.fcm.mapper.CenterMapper;
import kr.ac.fcm.mapper.ManagerMapper;
import kr.ac.fcm.service.AccountService;
import kr.ac.fcm.service.AddUserService;
import kr.ac.fcm.service.s3.S3ServiceImpl;


@Controller
public class AdminController {
	
	@Autowired
	AccountService accountService;

	
	@Autowired
	private AddUserService addUserService;
	
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public String adminPage(Model model,HttpServletRequest req){
		
		return "admin/admin";
	}
	//관리자 추가 
	@RequestMapping(value="/admin", method=RequestMethod.POST) 
	public String addManager(CenterDTO center,ManagerDTO manager,HttpServletRequest req,Model model){

	
		try{
			addUserService.addManager(manager, center);
		
		}catch(Exception ex){ 
			ex.printStackTrace();
			model.addAttribute("message","관리자 추가 에러!!");
			return "admin/admin";
		}
	
		model.addAttribute("message","정상적으로 추가되었습니다");
		return "admin/admin";
		
	}
	
	//ADMIN 계정 부여
		@GetMapping("/create")
		public Account create(){
			Account account=new Account();
			account.setId("admin");
			account.setPassword("1234");
			accountService.save(account, "ROLE_ADMIN", "ADMIN");
			return account;
		}


	
}
