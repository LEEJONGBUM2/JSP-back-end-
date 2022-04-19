<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	String name = "이종범";
	String phone = "010-5133-4268";
	String email = "cjdrh2@naver.com";

	public void show(){
		System.out.println(name);
		System.out.println(phone);
		System.out.println(email);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=name %></title>
</head>
<body>
	<%
		for(int i = 0; i < 5; i++){
			//show();
	%>	
		<p><%=name %></p> <!-- 자바소스코드가 아니다. -->
	<%
		}
	%>
	<h1>hello JSP</h1> <!-- ctrl+f11 -->
</body>
</html>