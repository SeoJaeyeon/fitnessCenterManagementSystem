package kr.ac.fcm.DTO.user;

import lombok.Data;
import lombok.Getter;

@Getter
public class CenterDTO {
// center_id | center_name  | center_phone_number | registration_date | end_date   | address            
	private String center_id;
	private String center_name;
	private String center_phone_number;
	private String address;
}