package kr.ac.fcm.service;

import kr.ac.fcm.user.Manager;
import kr.ac.fcm.user.Member;
import kr.ac.fcm.user.Trainer;

public interface FindUserService {
	public Manager findManagerById(String id);
	public Trainer findTrainerById(String id);
	public Member findMemberById(String id);
}
