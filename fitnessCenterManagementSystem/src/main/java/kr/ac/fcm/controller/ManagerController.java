package kr.ac.fcm.controller;



import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.ibatis.annotations.Param;
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
import kr.ac.fcm.DTO.user.ManagerDTO;
import kr.ac.fcm.DTO.user.MemberDTO;
import kr.ac.fcm.DTO.user.TrainerDTO;
import kr.ac.fcm.service.AddUserService;
import kr.ac.fcm.service.BoardService;
import kr.ac.fcm.service.FindUserService;
import kr.ac.fcm.service.s3.S3Service;


@Controller
public class ManagerController {
	Logger logger=LoggerFactory.getLogger(ManagerController.class);
	private ManagerDTO manager;

	@Autowired
	private FindUserService findUserService;
	@Autowired
	private S3Service s3Service;
	@Autowired
	private AddUserService addUserService;
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/manager")
	public String manager(@AuthenticationPrincipal Account account, Model model){
		logger.info(account.getUsername()+"접속");
		this.manager=findUserService.findManagerById(account.getUsername());
		this.manager.setType(account.getType());
		model.addAttribute("schedule","active");
		return "manager/manager";
	}
	
	@GetMapping("/manager/addMember")
	public String addUserByGet(Model model){
		model.addAttribute("management","active");
		model.addAttribute("member", new MemberDTO());
		return "manager/addMember";
	}
	
	@PostMapping("/manager/addMember")
	public String addUserByPost(@Valid MemberDTO member, BindingResult bindingResult,Model model){
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
			return "/manager/addMember";
		}
		model.addAttribute("management","active");
		model.addAttribute("message","정상적으로 등록되었습니다.");
		model.addAttribute("member", new MemberDTO());
		return "/manager/addUser";
	}

	@GetMapping("/manager/addTrainer")
	public String addTrainerByGET(Model model){
		model.addAttribute("trainer", new TrainerDTO());
		model.addAttribute("management","active");
		return "/manager/addTrainer";
	}
	@PostMapping("/manager/addTrainer")
	public String addTrainer(@Valid TrainerDTO trainer,BindingResult bindingResult, Model model,HttpServletRequest req,@RequestParam("file") MultipartFile multipartFile){
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
		model.addAttribute("management","active");
		model.addAttribute("message","정상적으로 추가되었습니다!!");
		model.addAttribute("trainer",new TrainerDTO());
		return "/manager/addTrainer";
	}
	
	@GetMapping("/manager/board.do")
	public String showBoardList(Model model){
		List<ArticleDTO> articles=boardService.showAllArticles();
		model.addAttribute("articles",articles);
		model.addAttribute("type",manager.getType());
		model.addAttribute("board","active");
		return "/board/articleList";
	}
	
	@GetMapping("/manager/write.do")
	public String writeArticle(Model model){
		model.addAttribute("board","active");
		return "/board/write";
	}
	
	@PostMapping("/manager/write.do")
	public String addArticle(ArticleDTO article, Model model){
		try{
			article.setCreated(new Date());
			article.setView(0);
			article.setWriter(manager.getId());
			boardService.write(article);
		}catch(Exception e){
			e.printStackTrace();
		}		
		model.addAttribute("board","active");
		return "/board/article.do?idx="+article.getIdx();
	}
	
/*	@GetMapping("/manager/article")
	public String showArticle(@Param("no") int idx, Model model){
		ArticleDTO article=new ArticleDTO();
		article=boardService.showArticleByIdx(idx);
		
	}*/

}
