package kr.ac.fcm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.ac.fcm.DTO.user.TrainerDTO;

@Mapper
public interface TrainerMapper {

	@Select("SELECT * FROM Trainer WHERE id= #{id}")
	TrainerDTO findTrainerByTrainerId(@Param("id")String id);
	@Insert("INSERT INTO TRAINER VALUE(#{trainer.id},#{trainer.name},#{trainer.center_id},#{trainer.birthdate},#{trainer.gender},#{trainer.closed_day},#{trainer.phone_number})")
	void insertTrainer(@Param("trainer")TrainerDTO trainer);	
	@Update("UPDATE TRAINER SET phone_number=#{trainer.phone_number}, closed_day=#{trainer.closed_day} where id=#{trainer.id}")
	void updateTrainer(@Param("trainer") TrainerDTO trainer);
	@Select("SELECT id, name FROM TRAINER WHERE CENTER_ID=#{center_id}")
	List<TrainerDTO> selectAllTrainerByCenter_id(String center_id);
	
}
