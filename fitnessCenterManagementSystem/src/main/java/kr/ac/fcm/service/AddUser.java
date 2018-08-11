package kr.ac.fcm.service;

import kr.ac.fcm.user.Account;
import kr.ac.fcm.user.Member;
import kr.ac.fcm.user.Trainer;

//관리자의 사용자 등록 인터페이스 
public interface AddUser {
	
	public void addMember(Member member) throws Exception;
	public void addTrainer(Trainer trainer) throws Exception;

}
