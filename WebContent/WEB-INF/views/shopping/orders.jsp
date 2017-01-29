<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h5>Orders List</h5>
	<table bordercolor="blue" border="1">
		<tr>
			<th>Order no</th>
			<th>Order date</th>
			<th>Customer name</th>
		</tr>
		<tr>
			<td>${order.id }</td>
			<td>${order.order_date }</td>
			<Td>${order.customer.name}</Td>
		<tr>
		<tr>
			<th>product name</th>
			<th>product price</th>
			<th>amount</th>
		</tr>
		<c:forEach var="orderItem" items="${order.items}">
		<tr>
			<td>${orderItem.product.name }</td>
			<td>${orderItem.product.price }</td>
			<Td>${orderItem.amount}</Td>
		</tr>
		</c:forEach>
	</table>

</body>
</html>