package kr.ac.fcm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.fcm.DTO.ArticleDTO;
import kr.ac.fcm.DTO.CommentDTO;
import kr.ac.fcm.dao.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAO boardDao;
	
	@Override
	public List<ArticleDTO> showAllArticles() {
		return boardDao.findAllArticles();
	}
	
	@Override
	public ArticleDTO showArticleByIdx(int idx) {
		return boardDao.findArticleByIndex(idx);
	}

	@Override
	@Transactional
	public Integer write(ArticleDTO article) {
		// TODO Auto-generated method stub	
		boardDao.refreshIdx();
		return boardDao.saveArticle(article);
	}

	@Override
	public void reviseArticle(ArticleDTO article) {
		boardDao.reviseArticle(article);
	}

	@Override
	@Transactional
	public void deleteArticle(int idx) {
		boardDao.deleteArticle(idx);
		boardDao.refreshIdx();
	}

	@Override
	public void addComment(CommentDTO comment) {
		boardDao.saveComment(comment);
	}

	@Override
	public List<CommentDTO> showAllComments(int idx) {
		return boardDao.findAllCommentsByIdx(idx);
	}
	

}
