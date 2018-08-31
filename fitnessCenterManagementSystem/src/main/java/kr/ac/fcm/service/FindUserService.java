package kr.ac.fcm.service;

import java.util.List;

import kr.ac.fcm.DTO.user.ManagerDTO;
import kr.ac.fcm.DTO.user.MemberDTO;
import kr.ac.fcm.DTO.user.MemberTrDTO;
import kr.ac.fcm.DTO.user.TrainerDTO;

/*
 * DB에서 유저를 호출하는 서비스 
 * 변경가능성 보통
 */
public interface FindUserService {
	public ManagerDTO findManagerById(String id);
	public TrainerDTO findTrainerById(String id);
	public MemberDTO findMemberById(String id);
	public List<TrainerDTO> findAllTrainers(String center_id);
	public List<TrainerDTO> findTrainersByName(String name, String center_id);
	public List<MemberTrDTO> findAllMembers(String center_id);
	public List<MemberTrDTO> findMembersByName(String name, String center_id);
}
