<%@page import="repository.user.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	User principalUser = (User)session.getAttribute("principal");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link rel="stylesheet" href="/JspStudy_4268/static/css/mypage.css">
</head>
<body>
	<div id="container">
		<div class="mypage-items">
			<form action="">
				<table>
					<tr>
						<td>이전 비밀번호 확인</td>
						<td><input type="password" class="item-input" name="origin-password"></td>
					</tr>
					<tr>
						<td>새 비밀번호</td>
						<td><input type="password" class="item-input" name="new-password""></td>
					</tr>
					<tr>
						<td>새 비밀번호 확인</td>
						<td><input type="password" class="item-input" name="new-repassword"></td>
					</tr>
					
				</table>
				<div>
					<button type="button" class="password-update-btn">회원 정보 수정</button>
					<button type="button" class="profile-update-btn">비밀번호 변경</button>
				</div>
			</form>
		</div>
	</div>	
	<input type="hidden" class="origin-password" value="<%=principalUser.getPassword() %>">
	<script type="text/javascript" src="/JspStudy_4268/static/js/password-update.js"></script>
	
	
</body>
</html>