package kr.ac.fcm.service;

import kr.ac.fcm.DTO.user.TrainerDTO;

public interface ReviseMyInfoService {
	public String reviseTrainerInfo(String oldpassword, TrainerDTO trainer);
}
