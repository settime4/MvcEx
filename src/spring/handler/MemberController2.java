package spring.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.model.Member;

@Controller
@RequestMapping("/ex02/*")
public class MemberController2 {

	@ModelAttribute("memberModel")
	// ModelAttribute������̼��� �Ķ���� �ܿ��� �޼ҵ� ������ �ŰܿԴ�.
	public Member getMember() {
		Member m = new Member();
		m.setId("d");
		m.setEmail("ss");
		m.setPassword("s");
		return m;
	}

	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public String resultMember() {
		return "ex02/result";
	}


}
