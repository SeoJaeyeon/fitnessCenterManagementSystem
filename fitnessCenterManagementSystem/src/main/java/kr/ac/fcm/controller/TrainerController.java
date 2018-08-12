package kr.ac.fcm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.ac.fcm.service.FindUserService;
import kr.ac.fcm.user.Trainer;

@Controller
public class TrainerController {
	
	private Trainer trainer;
	
	@Autowired
	private FindUserService FindUserService;

	@GetMapping("/trainer")
	public String trainerMain(HttpServletRequest req,Model model){
		this.trainer=FindUserService.findTrainerById(req.getParameter("id"));
		model.addAttribute("name",trainer.getName());
		return "trainer/trainer";
	}
	
	@PostMapping("/trainer/mypage")
	public String trainerMyPageByPost(HttpServletRequest req,Model model){
		model.addAttribute("trainer",trainer);
		return "trainer/trainer";
	}
	
	@GetMapping("/trainer/mypage")
	public String trainerMyPage(Model model){
		model.addAttribute("trainer",trainer);
		model.addAttribute("closed_day",trainer.getClosed_day());
		return "trainer/tr_mypage";
	}
}
