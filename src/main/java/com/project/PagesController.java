package com.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/pages",method=RequestMethod.GET)
public class PagesController {
	// 利用ModelAndView返回页面
	@RequestMapping("/index")
	public ModelAndView indexPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		model.addObject("msg", "hello index");
		return model;
	}
	// 利用字符串返回页面，Model代取页面信息
	@RequestMapping(value="/addUsers",method=RequestMethod.GET)
	public String addUsersPage(Model model,String id) {
		model.addAttribute("msg", id);
		System.out.print(model);
		return "addUsers";   // 次字符串会交给视图解析器进行解析
	}
}
