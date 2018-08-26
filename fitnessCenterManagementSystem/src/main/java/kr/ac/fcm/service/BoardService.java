package kr.ac.fcm.service;

import java.util.List;

import kr.ac.fcm.DTO.ArticleDTO;
import kr.ac.fcm.DTO.CommentDTO;

/*
 * 게시판 이용관련 서비스
 * CRUD 
 * 변경가능성 보통
 */
public interface BoardService {
	public List<ArticleDTO> showAllArticles();
	public int write(ArticleDTO article) throws Exception;
	public ArticleDTO showArticleByIdx(int idx);
	public void reviseArticle(ArticleDTO article);
	public void deleteArticle(int idx);
	
	public void addComment(CommentDTO comment);
	public List<CommentDTO> showAllComments(int idx);
}
