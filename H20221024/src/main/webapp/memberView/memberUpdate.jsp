<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>회원정보 수정</h3>
	<form action="./memberModify.do" method = "post">
		ID: <input type = "text" name = "id"><br>
		PW: <input type = "password" name = "password"><br>
		Name: <input type = "text" name = "name"><br>
		Email: <input type = "email" name = "email"><br>
		<input type ="submit" value="수정">
	</form>
</body>
</html>