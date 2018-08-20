package kr.ac.fcm.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.ac.fcm.DTO.ArticleDTO;
import kr.ac.fcm.DTO.CommentDTO;
import kr.ac.fcm.DTO.user.Account;
import kr.ac.fcm.service.BoardService;
import kr.ac.fcm.service.FindUserService;

@Controller
public class BoardController {
	
	@Autowired
	private FindUserService findUesrService;
	
	private Account user;
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board.do")
	public String showArticleList(@AuthenticationPrincipal Account account, Model model){
		this.user=account;
		List<ArticleDTO> articles=boardService.showAllArticles();
		model.addAttribute("articles",articles);
		model.addAttribute("type",account.getType());
		model.addAttribute("board","active");
		return "/board/articleList";
	}
	
	@GetMapping("/write.do")
	public String showArticle(Model model){
		model.addAttribute("board","active");
		model.addAttribute("type",user.getType());
		return "/board/write";
	}
	
	@PostMapping("/write.do")
	public String addArticle(ArticleDTO article,Model model){
		try{
			article.setWriter(user.getId());
			article.setView(0);
			article.setCreated(new Date());
			boardService.write(article);
		}catch(Exception e){
			e.printStackTrace();
		}
		model.addAttribute("board","active");
		model.addAttribute("type",user.getType());
		return "redirect:/article?no="+article.getIdx();
	}
	@GetMapping("/article")
	public String showArticle(HttpServletRequest req, Model model){
		int idx=Integer.parseInt(req.getParameter("no"));
		ArticleDTO article=new ArticleDTO();
		article=boardService.showArticleByIdx(idx);
		model.addAttribute("type",user.getType());
		model.addAttribute("article",article);
		model.addAttribute("user",user);
		model.addAttribute("board","active");
		return "/board/article";
		
	}
/*	
	//댓글작
	@PostMapping("/article")
	public String addComment(CommentDTO comment){
		comment.setCenter_id(center_id);
	}*/

}
