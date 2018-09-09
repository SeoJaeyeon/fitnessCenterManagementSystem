package kr.ac.fcm.DTO;



import org.joda.time.LocalDate;

import lombok.Data;

@Data
public class ScheduleDTO {
	private int hour;//9~21
	private LocalDate date;
	private String member_name;
	private String trainer_name;
}
