package com.project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//����bean������е�mvcҳ����ת
public class HelloContoller implements Controller {
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ModelAndView model =new ModelAndView();
		model.addObject("msg", "hello world");
		model.setViewName("hello");
		return model;
	}

}
