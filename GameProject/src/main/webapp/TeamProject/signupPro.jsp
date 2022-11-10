<%@page import="project.dto.SignUpDto"%>
<%@page import="project.dao.SignUpDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//회원정보를 insert시키기
	request.setCharacterEncoding("utf-8");

	String email = request.getParameter("email");
	String uname = request.getParameter("uname");
	String pwd = request.getParameter("pwd");
	
	SignUpDao dao = new SignUpDao();
	SignUpDto dto = new SignUpDto(email, uname, pwd);
	dao.insert(dto);
	
	response.sendRedirect("login.jsp?email="+ email);
%>