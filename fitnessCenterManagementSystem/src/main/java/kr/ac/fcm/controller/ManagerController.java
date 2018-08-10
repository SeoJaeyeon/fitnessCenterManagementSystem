package kr.ac.fcm.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.fcm.mapper.ManagerMapper;
import kr.ac.fcm.mapper.MemberMapper;
import kr.ac.fcm.mapper.TrainerMapper;
import kr.ac.fcm.service.AccountService;
import kr.ac.fcm.service.s3.S3Wrapper;
import kr.ac.fcm.user.Account;
import kr.ac.fcm.user.Manager;
import kr.ac.fcm.user.Member;
import kr.ac.fcm.user.Trainer;


@Controller
public class ManagerController {
	Logger logger=LoggerFactory.getLogger(ManagerController.class);
	private Manager manager;
	@Autowired
	private AccountService accountService;
	@Autowired
	private ManagerMapper managerMapper;	
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private TrainerMapper trainerMapper;
	@Autowired
	private S3Wrapper s3Service;
	
	@GetMapping("/manager")
	public String manager(@RequestParam("id")String id,HttpServletRequest req, HttpServletResponse res){

		System.out.println(id);
		this.manager=managerMapper.findManagerByManagerId(id);
		System.out.println(manager.getCenter_id()+"/////");

		return "manager/manager";
	}
	
	@GetMapping("/manager/addUser")
	public String addUserByGet(Model model){
		model.addAttribute("member", new Member());
		return "manager/addUser";
	}
	
	@PostMapping("/manager/addUser")
	public String addUserByPose(@Valid Member member, BindingResult bindingResult,Model model){
		if(bindingResult.hasErrors()){
			logger.info("form error");
			return "/manager/addUser";
		}
		Account account=new Account();
		account.setId(member.getId());
		account.setPassword(member.getPassword());
		member.setCenter_id(this.manager.getCenter_id());
		try{
			accountService.save(account, "ROLE_MEMBER", "MEMBER");
			memberMapper.insertMember(member);
		}catch(Exception ex){
			ex.printStackTrace();
			model.addAttribute("message","사용자 추가 에러!!!");
			return "/manager/addUser";
		}
		
		model.addAttribute("message","정상적으로 등록되었습니다.");
		return "/manager/addUser";
	}

	@GetMapping("/manager/addTrainer")
	public String addTrainerByGET(){
		return "/manager/addTrainer";
	}
	@PostMapping("/manager/addTrainer")
	public String addTrainer(Trainer trainer,Model model,HttpServletRequest req,@RequestParam("file") MultipartFile multipartFile){
		Account account=new Account();
		account.setId(trainer.getId());
		account.setPassword(trainer.getPassword());
		trainer.setCenter_id(this.manager.getCenter_id());
		try{
			accountService.save(account, "ROLE_TRAINER", "TRAINER");
			trainerMapper.insertTrainer(trainer);
			s3Service.upload(multipartFile, "traienr");
		}catch(Exception ex){
			ex.printStackTrace();
			model.addAttribute("message","사용자 추가 에러!!!");
			return "/manager/addTrainer";
		}
		model.addAttribute("message","정상적으로 추가되었습니다!!");
		return "/manager/addTrainer";
	}

    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("data") MultipartFile multipartFile) throws IOException {
        return s3Service.upload(multipartFile, "trainer");
    }
	
}
