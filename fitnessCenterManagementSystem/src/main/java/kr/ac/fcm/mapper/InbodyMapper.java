package kr.ac.fcm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import kr.ac.fcm.DTO.InbodyDTO;

@Mapper
public interface InbodyMapper {
	
	@Select("select* from (select* from inbody where member_id=#{member_id} order by record desc limit 5) as f order by record asc")
	public List<InbodyDTO> selectFromInbodyByMemberId(@Param("member_id")String member_id);
	
	@Insert("INSERT INTO INBODY VALUES(#{inbody.member_id},#{inbody.weight}, #{inbody.fat},#{inbody.muscle},#{inbody.record})")
	public void insertInbody(@Param("inbody") InbodyDTO inbody);
}
