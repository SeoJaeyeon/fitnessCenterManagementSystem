package kr.ac.fcm.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
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

import kr.ac.fcm.service.FindUserService;
import kr.ac.fcm.service.ReviseMyInfoService;
import kr.ac.fcm.service.s3.S3Wrapper;
import kr.ac.fcm.user.Trainer;

@Controller
public class TrainerController {
	Logger logger=LoggerFactory.getLogger(TrainerController.class);
	
	private Trainer trainer;
	
	@Autowired
	private FindUserService findUserService;
	
	@Autowired
	private S3Wrapper s3Service;
	
	@Autowired
	private ReviseMyInfoService reviseMyInfoService;

	@GetMapping("/trainer")
	public String trainerMain(HttpServletRequest req,Model model){
		this.trainer=findUserService.findTrainerById(req.getParameter("id"));
		model.addAttribute("name",trainer.getName());
		return "trainer/trainer";
	}
	
	@PostMapping("/trainer/mypage")
	public String trainerMyPageByPost(@Valid Trainer trainer, HttpServletRequest req, BindingResult bindingResult, Model model, @RequestParam("file") MultipartFile multipartFile) throws IOException{
		if(bindingResult.hasErrors())
		{
			logger.info(bindingResult.getAllErrors().get(0).toString());
			return "/trainer/tr_mypage";
		}
		String message=reviseMyInfoService.reviseTrainerInfo(req.getParameter("cur_password"), trainer);
		if(multipartFile!=null){
			s3Service.deleteFile(trainer.getId());
			s3Service.upload(multipartFile, "trainer", trainer.getId());
		}
		logger.info("//////////"+multipartFile);
		model.addAttribute("message",message);
		this.trainer=findUserService.findTrainerById(trainer.getId());
		model.addAttribute("trainer",trainer);
		return "/trainer/tr_mypage";
	}
	
	@GetMapping("/trainer/mypage")
	public String trainerMyPage(Model model,HttpServletRequest req){
		model.addAttribute("trainer",trainer);
		model.addAttribute("closed_day",trainer.getClosed_day());
		model.addAttribute("img",s3Service.getFileURL(s3Service.getBucket(), trainer.getId()));
		if(req.getParameter("message")==null)
			model.addAttribute("message",req.getParameter(""));
		else if(req.getParameter("message").length()>0){
			model.addAttribute("message",req.getParameter("message"));
		}
		
		return "trainer/tr_mypage";
	}
}
