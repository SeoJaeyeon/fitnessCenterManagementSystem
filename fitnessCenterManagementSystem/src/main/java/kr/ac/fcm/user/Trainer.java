package kr.ac.fcm.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Trainer extends Account{
	@Size(min=2, max=5)@Pattern(regexp="^[ㄱ-ㅎ가-힣]*$", message="올바른 이름을 입력해주세요!!") @NotNull(message="이 필드는 비어있을 수 없습니다!!!")
	private String name;
	private String gender;
	@Pattern(regexp="^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}$", message="올바른 전화번호를 입력해주세요!!") @NotNull(message="이 필드는 비어있을 수 없습니다!!!")
	private String phone_number;
	private String closed_day;
	private String center_id;
	@Pattern(regexp="^[0-9][0-9][0-9][0-9]\\-[0-9][0-9]\\-[0-9][0-9]$", message="0000-00-00 형식을 준수해주세요!!!")
	private String birthdate;
}
