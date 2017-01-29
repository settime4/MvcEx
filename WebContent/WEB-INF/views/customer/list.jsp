<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<a href="/MvcEx/customer/insert">customer����</a><br>
		<form action="searchName" method="post">
			<input type="text" name="name"><input type="submit" value="�˻�">
		</form>
	</div>
	<table align="center">
		<tr>
			<th>���̵�</th>
			<th>�̸�</th>
			<th>�̸���</th>
			<th>�ּ�</th>
			<th>����</th>
			<th>����</th>
		</tr>
		<c:forEach var="customer" items="${ customers}">
			<tr>
				<td>${customer.id }</td>
				<td>${customer.name }</td>
				<td>${customer.email }</td>
				<td>${customer.address }</td>
				<td><a href="update/${customer.id }">����</a></td>
				<td><a href="/MvcEx/customer/delete/${customer.id }">����</a></td>
			</tr>
		</c:forEach>

	</table>
	<Br>
	<div align="center">
		<c:if test="${paging.pageNumber > paging.pageCount }">
			<a href="page?pageNumber=1">��ó��</a>&nbsp;<a href="page?pageNumber=${paging.beginPage -1 }">����</a>
		</c:if>
		<c:forEach var="pageNumber" begin="${paging.beginPage }" end="${paging.endPage }" step="1">
			<a href="page?pageNumber=${pageNumber}">${pageNumber }</a>
		</c:forEach>
		<c:if test="${paging.pageNumber < paging.getLastPageSet()}">
			<a href="page?pageNumber=${paging.endPage+1 }">����</a>&nbsp;<a href="page?pageNumber=${paging.totalPage }">�ǳ�</a>
		</c:if>
	</div>



</body>
</html>