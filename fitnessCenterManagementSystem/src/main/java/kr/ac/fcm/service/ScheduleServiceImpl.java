package kr.ac.fcm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.fcm.DTO.ScheduleDTO;
import kr.ac.fcm.dao.ScheduleDAO;

@Service
public class ScheduleServiceImpl implements ScheduleService {
	@Autowired
	private ScheduleDAO scheduleDao;

	@Override
	public List<ScheduleDTO> findThisWeekScheduleByMemberId(String member_id) {
		return scheduleDao.selectThisWeekScheduleByMemberId(member_id);
	}

	@Override
	public List<ScheduleDTO> findThisWeekScheduleByTrainerId(String trainer_id) {
		return scheduleDao.selectThisWeekScheduleByTrainerId(trainer_id);
	}

}
