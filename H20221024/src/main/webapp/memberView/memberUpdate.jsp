<%@page import="co.edu.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h3>회원조회</h3>	
	<form action ="./memberSearch.do" method="post">
		<input type="hidden" name = "job" value = "update">
		ID: <input type="text" name = "id" ><br>
		<input type="submit" value = "조회">
	</form>
	
	<h3>회원정보 수정</h3>
	<%
		MemberVO result = (MemberVO)request.getAttribute("memberInfo");
		String id = (String) session.getAttribute("id");
	%>
	<% if (result != null ) { %>
	<form action="./memberModify.do" method = "post">
		ID: <input type = "text" name = "id" value = "<%=result.getId() %>" readonly><br>
		PW: <input type = "password" name = "password" value = "<%=result.getPasswd() %>"><br>
		Name: <input type = "text" name = "name" value = "<%=result.getName() %>"><br>
		Email: <input type = "email" name = "email" value = "<%= result.getEmail()%>"><br>
		<p><%=result.getId() %></p>
		<p><%=id %></p>
		<%if(id.equals(result.getId())) {%>
		<input type ="submit" value="수정">
		<%} %>
	</form>
	<%} else { %>
		<p>조회된 결과가 없습니다</p>
	<%} %>
	
</body>
</html>