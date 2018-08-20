package kr.ac.fcm.DTO.user;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ManagerDTO extends Account{	
	private String name;
	private String phoneNumber;
	
	@Override
	public String toString(){
		return this.getId()+","+this.getPassword()+","+this.getType()+","+   this.getName()+", "+this.getCenter_id()+", "+this.getPhoneNumber()+".";
	}
}


