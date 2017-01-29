<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<sf:form method="post" modelAttribute="login">
		id &nbsp; : <sf:input path="id"/><br>
		pw : <sf:input path="password"/><Br>
		<input type="submit" value="로그인">		
	</sf:form>
</body>
</html>