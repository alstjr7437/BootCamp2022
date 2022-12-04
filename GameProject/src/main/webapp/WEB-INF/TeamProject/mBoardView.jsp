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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
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
            <div class="container justify-content-center border-left border-right">
                <div class="d-flex justify-content-center py-2">
                    <div class="second py-2 px-2"> <span class="text1"><%=dto.getCotag() %></span>
                        <div class="d-flex justify-content-between py-1 pt-2">
                            <div><img src="resources/css/image/unknownAvatar.jpg" width="18"><span class="text2"><%=dto.getCobcode() %></span><span class="tdate"><%=dto.getCdate() %></span></div>
                            <div><span class="text3"><button class="mod">수정</button></span><span class="thumbup"><i class="fa fa-thumbs-o-up"></i></span><span class="text4"><button class="del">삭제</button></span></div>
                        </div>
                    </div>
                </div>
            </div>
           <% } %>
               
               <br><br>

               <hr class="st4"><br>
               <!-- 댓글 추가를 위한 form -->
               <form class="validation-form" novalidate action="CInsert.cmt">
               
                   <div id="wtComment">
                        <h3 id="nmSp"><span><%=email%></span></h3>
                        <textarea name="cotag" id="cotag" cols="128" rows="8"></textarea>
                        <button type="submit" id="btnsub">등록</button>
                   </div>
            </form>
           </div>
       </section>
</body>
</html>