package kr.ac.fcm.controller;
import java.io.IOException;
import java.util.List;

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
import kr.ac.fcm.DTO.user.MemberDTO;
import kr.ac.fcm.DTO.user.MemberTrDTO;
import kr.ac.fcm.DTO.user.TrainerDTO;
import kr.ac.fcm.service.AccountService;
import kr.ac.fcm.service.FindUserService;
import kr.ac.fcm.service.ReviseMyInfoService;
import kr.ac.fcm.service.s3.S3Service;

@Controller
public class TrainerController {
	Logger logger=LoggerFactory.getLogger(TrainerController.class);
	
	@Autowired
	private S3Service s3Service;
	
	@Autowired
	private ReviseMyInfoService reviseTrainerInfoService;

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private FindUserService findUserService;

	@GetMapping("/trainer")
	public String trainerMain(@AuthenticationPrincipal Account account, Model model){
		
		model.addAttribute("schedule", "active");
		model.addAttribute("type", findUserService.findTrainerById(account.getId()).getType());
		return "/schedule";
	}	
	
	@GetMapping("/trainer/mypage")
	public String trainerMyPage(@AuthenticationPrincipal Account account, Model model,HttpServletRequest req){
		if(req.getParameter("pwerror")!=null)
			model.addAttribute("message","패스워드를 다시한번 확인해주세요!!");
		else if(req.getParameter("error")!=null)
			model.addAttribute("message","예기치못한 오류가 발생하였습니다!!");
		else if(req.getParameter("success")!=null)
			model.addAttribute("message","정상적으로 변경되었습니다!!");
		else
			model.addAttribute("message","");
		
		TrainerDTO trainer=findUserService.findTrainerById(account.getId());
		model.addAttribute("trainer",trainer);
		model.addAttribute("closed_day",trainer.getClosed_day());
		model.addAttribute("img",s3Service.getFileURL(s3Service.getBucket(), trainer.getId()));
		
		model.addAttribute("mypage", "active");
		return "trainer/tr_mypage";
	}

	@Transactional
	@PostMapping("/trainer/mypage")
	public String trainerMyPageByPost(@AuthenticationPrincipal Account account, @Valid TrainerDTO trainer, HttpServletRequest req, BindingResult bindingResult, Model model, @RequestParam("file") MultipartFile multipartFile) throws IOException{
		if(bindingResult.hasErrors())
		{
			logger.info(bindingResult.getAllErrors().get(0).toString());
			return "/trainer/tr_mypage";
		}
		
		// confirm password 
		if(!accountService.matchPassword(trainer.getId(),req.getParameter("cur_password"))){
			return "redirect:/trainer/mypage?pwerror";
		}
		try{
			accountService.updatePassword(trainer.getId(), trainer.getPassword());
			reviseTrainerInfoService.reviseMyInfo(trainer);
			if(!multipartFile.isEmpty()){
				s3Service.deleteFile(trainer.getId());
				s3Service.upload(multipartFile, "trainer", trainer.getId());
			}
		}catch(Exception e){
			return "redirect:/trainer/mypage?error";
		}
		
		model.addAttribute("trainer",findUserService.findTrainerById(account.getId()));
		model.addAttribute("mypage", "active");
		return "/trainer/tr_mypage";
	}
	
	@GetMapping("/trainer/showMemberList")
	public String showMemberListByGet(@AuthenticationPrincipal Account account, Model model, HttpServletRequest req){
		List<MemberDTO> members=findUserService.findMembersByTrainerId(account.getId());
		model.addAttribute("members", members);
		model.addAttribute("management", "active");
		return "/trainer/memberinfo";
	}
	
	@PostMapping("/trainer/showMemberList")
	public String showMemberListByPost(@AuthenticationPrincipal Account account, Model model, HttpServletRequest req){
		List<MemberTrDTO> members=findUserService.findMembersByName(req.getParameter("name"), account.getCenter_id());
		model.addAttribute("members", members);
		model.addAttribute("management", "active");
		return "/trainer/memberinfo";
	}
}
