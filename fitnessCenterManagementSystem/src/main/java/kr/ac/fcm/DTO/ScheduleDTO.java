package kr.ac.fcm.DTO;

import lombok.Data;

@Data
public class ScheduleDTO {
	private int hour;//9~21
	private int day;//0~6
	private String member_name;
	private String trainer_name;
}
