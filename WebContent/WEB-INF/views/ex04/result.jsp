<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table>
		<Tr>
			<th>아이디</th>	
			<td>${member.id}</td>
		</tr>
		<tr>
			<th>패스워드</th>
			<td>${member.password }</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>${member.email }</td>
		</tr>
	</table>
</body>
</html>