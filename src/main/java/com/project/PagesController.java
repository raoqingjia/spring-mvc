package com.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/pages",method=RequestMethod.GET)
public class PagesController {
	// ����ModelAndView����ҳ��
	@RequestMapping("/index")
	public ModelAndView indexPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		model.addObject("msg", "hello index");
		return model;
	}
	// �����ַ�������ҳ�棬Model��ȡҳ����Ϣ
	@RequestMapping(value="/addUsers",method=RequestMethod.GET)
	public String addUsersPage(Model model,String id) {
		model.addAttribute("msg", id);
		System.out.print(model);
		return "addUsers";   // ���ַ����ύ����ͼ���������н���
	}
}
