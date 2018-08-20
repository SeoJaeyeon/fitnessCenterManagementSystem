package kr.ac.fcm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import kr.ac.fcm.DTO.ArticleDTO;
import kr.ac.fcm.DTO.CommentDTO;

@Mapper
public interface BoardMapper {
	@Select("SELECT* FROM BOARD ORDER BY IDX DESC")
	public List<ArticleDTO> selectAllArticles();
	
	@Select("SELECT* FROM BOARD WHERE IDX=#{idx}")
	public ArticleDTO selectArticleByIdx(@Param("idx") int idx);
	
	@Insert("INSERT INTO BOARD(WRITER, SUBJECT, CONTENT, CREATED, VIEW)  VALUES(#{article.writer},#{article.subject},#{article.content}, #{article.created}, #{article.view})")
	@Options(useGeneratedKeys=true, keyProperty="article.idx")
	public int addArticle(@Param("article")ArticleDTO article);
	
	
	//comment 창 
	@Insert("INSERT INTO COMMENT VALUES(#{comment.center_id}, #{comment.writer}, #{comment.content}, #{comment.created}")
	public void addComment(@Param("comment") CommentDTO comment);
	
}
