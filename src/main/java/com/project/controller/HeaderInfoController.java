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
	// ����@RequestHeaderע�ⷵ��ͷ����Ϣ  , HttpSession����session
	@RequestMapping("/requsetHeader")
	public ModelAndView doRequsetHeader(@RequestHeader String accept,HttpSession session) {
		session.setAttribute("userName", "����HttpSession");
		ModelAndView model=new ModelAndView();
		model.setViewName("requsetHeader");
		model.addObject("msg", accept);
		return model;
	}
	
	// ����HttpEntity���ͷ�������ͷ��Ϣ
	@RequestMapping("/httpEntity")
	public String httpEntity(Model model,HttpEntity<String> accept,@CookieValue String JSESSIONID,HttpSession session) {
		System.out.println("��ȡ�����õ�session:"+session.getAttribute("userName"));
		model.addAttribute("httpInfo", accept);
		model.addAttribute("cook", JSESSIONID);
		return "httpEntity";
	}
	
	
	// HttpServletResponse ��������ͷ
	@RequestMapping("/HttpServletResponse")
	@ResponseBody
	public String doHttpServletResponse(HttpServletResponse response) {
		//����״̬��
 		response.setStatus(500);
		//��Ӧͷ���������÷�����һ����addxxx()��������һ����setxxx()������
		//addxxx()������������ԣ����Ḳ��ԭ�������ԡ�setxxx()�Ḳ�ǵ�ԭ�������ԡ�
		response.setHeader("content-type","text/html;charset=utf-8");
		// �Զ���ת5����Զ���ת���ٶ�
		response.setHeader("Refresh","5; URL=http://www.baidu.com");
		return "HttpServletResponse";
	}
	
}
