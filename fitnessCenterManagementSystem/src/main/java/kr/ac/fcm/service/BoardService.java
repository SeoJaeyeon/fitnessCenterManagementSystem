package kr.ac.fcm.service;

import java.util.List;

import kr.ac.fcm.DTO.ArticleDTO;

public interface BoardService {
	public List<ArticleDTO> showAllArticles();
	public int write(ArticleDTO article) throws Exception;
	public ArticleDTO showArticleByIdx(int idx);
}
