<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>아이디</th>
			<td>${product.id }</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${product.name }</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>${product.price }</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>${product.description}</td>
		</tr>
	</table>

</body>
</html>