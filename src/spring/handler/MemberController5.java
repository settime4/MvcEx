package spring.handler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import spring.model.Member;

@Controller
@RequestMapping("/ex05/*")
@SessionAttributes("member") // 모델에 실리는 순간 세션에도 자동으로 실린다.
public class MemberController5 {
	
	@RequestMapping(value="/beforeSession", method=RequestMethod.GET)
	public String beforeSession(){
		return "ex05/result";
	}
	@RequestMapping(value="/afterSession", method=RequestMethod.GET)
	public String afterSession(Model model){
		Member member = new Member();
		member.setId("dd");
		model.addAttribute("member", member); // beforeSession 먼저 들어가면 데이터가 뜨지 않지만, 한번이라도 afterSession들어간 뒤에 beforeSession 들어가면 데이터가 뜬다
		return "ex05/result";
	}
	@RequestMapping(value="removeSession", method=RequestMethod.GET)
	public String removeSession(SessionStatus sessionStatus){
		sessionStatus.setComplete();
		return "ex05/result";
	}
}
