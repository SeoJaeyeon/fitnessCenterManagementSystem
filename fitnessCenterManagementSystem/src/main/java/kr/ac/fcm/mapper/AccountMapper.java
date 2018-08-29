
package kr.ac.fcm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.ac.fcm.DTO.user.Account;


@Mapper
public interface AccountMapper {
	
	@Select("SELECT * FROM USER WHERE id=#{id}")
	public Account readAccount(String id);
	
	@Select("SELECT authority_name FROM AUTHORITY WHERE username=#{id}")
	public List<String> readAutorities(String id);
	
	@Insert("INSERT INTO USER VALUES(#{account.id},#{account.password},#{account.isAccountNonExpired},#{account.isAccountNonLocked},#{account.isCredentialsNonExpired},#{account.isEnabled},#{account.type},#{account.center_id})")
	public void insertUser(@Param("account") Account account);
	
	@Insert("INSERT INTO AUTHORITY VALUES(#{id},#{autority})")
	public void insertUserAutority(@Param("id") String id,@Param("autority")String autority);
	
	@Select("SELECT* FROM USER")
	public List<Account> readAllUsers();
	
	@Update("UPDATE USER SET password=#{password} WHERE id=#{id}")
	public void updatePassword(@Param("id") String id, @Param("password")String password);
	
	@Delete("DELETE FROM AUTHORITY WHERE username=#{id}")
	public void deleteAuthorities(String id);
	
	@Delete("DELETE FROM USER WHERE id=#{id}")
	public void deleteAccount(String id);

}
