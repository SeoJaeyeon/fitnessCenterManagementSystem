package kr.ac.fcm.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import kr.ac.fcm.DTO.user.ManagerDTO;


@Mapper
public interface ManagerMapper {
	
	@Select("SELECT * FROM MANAGER WHERE id= #{id}")
	ManagerDTO findManagerByManagerId(@Param("id")String id);
	
	@Insert("INSERT INTO Manager VALUES(#{manager.id},#{manager.name},#{manager.center_id},#{manager.phoneNumber})")
	public void insertManager(@Param("manager") ManagerDTO manager);
	

}
