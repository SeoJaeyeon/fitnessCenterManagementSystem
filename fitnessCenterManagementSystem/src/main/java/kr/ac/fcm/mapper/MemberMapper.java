package kr.ac.fcm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.ac.fcm.DTO.user.MemberDTO;
import kr.ac.fcm.DTO.user.MemberTrDTO;

@Mapper
public interface MemberMapper {

	@Select("SELECT * FROM Member WHERE id= #{id}")
	MemberDTO findMemberByMemberId(@Param("id")String id);

	@Insert("INSERT INTO MEMBER VALUES(#{member.id},#{member.name}, #{member.center_id}, #{member.gender}, #{member.pt}, #{member.phone_number}, #{member.trainer_id})")
	void insertMember(@Param("member") MemberDTO member);
	
	@Update("UPDATE MEMBER SET phone_number=#{member.phone_number} WHERE id=#{member.id}")
	void reviseMemberData(@Param("member") MemberDTO member);
	//| id      | name      | center_id | gender | pt   | phone_number | trainer_id
	@Select("SELECT member.id, member.name, member.gender, member.pt, member.phone_number, trainer.name as trainer_name  FROM Member as member, Trainer as trainer WHERE member.center_id=#{center_id} and member.trainer_id=trainer.id")
	List<MemberTrDTO> selectAllMembersWithTrainer(String center_id);
	
	@Select("SELECT * FROM MEMBER WHERE center_id=#{center_id}")
	List<MemberTrDTO> selectAllMemberWithNullTrainer(String center_id);
	
	@Update("UPDATE MEMBER SET pt=#{member.pt}, trainer_id=#{member.trainer_id} WHERE id=#{member.id}")
	void updateMemberInfoByManager(@Param("member") MemberDTO member);	
	
	@Delete("DELETE FROM MEMBER WHERE id=#{id}")
	void deleteMember(String id);
}
