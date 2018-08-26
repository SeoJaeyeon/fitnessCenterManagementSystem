package kr.ac.fcm.service;

import java.util.List;

import kr.ac.fcm.DTO.user.ManagerDTO;
import kr.ac.fcm.DTO.user.MemberDTO;
import kr.ac.fcm.DTO.user.MemberTrDTO;
import kr.ac.fcm.DTO.user.TrainerDTO;

//id를 통해 User를 불러오는 기능은 변화할 일이 거의 없기 때문에 하나의 인터페이스에 구현하도록 한다. 
public interface FindUserService {
	public ManagerDTO findManagerById(String id);
	public TrainerDTO findTrainerById(String id);
	public MemberDTO findMemberById(String id);
	public List<TrainerDTO> findAllTrainers(String center_id);
	public List<MemberTrDTO> findAllMembers(String center_id);
}
