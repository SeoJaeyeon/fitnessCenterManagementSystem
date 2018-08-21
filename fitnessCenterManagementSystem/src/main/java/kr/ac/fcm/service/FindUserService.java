package kr.ac.fcm.service;

import java.util.List;

import kr.ac.fcm.DTO.user.ManagerDTO;
import kr.ac.fcm.DTO.user.MemberDTO;
import kr.ac.fcm.DTO.user.TrainerDTO;

public interface FindUserService {
	public ManagerDTO findManagerById(String id);
	public TrainerDTO findTrainerById(String id);
	public MemberDTO findMemberById(String id);
	public List<TrainerDTO> findAllTrainers(String center_id);
}
