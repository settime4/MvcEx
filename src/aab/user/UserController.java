package aab.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	
	@Autowired private UserService userService; 
	
	@RequestMapping("login")
	public String toLogin(@ModelAttribute Login login){
		return "login";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String checkLogin(@ModelAttribute Login login, HttpSession session){
		String page = "";
		boolean checkLogin = userService.checkLoginInfo(login);
		if(checkLogin){
			session.setAttribute("loginfo", login.getId());
			page="result";
		}else{
			page = "login";
		}
		return page;
	}
	
	@RequestMapping("private")
	public String toPrivate(){
		return "private";
	}
	
	@RequestMapping("public")
	public String toPublic(){
		return "public";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.removeAttribute("loginfo");
		//session.invalidate(); 둘 중에 하나만
		return "redirect:/";
	}	
}
