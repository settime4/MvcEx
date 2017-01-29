package spring.handler;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.model.Member;

@Controller
@RequestMapping("/ex01/*")
public class MemberController {
	
	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String createMember(@ModelAttribute Member member) { //@ModelAttribute("m") member를 m으로 attribute저장한다. 멤버 객체 없으면 만들어준다.
		System.out.println("왔어");

		return "/ex01/member";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String memberView(@Valid Member member, BindingResult bindingresult) { //유효성 검사
		if (bindingresult.hasErrors()) {
			return "/ex01/member";
		}
		return "/ex01/memberView";
	}
}
