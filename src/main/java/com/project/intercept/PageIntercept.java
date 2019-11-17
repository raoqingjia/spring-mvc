package com.project.intercept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

// 请求连接器 实现HandlerInterceptor接口类
// preHandle  postHandle  afterCompletion 返回时false表示拦截，返回true表示放开
public class PageIntercept implements HandlerInterceptor {

	//  请求来临还未到达controller器
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("session="+request.getSession());
		System.out.println("请求到达preHandle");
		request.getSession();
		return true;
	}
   //  请求未到达controller器return完成执行，但是页面还没渲染
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("请求到达postHandle");

	}
	 //  请求未到达controller器return完成，页面也渲染完执行
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("请求到达afterCompletion");

	}

}
