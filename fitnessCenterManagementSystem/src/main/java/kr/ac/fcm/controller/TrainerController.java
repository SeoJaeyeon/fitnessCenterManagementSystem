package kr.ac.fcm.controller;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.fcm.DTO.user.Account;
import kr.ac.fcm.DTO.user.TrainerDTO;
import kr.ac.fcm.DTO.user.UserRepository;
import kr.ac.fcm.service.FindUserService;
import kr.ac.fcm.service.ReviseMyInfoService;
import kr.ac.fcm.service.s3.S3Service;

@Controller
public class TrainerController {
	Logger logger=LoggerFactory.getLogger(TrainerController.class);
	
	@Autowired
	private FindUserService findUserService;
	
	@Autowired
	private S3Service s3Service;
	
	@Autowired
	private ReviseMyInfoService reviseTrainerInfoService;
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/trainer")
	public String trainerMain(@AuthenticationPrincipal Account account, Model model){
		
		model.addAttribute("schedule", "active");
		model.addAttribute("type",userRepository.getTrainer(account.getId(), account.getType()).getType());
		return "/schedule";
	}
	
	@PostMapping("/trainer/mypage")
	@Transactional
	public String trainerMyPageByPost(@AuthenticationPrincipal Account account, @Valid TrainerDTO trainer, HttpServletRequest req, BindingResult bindingResult, Model model, @RequestParam("file") MultipartFile multipartFile) throws IOException{
		if(bindingResult.hasErrors())
		{
			logger.info(bindingResult.getAllErrors().get(0).toString());
			return "/trainer/tr_mypage";
		}
		String message=reviseTrainerInfoService.reviseMyInfo(req.getParameter("cur_password"), trainer);
		if(!multipartFile.isEmpty()){
			s3Service.deleteFile(trainer.getId());
			s3Service.upload(multipartFile, "trainer", trainer.getId());
		}
		logger.info("//////////"+multipartFile);
		model.addAttribute("message",message);
		model.addAttribute("trainer",userRepository.getTrainer(account.getId(), account.getType()));
		model.addAttribute("mypage", "active");
		return "/trainer/tr_mypage";
	}
	
	@GetMapping("/trainer/mypage")
	public String trainerMyPage(@AuthenticationPrincipal Account account, Model model,HttpServletRequest req){
		TrainerDTO trainer=userRepository.getTrainer(account.getId(), account.getType());
		model.addAttribute("trainer",trainer);
		model.addAttribute("closed_day",trainer.getClosed_day());
		model.addAttribute("img",s3Service.getFileURL(s3Service.getBucket(), trainer.getId()));
		if(req.getParameter("message")==null)
			model.addAttribute("message",req.getParameter(""));
		else if(req.getParameter("message").length()>0){
			model.addAttribute("message",req.getParameter("message"));
		}
		model.addAttribute("mypage", "active");
		return "trainer/tr_mypage";
	}

}
