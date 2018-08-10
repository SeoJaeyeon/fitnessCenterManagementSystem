package kr.ac.fcm.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import kr.ac.fcm.user.Member;

@Mapper
public interface MemberMapper {

	@Select("SELECT * FROM Member WHERE id= #{id} and password=#{password}")
	Member findMemberByMemberId(@Param("id")String id,@Param("password")String password);

	@Insert("INSERT INTO MEMBER VALUES(#{member.id},#{member.name}, #{member.center_id}, #{member.gender}, #{member.pt}, #{member.phone_number})")
	void insertMember(@Param("member") Member member);
}
