<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h5>주문 아이템 product List</h5>
	<table bordercolor="blue" border="1">
		<tr>
			<th>Product Name</th>
			<th>product Price</th>
			<th>amount</th>
		</tr>
		<tr>
			<td>${oip.product.name }</td>
			<td>${oip.product.price }</td>
			<Td>${oip.amount}</Td>
		<tr>
	</table>

</body>
</html>