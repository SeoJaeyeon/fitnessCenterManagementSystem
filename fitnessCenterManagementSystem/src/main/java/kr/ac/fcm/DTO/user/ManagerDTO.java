package kr.ac.fcm.DTO.user;

import lombok.Data;


@Data
public class ManagerDTO extends Account{	
	private String name;
	private String phoneNumber;
	
	@Override
	public String toString(){
		return this.getId()+","+this.getPassword()+","+this.getType()+","+   this.getName()+", "+this.getCenter_id()+", "+this.getPhoneNumber()+".";
	}
}


