<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> index pages</h1>
<p>${msg}</p>
<a href="./addUsers?id=1000&userName=add">to add users</a>
<a href="./deleteUsers?id=1001&userName=delete">to delete users</a>
<a href="./saveUsers?id=1001&userName=save&password=12345">to save users</a>
</body>
