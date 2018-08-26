package kr.ac.fcm.service;

import kr.ac.fcm.DTO.user.MemberDTO;
import kr.ac.fcm.DTO.user.TrainerDTO;

/*
 * 헬스장관리자가 회원/트레이너의 정보를 수정하는 서비스
 * 변경가능성 보통
 */
public interface ReviseUserInfoServiceByManager {
	public void reviseMemberInfo(MemberDTO member );
	public void reviseTrainerInfo(TrainerDTO trainer);
}
