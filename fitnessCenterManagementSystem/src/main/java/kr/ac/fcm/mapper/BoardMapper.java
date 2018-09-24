package kr.ac.fcm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
	
	@Update("UPDATE BOARD SET SUBJECT=#{article.subject}, CONTENT=#{article.content}, CREATED= #{article.created} WHERE IDX=#{article.idx}")
	public void reviseArticle(@Param("article") ArticleDTO article);
	
	@Delete("DELETE FROM BOARD WHERE idx=#{idx}")
	public void deleteArticle(int idx);
	
	@Update("ALTER TABLE BOARD AUTO_INCREMENT =1; SET @COUNT=0; UPDATE BOARD SET IDX = @COUNT:=@COUNT+1")
	@Options()
	public void indexingBoard();
	
	//comment 창 
	@Insert("INSERT INTO COMMENT VALUES(#{comment.center_id}, #{comment.writer}, #{comment.content}, #{comment.created}, #{comment.idx})")
	public void addComment(@Param("comment") CommentDTO comment);
	
	@Select("SELECT* FROM COMMENT WHERE IDX=#{idx} order by created asc")
	public List<CommentDTO> showAllComments(int idx);
	
	@Delete("DELETE FROM COMMENT WHERE IDX=#{idx}")
	public void deleteCommentByIdx(int idx);
	
	
}
