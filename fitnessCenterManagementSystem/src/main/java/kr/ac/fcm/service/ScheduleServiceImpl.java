package kr.ac.fcm.service;


import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.fcm.DTO.ScheduleDTO;
import kr.ac.fcm.dao.ScheduleDAO;

@Service
public class ScheduleServiceImpl implements ScheduleService {
	@Autowired
	private ScheduleDAO scheduleDao;
	
	Logger logger=LoggerFactory.getLogger(ScheduleServiceImpl.class);

	@Override
	public List<ScheduleDTO> findThisWeekScheduleByMemberId(String member_id) {
		return scheduleDao.selectThisWeekScheduleByMemberId(member_id);
	}

	@Override
	public List<ScheduleDTO> findThisWeekScheduleByTrainerId(String trainer_id) {
		return scheduleDao.selectThisWeekScheduleByTrainerId(trainer_id);
	}

	@Override
	public boolean applySchedule(String member_id, String trainer_id, String day, String hour, int pt) {
		
		
		LocalDate currentDate = LocalDate.now();  
		int curday=currentDate.getDayOfWeek();

		LocalDate afterTwoWeeks= currentDate.plusDays(15-curday+Integer.parseInt(day));
		
		logger.info(afterTwoWeeks.toString()+"/"+pt);

		if(scheduleDao.countApplySchedule(member_id, currentDate.plusDays(15-curday).toString())>=pt)
				return false;
		

		return scheduleDao.applySchedule(member_id, trainer_id, hour,afterTwoWeeks.toString());
	}

	@Override
	public List<ScheduleDTO> findAfterTwoWeeksSchedulesByTrainerIdAndHour(String trainer_id) {

		LocalDate currentDate = LocalDate.now();  
		int curday=currentDate.getDayOfWeek();

		LocalDate afterTwoWeeks= currentDate.plusDays(15-curday);
		List<ScheduleDTO> schedules=new ArrayList<>();
		for(int i=9; i<=21; i++)
			schedules.addAll(scheduleDao.findSchedulesByHourAndDateAndTrainerId(Integer.toString(i), afterTwoWeeks.toString(), afterTwoWeeks.plusDays(7).toString(), trainer_id));
		
		return schedules;
	}

	@Override
	public void cancleSchedule(String member_id, String day, String hour) {
		LocalDate currentDate = LocalDate.now();  
		int curday=currentDate.getDayOfWeek();

		LocalDate afterTwoWeeks= currentDate.plusDays(15-curday+Integer.parseInt(day));

		scheduleDao.cancleSchedule(member_id, afterTwoWeeks.toString(), hour);
	}

}
