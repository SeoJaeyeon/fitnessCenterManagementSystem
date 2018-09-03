package kr.ac.fcm.service;

import java.util.List;

import kr.ac.fcm.DTO.ScheduleDTO;

public interface ScheduleService {
	public List<ScheduleDTO> findThisWeekScheduleByMemberId(String member_id);
	public List<ScheduleDTO> findThisWeekScheduleByTrainerId(String trainer_id);
}
