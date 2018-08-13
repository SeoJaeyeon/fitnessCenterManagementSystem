package kr.ac.fcm.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartFile;

import kr.ac.fcm.mapper.ManagerMapper;

import kr.ac.fcm.service.AddUserService;
import kr.ac.fcm.service.FindUserService;
import kr.ac.fcm.service.s3.S3Wrapper;

import kr.ac.fcm.user.Manager;
import kr.ac.fcm.user.Member;
import kr.ac.fcm.user.Trainer;


@Controller
public class ManagerController {
	Logger logger=LoggerFactory.getLogger(ManagerController.class);
	private Manager manager;

	@Autowired
	private FindUserService findUserService;
	@Autowired
	private S3Wrapper s3Service;
	@Autowired
	private AddUserService addUserService;
	
	@GetMapping("/manager")
	public String manager(@RequestParam("id")String id,HttpServletRequest req, HttpServletResponse res){

		this.manager=findUserService.findManagerById(id);
		return "manager/manager";
	}
	
	@GetMapping("/manager/addUser")
	public String addUserByGet(Model model){
		model.addAttribute("member", new Member());
		return "manager/addUser";
	}
	
	@PostMapping("/manager/addUser")
	public String addUserByPost(@Valid Member member, BindingResult bindingResult,Model model){
		if(bindingResult.hasErrors()){
			logger.info("form error");
			return "/manager/addUser";
		}
		member.setCenter_id(this.manager.getCenter_id());
		try{
			addUserService.addMember(member);
		}catch(Exception ex){
			ex.printStackTrace();
			model.addAttribute("message","사용자 추가 에러!!!");
			return "/manager/addUser";
		}
		
		model.addAttribute("message","정상적으로 등록되었습니다.");
		model.addAttribute("member", new Member());
		return "/manager/addUser";
	}

	@GetMapping("/manager/addTrainer")
	public String addTrainerByGET(Model model){
		model.addAttribute("trainer", new Trainer());
		return "/manager/addTrainer";
	}
	@PostMapping("/manager/addTrainer")
	public String addTrainer(@Valid Trainer trainer,BindingResult bindingResult, Model model,HttpServletRequest req,@RequestParam("file") MultipartFile multipartFile){
		if(bindingResult.hasErrors()){
			logger.info("form error in addTrainer");
			return "/manager/addTrainer";
		}
		
		trainer.setCenter_id(this.manager.getCenter_id());
		try{
			addUserService.addTrainer(trainer);
			s3Service.upload(multipartFile, "trainer",trainer.getId());
		}catch(Exception ex){
			ex.printStackTrace();
			model.addAttribute("message","사용자 추가 에러!!!");
			return "/manager/addTrainer";
		}
		model.addAttribute("message","정상적으로 추가되었습니다!!");
		model.addAttribute("trainer",new Trainer());
		return "/manager/addTrainer";
	}

}
