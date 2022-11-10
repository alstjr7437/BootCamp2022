<%@page import="project.dao.CartDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//결제 처리. 해당 유저의 장바구니를 비워줌
	request.setCharacterEncoding("utf-8");

	CartDao dao = new CartDao();
	String smail = (String) session.getAttribute("email");
	dao.payClearCart(smail);
	
	response.sendRedirect("MainPage.jsp");
%>