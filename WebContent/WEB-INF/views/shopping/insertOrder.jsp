<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.error {
	color: red;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>


	<form action="/insertOrder" method="post">
		<fieldset>
			<table>
				<tr>
					<th>ȸ��ID</th>
					<td><input type="text" name="customer_id"></td>
				</tr>
				<tr>
					<th>�ֹ���¥</th>
					<td><input type="text" name="order_date"></td>
				</tr>
			</table>
		</fieldset>
		
		<fieldset>
			<table>
				<tr>
					<th>üũ</th>
					<th>�̸�</th>
					<th>����</th>
					<th>����</th>
				</tr>
				
				<c:forEach var="product" items="${products }">
				
					<tr>
						<Td><input type="checkbox" name="product_check"></Td>
						<td>${product.name }</td>
						<Td>${product.price }</Td>
						<td>${product.description }</td>
						<td><input type="text" name="amount"></td>
					</tr>
				</c:forEach>
			</table>
		</fieldset>
		<input type="submit" value="����">
	</form>


</body>
</html>