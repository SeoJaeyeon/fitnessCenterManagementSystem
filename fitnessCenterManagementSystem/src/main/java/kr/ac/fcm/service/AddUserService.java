package kr.ac.fcm.service;


import kr.ac.fcm.DTO.user.MemberDTO;
import kr.ac.fcm.DTO.user.TrainerDTO;

//관리자의 사용자 등록 인터페이스 
public interface AddUserService {

	public void addMember(MemberDTO member) throws Exception;
	public void addTrainer(TrainerDTO trainer) throws Exception;

}
