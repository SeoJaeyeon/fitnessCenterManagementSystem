package kr.ac.fcm.user;

import lombok.Data;

@Data
public class Member extends Account{

	private int pt;
	private String name;
	private String gender;
	private String phone_number;
	private String center_id;

}
