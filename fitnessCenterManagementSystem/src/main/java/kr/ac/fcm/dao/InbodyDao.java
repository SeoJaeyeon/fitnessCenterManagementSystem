package kr.ac.fcm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.fcm.DTO.InbodyDTO;
import kr.ac.fcm.mapper.InbodyMapper;

@Repository
public class InbodyDao {
	@Autowired
	private InbodyMapper inbodyMapper;
	
	public List<InbodyDTO> selectInbodyByMemberId(String memberId){
		return inbodyMapper.selectFromInbodyByMemberId(memberId);
	}
	
	public InbodyDTO insertInbody(InbodyDTO inbody){
		inbodyMapper.insertInbody(inbody);
		return inbody;
	}

}
