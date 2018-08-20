package kr.ac.fcm.controller;

import java.io.IOException;
import java.util.Date;
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

import kr.ac.fcm.DTO.ArticleDTO;
import kr.ac.fcm.DTO.user.Account;
import kr.ac.fcm.DTO.user.TrainerDTO;
import kr.ac.fcm.service.BoardService;
import kr.ac.fcm.service.FindUserService;
import kr.ac.fcm.service.ReviseMyInfoService;
import kr.ac.fcm.service.s3.S3Service;
import kr.ac.fcm.service.s3.S3ServiceImpl;

@Controller
public class TrainerController {
	Logger logger=LoggerFactory.getLogger(TrainerController.class);
	
	private TrainerDTO trainer;
	
	@Autowired
	private FindUserService findUserService;
	
	@Autowired
	private S3Service s3Service;
	
	@Autowired
	private ReviseMyInfoService reviseMyInfoService;
	
	@Autowired
	private BoardService boardService;

	@GetMapping("/trainer")
	public String trainerMain(@AuthenticationPrincipal Account account, Model model){
		this.trainer=findUserService.findTrainerById(account.getUsername());
		this.trainer.setType(account.getType());
		model.addAttribute("schedule", "active");
		return "trainer/trainer";
	}
	
	@PostMapping("/trainer/mypage")
	@Transactional
	public String trainerMyPageByPost(@Valid TrainerDTO trainer, HttpServletRequest req, BindingResult bindingResult, Model model, @RequestParam("file") MultipartFile multipartFile) throws IOException{
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
		model.addAttribute("mypage", "active");
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
		model.addAttribute("mypage", "active");
		return "trainer/tr_mypage";
	}
	
	@GetMapping("/trainer/board.do")
	public String showArticles(Model model){
		List<ArticleDTO> articles=boardService.showAllArticles();
		model.addAttribute("articles",articles);
		model.addAttribute("type",trainer.getType());
		model.addAttribute("board", "active");
		return "/board/articleList";
	}
	
	@GetMapping("/trainer/write.do")
	public String showArticle(Model model){
		model.addAttribute("board", "active");
		return "/board/write";
	}
	
	@PostMapping("/trainer/write.do")
	public String addArticle(ArticleDTO article, Model model){
		try{
			article.setCreated(new Date());
			article.setWriter(trainer.getId());
			article.setView(0);
			boardService.write(article);
		}catch(Exception e){
			e.printStackTrace();
		}
		model.addAttribute("board", "active");
		return "/board/article?idx="+article.getIdx();
	}
}
