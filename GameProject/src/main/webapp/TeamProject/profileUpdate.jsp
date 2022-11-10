<%@page import="project.dao.ProfileDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//입력칸의 내용을 받아와서 업데이트 시키고, 프로필로 이동
	request.setCharacterEncoding("utf-8");
	String uname = request.getParameter("Ncontent");
	String infor = request.getParameter("Infocontent");
	String email = (String) session.getAttribute("email");

	ProfileDao dao = new ProfileDao();
	dao.profileUpdate(uname, infor, email);
	
	response.sendRedirect("profile.jsp");
%>