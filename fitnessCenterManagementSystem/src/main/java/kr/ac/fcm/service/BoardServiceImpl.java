package kr.ac.fcm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.fcm.DTO.ArticleDTO;
import kr.ac.fcm.DTO.CommentDTO;
import kr.ac.fcm.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public List<ArticleDTO> showAllArticles() {
		// TODO Auto-generated method stub
		
		return boardMapper.selectAllArticles();
	}

	@Override
	@Transactional
	public int write(ArticleDTO article) {
		// TODO Auto-generated method stub	
		boardMapper.indexingBoard();
		return boardMapper.addArticle(article);
	}

	@Override
	public ArticleDTO showArticleByIdx(int idx) {
		// TODO Auto-generated method stub
		return boardMapper.selectArticleByIdx(idx);
	}

	@Override

	public void reviseArticle(ArticleDTO article) {
		// TODO Auto-generated method stub
		boardMapper.reviseArticle(article);

		
	}

	@Override
	@Transactional
	public void deleteArticle(int idx) {
		// TODO Auto-generated method stub
		boardMapper.deleteArticle(idx);
		boardMapper.indexingBoard();
	}

	@Override
	public void addComment(CommentDTO comment) {
		// TODO Auto-generated method stub
		boardMapper.addComment(comment);
	}

	@Override
	public List<CommentDTO> showAllComments(int idx) {
		// TODO Auto-generated method stub
		List<CommentDTO> comments=boardMapper.showAllComments(idx);
		return comments;
	}
	

}
