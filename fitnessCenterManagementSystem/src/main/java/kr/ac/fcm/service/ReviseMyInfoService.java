package kr.ac.fcm.service;

import kr.ac.fcm.DTO.user.Account;

/*
 * 회원/트레이너의 개인정보수정 서비스
 * 변경가능성 보
 */
public interface ReviseMyInfoService {

	public String reviseMyInfo(String oldpassword, Account account) ;

}
