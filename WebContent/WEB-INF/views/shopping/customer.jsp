<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h5>customer List</h5>
	<table bordercolor="blue" border="1">
		<tr>
			<th>name</th>
			<th>address</th>
			<th>email</th>
		</tr>

		<c:forEach var="customer" items="${customers}">
		<tr>
			<td>${customer.name }</td>
			<td>${customer.address}</td>
			<Td>${customer.email}</Td>
		</tr>
		</c:forEach>
	</table>

</body>
</html>