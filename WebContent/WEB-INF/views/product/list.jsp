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
	<a href="/MvcEx/product/insert">product등록</a><br>
		<form action="searchName" method="post" >
			<input type="text" name="name" ><input type="submit" value="검색">
		</form>
	</div>
	<table align="center">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>price</th>
			<th>description</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="product" items="${ products}">
			<tr>
				<td>${product.id }</td>
				<td>${product.name }</td>
				<td>${product.price }</td>
				<td>${product.description }</td>
				<td><a href="/MvcEx/product/update/${product.id }">수정</a></td>
				<td><a href="/MvcEx/product/delete/${product.id }">삭제</a></td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>