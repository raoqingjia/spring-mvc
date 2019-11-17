package com.project.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

import com.project.entity.saveUsersParam;

@Controller
@RequestMapping(value="/pages")

public class PagesController {
	
	@RequestMapping(value= {"/login"},method= {RequestMethod.GET})
	public String Login() {
		System.out.println("���� - login page");
		return "login";
	}
	
	// ����ModelAndView����ҳ��    
	// @RequestMapping �е�value method���������ö��
	@RequestMapping(value= {"/index","/indexPage"},method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView indexPage(String id) throws Exception {
		if(id==null) {
			throw new RuntimeException("RuntimeException - indexҳ������id����Ϊ�գ�");
		}
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		model.addObject("msg", "hello index");
		return model;
	}
	// �����ַ�������ҳ�棬Model��ȡҳ����Ϣ
	@RequestMapping(value="/addUsers",method=RequestMethod.GET)
	public String addUsersPage(Model model,HttpServletRequest request) {
		String id=request.getParameter("id");
		String userName=request.getParameter("id");
		model.addAttribute("id", id);
		model.addAttribute("userName", userName);
		return "addUsers";   // ���ַ����ύ����ͼ���������н���
	}
	
	// @RequestParam(value="id",name="tid",required=true) 
	// required����������ԣ��Ƿ����
	// name  �������γ���������Ʋ�һ��ʱ�����ý��ܲ�������
	@RequestMapping(value="/deleteUsers",method=RequestMethod.GET)
	public String deleteUsersPage(Model model,@RequestParam(value="id",required=true) Integer id, String userName) {
		model.addAttribute("id", id);
		model.addAttribute("userName", userName);
		System.out.println("id:"+id);
		System.out.println("userName:"+userName);
		return "deleteUsers";   // ���ַ����ύ����ͼ���������н���
	}
	
	
	
//	������url�в�������ʱ���Դ���һ��javabean�����������������
//	�ʣ������еĲ�����Ϣ����η�װ��entity�����еģ�
//	1�������޲ҹ��캯������entity����
//	2������entity�����е�set������set���ʺ�������ֱ������������һֱ��
	@RequestMapping(value="/saveUsers",method=RequestMethod.GET)
	public String saveUsersPage(Model model,saveUsersParam param) {
		model.addAttribute("param", param);
		System.out.println("param:"+param);
		return "saveUsers";   // ���ַ����ύ����ͼ���������н���
	}
	
	
	
	// rest ����·�����    
	// @PathVariable���ڽ�����URL�е�ģ�����ӳ�䵽���ܴ������Ĳ�����
	// param�ʹ��� param?id=1234 ��  ����Parma�������ԣ���ͷ
	// xxx  param ����ռλ��
	@RequestMapping(value="/{xxx}/deleteUsers/{param}",method=RequestMethod.GET)
	public String findUsersPage(Model model,@PathVariable String param) {
		model.addAttribute("msg", param);
		System.out.println("param:"+param);
		return "findUsers";   // ���ַ����ύ����ͼ���������н���
	}
	
	//  handlerExcpetion���Ҷ�����ڲ��쳣��
	// ����������쳣��spring�����ڵ�ǰ����Ѱ���Ƿ���@ExceptionHandler�Ĵ��ڣ��������������쳣����
	// value= Exception.class ��ʾ��ǰ�쳣������
	// ���ص��Ǹ������Ǹ�ҳ�����@ResponseBody
	@ExceptionHandler(value= Exception.class)
	@ResponseBody
	public Map<String, Object> handlerExcpetion(Exception e) {
	    Map<String,Object> map=new HashMap();
	    map.put("error", e.getMessage());
		return map;
	}
	
}
