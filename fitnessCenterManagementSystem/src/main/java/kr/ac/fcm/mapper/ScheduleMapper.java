package kr.ac.fcm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import kr.ac.fcm.DTO.ScheduleDTO;

@Mapper
public interface ScheduleMapper {

	@Select("SELECT mem.name as member_name, tr.name as trainer_name, sc.hour, sc.day FROM SCHEDULES as sc, MEMBER as mem, TRAINER as tr "
			+ "WHERE mem.id=#{mem_id} and mem.id=sc.member_id and tr.id=sc.trainer_id and YEARWEEK(date) = YEARWEEK(now()) order by day asc")
	public List<ScheduleDTO> selectThisWeekSchedulesByMemberId(@Param("mem_id") String member_id);
	
	@Select("SELECT mem.name as member_name, tr.name as trainer_name, sc.hour, sc.day FROM SCHEDULES as sc, MEMBER as mem, TRAINER as tr "
			+ "WHERE tr.id=#{trainer_id} and mem.id=sc.member_id and tr.id=sc.trainer_id and YEARWEEK(date) = YEARWEEK(now()) order by day asc")
	public List<ScheduleDTO> selectThisWeekSchedulesByTrainerId(@Param("trainer_id") String trainer_id);
	
	
}
