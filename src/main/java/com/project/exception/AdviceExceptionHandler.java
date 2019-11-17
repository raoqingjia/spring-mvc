package com.project.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

// @ControllerAdvice用来配置全局的异常处理
@ControllerAdvice
public class AdviceExceptionHandler {
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Map<String, Object> doExceptionHnadelr(Exception e) {
		System.out.print("doExceptionHnadelr");
		Map<String, Object> map = new HashMap();
		map.put("error", e.getMessage());
		return map;
	}

	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public Map<String, Object> doRunTimeException(RuntimeException e) {
		System.out.print("doRunTimeException");
		Map<String, Object> map = new HashMap();
		map.put("error", e.getMessage());
		return map;
	}
}
