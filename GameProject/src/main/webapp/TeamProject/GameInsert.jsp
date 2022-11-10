<%@page import="project.dto.CartDto"%>
<%@page import="project.dto.SearchDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="project.dao.CartDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//게임 정보를 받아와서 중복으로 담았는지 if 조건문으로 검사하고 중복이 아니면 Main으로 중복이면 다시 이전페이지로 이동
	request.setCharacterEncoding("utf-8");

	String gname = request.getParameter("gname");
	String email = (String)session.getAttribute("email");
	
	CartDao dao = new CartDao();
	ArrayList<SearchDto> dtos = dao.SelectGame(gname);
	
	for(SearchDto dto : dtos) {
			int check = dao.checkUnique(dto.getGnum());
			if(check == 0) {
			CartDto cdto = new CartDto(dto.getGprice(), dto.getGnum(), email);
			dao.insert(cdto);
			response.sendRedirect("MainPage.jsp");
			} else {
%>
			<script>
			alert("이미 장바구니에 담긴 게임입니다.");
			history.back();
			</script>
<%
			}
	}
	
%>