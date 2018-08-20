package kr.ac.fcm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.fcm.DTO.ArticleDTO;
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
	public int write(ArticleDTO article) {
		// TODO Auto-generated method stub
		return boardMapper.addArticle(article);
	}

	@Override
	public ArticleDTO showArticleByIdx(int idx) {
		// TODO Auto-generated method stub
		return boardMapper.selectArticleByIdx(idx);
	}

}
