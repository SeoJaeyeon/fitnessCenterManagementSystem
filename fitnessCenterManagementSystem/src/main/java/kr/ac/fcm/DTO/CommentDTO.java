package kr.ac.fcm.DTO;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDTO {
	private String center_id;
	private String writer;
	private String content;
	private Date created;
	private int idx;
}
