<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="student.Student" %>

<%

	Student student = Student.builder()
				.schoolName(request.getParameter("school-name"))
				.name(request.getParameter("name"))
				.studentYear(Integer.parseInt(request.getParameter("student-year"))) //int를 따로 적용해야 된다.
				.department(request.getParameter("department"))
				.grade(request.getParameter("grade"))
				.build();
	
	request.setAttribute("student", student);
%>
<jsp:forward page="../view/student_info_show.jsp"></jsp:forward>

