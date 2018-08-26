package kr.ac.fcm.service;


import kr.ac.fcm.DTO.user.MemberDTO;
import kr.ac.fcm.DTO.user.TrainerDTO;

/*
 * 헬스장 관리자의 사용자(회원/트레이너)등록 서비스
 * 변경가능성 보통
 */
public interface AddUserService {
	public void addMember(MemberDTO member) throws Exception;
	public void addTrainer(TrainerDTO trainer) throws Exception;
}
