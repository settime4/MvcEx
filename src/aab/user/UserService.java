package aab.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired UserRepository userRepository;
	
	public boolean checkLoginInfo(Login login){
		User user = userRepository.findById(login.getId());
		if( user != null){
			if( user.getId().equals( login.getId() ) && user.getPassword().equals( login.getPassword()) ){
				return true;
			}else{
				return false;
			}			
		}
		return false;
	}
}
