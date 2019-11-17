package com.project.intercept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

// ���������� ʵ��HandlerInterceptor�ӿ���
// preHandle  postHandle  afterCompletion ����ʱfalse��ʾ���أ�����true��ʾ�ſ�
public class PageIntercept implements HandlerInterceptor {

	//  �������ٻ�δ����controller��
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("session="+request.getSession());
		System.out.println("���󵽴�preHandle");
		request.getSession();
		return true;
	}
   //  ����δ����controller��return���ִ�У�����ҳ�滹û��Ⱦ
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("���󵽴�postHandle");

	}
	 //  ����δ����controller��return��ɣ�ҳ��Ҳ��Ⱦ��ִ��
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("���󵽴�afterCompletion");

	}

}
