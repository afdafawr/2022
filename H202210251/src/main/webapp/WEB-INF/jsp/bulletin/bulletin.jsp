<%@page import="co.edu.board.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- bulletin/bulletin.tiles -->
<%
	List<BoardVO> list = (List<BoardVO>)request.getAttribute("bList");
%>
<h3>게시판 페이지입니다.</h3>
	<table border='1'>
	<tr>
	<th>글번호</th>
	<th>글제목</th>
	<th>글내용</th>
	<th>글쓴날짜</th>
	</tr>
<%
	for(BoardVO vo : list){
%>
	<tr>
	<td><a href="searchBoard.do?bno=<%=vo.getBoardNo() %>"><%=vo.getBoardNo() %></a></td>
	<td><%=vo.getTitle() %></td>
	<td><%=vo.getContent() %></td>
	<td><%=vo.getWriteDate() %></td>
	</tr>
<%		
	}
%>
</table>