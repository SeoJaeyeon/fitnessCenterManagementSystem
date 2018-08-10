package kr.ac.fcm.user;
import lombok.Data;

@Data
public class Manager extends Account{
	
	
	private String name;
	private String center_id;
	private String phoneNumber;
	
	@Override
	public String toString(){
		return this.getId()+","+this.getPassword()+","+this.getType()+","+   this.getName()+", "+this.getCenter_id()+", "+this.getPhoneNumber()+".";
	}
}


