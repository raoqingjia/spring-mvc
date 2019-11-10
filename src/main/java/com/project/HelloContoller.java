package com.project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//基于bean对象进行的mvc页面跳转
public class HelloContoller implements Controller {
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ModelAndView model =new ModelAndView();
		model.addObject("msg", "hello world");
		model.setViewName("hello");
		return model;
	}

}
