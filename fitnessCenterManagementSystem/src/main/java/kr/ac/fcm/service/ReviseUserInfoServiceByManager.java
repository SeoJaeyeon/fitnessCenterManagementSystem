package kr.ac.fcm.service;

import kr.ac.fcm.DTO.user.MemberDTO;
import kr.ac.fcm.DTO.user.TrainerDTO;

//헬스장 관리자가 사용자의 정보를 수정하는 기능 
public interface ReviseUserInfoServiceByManager {
	public void reviseMemberInfo(MemberDTO member );
	public void reviseTrainerInfo(TrainerDTO trainer);
}
