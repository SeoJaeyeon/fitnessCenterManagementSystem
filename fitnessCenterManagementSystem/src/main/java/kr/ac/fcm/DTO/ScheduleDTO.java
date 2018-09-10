package kr.ac.fcm.DTO;



import java.sql.Date;

import org.joda.time.LocalDate;

import lombok.Data;

@Data
public class ScheduleDTO {
	private int hour;//9~21
	private Date date;
	private String member_id;
	private String trainer_id;
	private String member_name;
	private String trainer_name;
}
