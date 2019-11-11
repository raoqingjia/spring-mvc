package com.project.entity;

import org.springframework.stereotype.Component;
@Component
public class saveUsersParam {
	private Integer id;
	private String UserName;
	private String password;
	private String age;

	public saveUsersParam() {
		super();
		// TODO Auto-generated constructor stub
	}

	public saveUsersParam(Integer id, String userName, String password, String age) {
		super();
		this.id = id;
		UserName = userName;
		this.password = password;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "saveUsersParam [id=" + id + ", UserName=" + UserName + ", password=" + password + ", age=" + age
				+ "]";
	}

}
