<%@page import="java.util.ArrayList"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix ="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>  
<%@page import="board.BoardDto"%>
<%@page import="board.BoardDao"%>
<%@page import="comments.CommentsDto"%>
<%@page import="comments.CommentsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String email = (String)session.getAttribute("email");

	CommentsDao dao = new CommentsDao();
	int mnum = Integer.parseInt(request.getParameter("mnum"));
	ArrayList<CommentsDto> dtos = dao.list(mnum, 2);

	System.out.println(mnum);
	session.setAttribute("mnum", mnum);
    %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resources/css/header.css">
<link rel="stylesheet" href="resources/css/boardForm.css">
<meta charset="UTF-8">
<title>Board View</title>
</head>
<body>
   <div id="header">
     <a href="MainPage.sign"><img src="resources/css/image/Alogo.png" width=70px height=70px></a><h2>| Board</h2>
   </div>
   <h1 class="ins" id="insInfo">${dto.mtitle}</h1>
   <div id="insertForm" class="ins">
        <h2 id="mtag">${dto.mtag}</h2>
        <iframe src = "game/${dto.mfile}" name = "right" width = "1300" height = "500"></iframe>    
        <hr>
        <a download href="game/${dto.mfile}">파일 다운로드</a>
        <h3>작성자 : <span id="mwriter">${dto.mwriter}</span></h3>
        <h3 id="mdate">작성일 : ${dto.mdate} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 조회수 : ${dto.mview} </h3>
        <hr>
      <button onClick="location.href='mBoardUpdate.make?mnum=${dto.mnum}'" class="btn" id="write">수정</button>
      <a href="mBoard.make"><button class="btn" id="cancel">돌아가기</button></a>
   </div>
   			<section>
	        <div class="cobox">
	        	<!-- 댓글수를 위한 변수 가져오기 -->
	            <h2 class="coh3">댓글 </h2>
	            <hr class><br>
	            
	        <!-- 댓글 정보 가져와서 넣어주기 -->
	        <% for(CommentsDto dto : dtos){ %>
	            <div class="codetail">
	               	<span class="cspan"><%=dto.getCobcode() %> </span>
	               	<p class="cp1"><%=dto.getCotag() %></p>
	                <p class="cp2"><%=dto.getCdate() %></p>
	                <div class="cobbox">
	                  	<button>수정</button><button>삭제</button>
	                </div>
	            </div>
	        <% } %>
	            
	            <br><br>

	            <hr class="st4"><br>
	            <!-- 댓글 추가를 위한 form -->
	            <form class="validation-form" novalidate action="mCInsert.cmt">
		          	<div class="cominbox">
		              	<span class="cspan"><%=email %></span>
		                <hr class="st">
		                <textarea name="cotag" id="cotag" cols="128" rows="5"></textarea>
		                <hr class="st">
		                <button id="btnco" type="submit">작성하기</button>
		            </div>
				</form>
	        </div>
	    </section>
</body>
</html>