package kr.ac.fcm.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.ac.fcm.DTO.ArticleDTO;
import kr.ac.fcm.DTO.user.Account;
import kr.ac.fcm.DTO.user.MemberDTO;
import kr.ac.fcm.service.BoardService;
import kr.ac.fcm.service.FindUserService;

@Controller
public class MemberController {
	
	private MemberDTO member;
	
	Logger logger=LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private FindUserService findUserService;
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/member")
	public String showMemberView(@AuthenticationPrincipal Account account){
		this.member=findUserService.findMemberById(account.getId());
		return "/member/member";
	}
	
	@GetMapping("/member/board.do")
	public String showArticleList(Model model){
		List<ArticleDTO> articles=boardService.showAllArticles();
		model.addAttribute("articles",articles);
		return "/member/member_articleList";
	}
	
	@GetMapping("/member/write.do")
	public String showArticle(){
		return "/member/member_write";
	}
	
	@PostMapping("/member/write.do")
	public String addArticle(ArticleDTO article){
		try{
			article.setWriter(member.getId());
			article.setView(0);
			article.setCreated(new Date());
			boardService.write(article);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "/member/article.do?idx="+article.getIdx();
	}

}
