package kr.ac.fcm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kr.ac.fcm.DTO.user.MemberDTO;
import kr.ac.fcm.DTO.user.MemberTrDTO;
import kr.ac.fcm.mapper.MemberMapper;

/*
 * read member
 */
public class MemberDAO {
	
	@Autowired
	private MemberMapper memberMapper;

	public MemberDTO findMemberById(String id) {
		return memberMapper.findMemberByMemberId(id);
	}
	
	public List<MemberTrDTO> findAllMembersWithTrainer(String center_id) {
		List<MemberTrDTO> members=memberMapper.selectAllMembersWithTrainer(center_id);
		return members;
	}
	
	public List<MemberTrDTO> findAllMembersWithNullTrainer(String center_id) {
		List<MemberTrDTO> members=memberMapper.selectAllMemberWithNullTrainer(center_id);
		return members;
	}
}
