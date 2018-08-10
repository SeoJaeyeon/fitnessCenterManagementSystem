package kr.ac.fcm.user;

import lombok.Data;

@Data
public class Trainer extends Account{
	private String name;
	private String gender;
	private String phone_number;
	private String closed_day;
	private String center_id;
	private String birthdate;
}
