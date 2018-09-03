package kr.ac.fcm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.fcm.DTO.ScheduleDTO;
import kr.ac.fcm.mapper.ScheduleMapper;

@Repository
public class ScheduleDAO {
	
	@Autowired
	private ScheduleMapper scheduleMapper;
	
	public List<ScheduleDTO> selectThisWeekScheduleByMemberId(String member_id){
		return scheduleMapper.selectThisWeekSchedulesByMemberId(member_id);
	}
	
	public List<ScheduleDTO> selectThisWeekScheduleByTrainerId(String trainer_id){
		return scheduleMapper.selectThisWeekSchedulesByTrainerId(trainer_id);
	}

}
