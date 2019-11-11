package com.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.entity.saveUsersParam;

@Controller
@RequestMapping(value="/pages")
public class PagesController {
	// 利用ModelAndView返回页面    
	// @RequestMapping 中的value method都可以设置多个
	@RequestMapping(value= {"/index","/indexPage"},method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView indexPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		model.addObject("msg", "hello index");
		return model;
	}
	// 利用字符串返回页面，Model代取页面信息
	@RequestMapping(value="/addUsers",method=RequestMethod.GET)
	public String addUsersPage(Model model,HttpServletRequest request) {
		String id=request.getParameter("id");
		String userName=request.getParameter("id");
		model.addAttribute("id", id);
		model.addAttribute("userName", userName);
		return "addUsers";   // 次字符串会交给视图解析器进行解析
	}
	
	// @RequestParam(value="id",name="tid",required=true) 
	// required设置入参属性，是否必填
	// name  当方法形成与入参名称不一致时，设置接受参数别名
	@RequestMapping(value="/deleteUsers",method=RequestMethod.GET)
	public String deleteUsersPage(Model model,@RequestParam(value="id",required=true) Integer id, String userName) {
		model.addAttribute("id", id);
		model.addAttribute("userName", userName);
		System.out.println("id:"+id);
		System.out.println("userName:"+userName);
		return "deleteUsers";   // 次字符串会交给视图解析器进行解析
	}
	
	
	
//	当请求url中参数过多时可以创建一个javabean对象来接受请求入参
//	问：请求中的参数信息是如何封装到entity对象中的？
//	1）基于无惨构造函数构造entity对象
//	2）调用entity对象中的set方法（set单词后面的名字必须与请求参数一直）
	@RequestMapping(value="/saveUsers",method=RequestMethod.GET)
	public String saveUsersPage(Model model,saveUsersParam param) {
		model.addAttribute("param", param);
		System.out.println("param:"+param);
		return "saveUsers";   // 次字符串会交给视图解析器进行解析
	}
	
	
	
	// rest 请求路径风格    
	// @PathVariable用于将请求URL中的模板变量映射到功能处理方法的参数上
	// param就代替 param?id=1234 了  但是Parma不能是以？开头
	// xxx  param 类似占位符
	@RequestMapping(value="/{xxx}/deleteUsers/{param}",method=RequestMethod.GET)
	public String findUsersPage(Model model,@PathVariable String param) {
		model.addAttribute("msg", param);
		System.out.println("param:"+param);
		return "findUsers";   // 次字符串会交给视图解析器进行解析
	}
	
}
