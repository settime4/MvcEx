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
@SessionAttributes("member") // �𵨿� �Ǹ��� ���� ���ǿ��� �ڵ����� �Ǹ���.
public class MemberController5 {
	
	@RequestMapping(value="/beforeSession", method=RequestMethod.GET)
	public String beforeSession(){
		return "ex05/result";
	}
	@RequestMapping(value="/afterSession", method=RequestMethod.GET)
	public String afterSession(Model model){
		Member member = new Member();
		member.setId("dd");
		model.addAttribute("member", member); // beforeSession ���� ���� �����Ͱ� ���� ������, �ѹ��̶� afterSession�� �ڿ� beforeSession ���� �����Ͱ� ���
		return "ex05/result";
	}
	@RequestMapping(value="removeSession", method=RequestMethod.GET)
	public String removeSession(SessionStatus sessionStatus){
		sessionStatus.setComplete();
		return "ex05/result";
	}
}
