package aab.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
	@Autowired private UserMapper userMapper;
	
	public User findById(String id){
		return userMapper.findById(id);
	}
}
