package spring.handler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.model.Member;

@Controller
public class MemberController4 {
	
	@RequestMapping(value="/ex04/input")
	public String inputMember(Member member){
		return "ex04/input";
	}
	
/*	@RequestMapping(value="/ex04/input", method=RequestMethod.POST)
	public String resultMember(@RequestParam String id, @RequestParam String email, @RequestParam("password") String pw, Model model){
		User m = new User();
		m.setId(id);
		m.setEmail(email);
		m.setPassword(pw);
		model.addAttribute("msg", 5);
		model.addAttribute("member", m);
		return "ex04/result";
	}*/
	
	@RequestMapping(value="/ex04/input", method=RequestMethod.POST) // input.jsp 로 간다. void 와 User(Model) 형식이니까
	public Member resultMember(){
		Member m = new Member();
		m.setId("22");
		m.setEmail("22");
		m.setPassword("20");
		return m;
	}
	
}
