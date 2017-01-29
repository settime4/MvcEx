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
	public String createMember(@ModelAttribute Member member) { //@ModelAttribute("m") member�� m���� attribute�����Ѵ�. ��� ��ü ������ ������ش�.
		System.out.println("�Ծ�");

		return "/ex01/member";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String memberView(@Valid Member member, BindingResult bindingresult) { //��ȿ�� �˻�
		if (bindingresult.hasErrors()) {
			return "/ex01/member";
		}
		return "/ex01/memberView";
	}
}
