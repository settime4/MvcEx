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
			<th>���̵�</th>
			<td>${customer.id }</td>
		</tr>
		<tr>
			<th>�̸�</th>
			<td>${customer.name }</td>
		</tr>
		<tr>
			<th>�̸���</th>
			<td>${customer.email }</td>
		</tr>
		<tr>
			<th>�ּ�</th>
			<td>${customer.address }</td>
		</tr>
	</table>

</body>
</html>