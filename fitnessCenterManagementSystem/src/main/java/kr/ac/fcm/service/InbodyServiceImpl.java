package kr.ac.fcm.service;

import java.util.List;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.fcm.DTO.InbodyDTO;
import kr.ac.fcm.dao.InbodyDao;

@Service
public class InbodyServiceImpl {
	
	private InbodyDao inbodyDao;
	
	@Autowired
	public void setInbodyDao(InbodyDao inbodyDao){
		this.inbodyDao=inbodyDao;
	}
	
	public List<InbodyDTO> selectInbodyList(String member_id){
		return inbodyDao.selectInbodyByMemberId(member_id);
	}
	
	public InbodyDTO insertInbodyInfo(InbodyDTO inbody){
		LocalDate currentDate = LocalDate.now();  
		inbody.setRecord(currentDate.toString());
		return inbodyDao.insertInbody(inbody);
	}
}
