package com.project.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/header")
public class HeaderInfoController {
	// 利用@RequestHeader注解返回头部信息  , HttpSession设置session
	@RequestMapping("/requsetHeader")
	public ModelAndView doRequsetHeader(@RequestHeader String accept,HttpSession session) {
		session.setAttribute("userName", "测试HttpSession");
		ModelAndView model=new ModelAndView();
		model.setViewName("requsetHeader");
		model.addObject("msg", accept);
		return model;
	}
	
	// 利用HttpEntity类型返回请求头信息
	@RequestMapping("/httpEntity")
	public String httpEntity(Model model,HttpEntity<String> accept,@CookieValue String JSESSIONID,HttpSession session) {
		System.out.println("获取我设置的session:"+session.getAttribute("userName"));
		model.addAttribute("httpInfo", accept);
		model.addAttribute("cook", JSESSIONID);
		return "httpEntity";
	}
	
	
	// HttpServletResponse 设置请求头
	@RequestMapping("/HttpServletResponse")
	@ResponseBody
	public String doHttpServletResponse(HttpServletResponse response) {
		//设置状态码
 		response.setStatus(500);
		//响应头有两类设置方法，一类是addxxx()方法，另一类是setxxx()方法，
		//addxxx()方法会添加属性，不会覆盖原来的属性。setxxx()会覆盖掉原来的属性。
		response.setHeader("content-type","text/html;charset=utf-8");
		// 自动跳转5秒后自动跳转到百度
		response.setHeader("Refresh","5; URL=http://www.baidu.com");
		return "HttpServletResponse";
	}
	
}
