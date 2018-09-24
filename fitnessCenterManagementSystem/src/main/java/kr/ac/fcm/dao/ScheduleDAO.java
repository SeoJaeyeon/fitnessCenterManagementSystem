package kr.ac.fcm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
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

	public boolean applySchedule(String member_id, String trainer_id,  String hour, String date){
		return scheduleMapper.applySchedule(member_id, trainer_id, hour,date);
	}
	
	public int countApplySchedule(String member_id, String date){
		return scheduleMapper.countApplyRecord(member_id, date);
	}
	
	public List<ScheduleDTO> findSchedulesByHourAndDateAndTrainerId(String hour, String start_date,String end_date, String trainer_id){
		return scheduleMapper.findSchedulesByHourAndDateAndTrainerId(hour, start_date, end_date, trainer_id);
	}
	
	public void cancleSchedule(String member_id, String date, String hour){
		scheduleMapper.cancleSchedule(hour, date, member_id);
	}

	public  void reservSchedule(String member_id, String trainer_id, String hour, String date, int idx){
		scheduleMapper.reserveSchedule(member_id, trainer_id, hour, date, idx);
	}
	
	public Integer getMaxIdxByReservTable(String member_id, String trainer_id, String date, String hour){
		return scheduleMapper.getMaxIdxFromReserve(hour, date, member_id, trainer_id);
	}
}
