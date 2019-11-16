package com.project.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.entity.saveUsersParam;

//返回json格式主要是引入 jackson 或者 fastjson  还有就是加入 @ResponseBody注解
//<dependency>
//  <groupId>com.fasterxml.jackson.core</groupId>
//  <artifactId>jackson-databind</artifactId>
//  <version>2.9.8</version>
//</dependency>

@Controller
@RequestMapping("/json")
public class JsonInfoController {
	@RequestMapping("/mapJsonInfo")
	@ResponseBody
	public Map<String, Object> mapJsonInfo() {
		Map<String, Object> map = new HashMap();
		map.put("userName", "000admin");
		map.put("userNum", "admin");
		map.put("gender", "boy");
		return map;
	}
	@RequestMapping("/entityJosn")
	@ResponseBody
	public saveUsersParam entityJosn() {
		saveUsersParam entity = new saveUsersParam();
		entity.setAge("28");
		entity.setId(1231313);
		entity.setPassword("1234654abbcd");
		entity.setUserName("000admin");
		return entity;
	}
}
