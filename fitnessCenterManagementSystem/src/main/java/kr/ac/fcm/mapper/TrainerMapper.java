package kr.ac.fcm.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.ac.fcm.user.Trainer;

@Mapper
public interface TrainerMapper {

	@Select("SELECT * FROM Trainer WHERE id= #{id}")
	Trainer findTrainerByTrainerId(@Param("id")String id);
	
	/*id           | varchar(15) | NO   | PRI | NULL    |       |
	| name         | varchar(5)  | YES  |     | NULL    |       |
	| center_id    | varchar(10) | YES  | MUL | NULL    |       |
	| birthdate    | date        | YES  |     | NULL    |       |
	| gender       | varchar(1)  | YES  |     | NULL    |       |
	| closed_day   | varchar(1)  | YES  |     | NULL    |       |
	| phone_number*/
	@Insert("INSERT INTO TRAINER VALUE(#{trainer.id},#{trainer.name},#{trainer.center_id},#{trainer.birthdate},#{trainer.gender},#{trainer.closed_day},#{trainer.phone_number})")
	void insertTrainer(@Param("trainer")Trainer trainer);
	
	@Update("UPDATE TRAINER SET phone_number=#{trainer.phone_number}, closed_day=#{trainer.closed_day} where id=#{trainer.id}")
	void updateTrainer(@Param("trainer") Trainer trainer);
}
