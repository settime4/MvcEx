package aab.user;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

public interface UserMapper {
	
	@Select("select no, id, password from users where id=#{id}")
	@SelectKey(statement="select users_seq.nextval from dual", keyProperty="no", before=true, resultType=long.class)
	public User findById(String id);
}
