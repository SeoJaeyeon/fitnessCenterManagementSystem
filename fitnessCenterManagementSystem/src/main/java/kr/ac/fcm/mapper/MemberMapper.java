package kr.ac.fcm.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import kr.ac.fcm.DTO.user.MemberDTO;

@Mapper
public interface MemberMapper {

	@Select("SELECT * FROM Member WHERE id= #{id}")
	MemberDTO findMemberByMemberId(@Param("id")String id);

	@Insert("INSERT INTO MEMBER VALUES(#{member.id},#{member.name}, #{member.center_id}, #{member.gender}, #{member.pt}, #{member.phone_number})")
	void insertMember(@Param("member") MemberDTO member);
}
