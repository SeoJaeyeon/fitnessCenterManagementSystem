package kr.ac.fcm.service;

import kr.ac.fcm.user.Trainer;

public interface ReviseMyInfoService {
	public String reviseTrainerInfo(String oldpassword, Trainer trainer);
}
