package spring.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.model.Member;

@Controller
@RequestMapping("/ex03/*")
public class MemberController3 {

	@ModelAttribute("memberModel")
	public Member getMember() {
		Member m = new Member();
		m.setId("d");
		m.setEmail("ss");
		m.setPassword("s");
		return m;
	}

	@RequestMapping(value = "/result/{no}", method = RequestMethod.GET)
	public String resultMember(@PathVariable String no) { // url 에서 ? 대신에 /으로 void타입으로 return 사라지지만 ㄱ
		return "ex03/result";
	}

}
