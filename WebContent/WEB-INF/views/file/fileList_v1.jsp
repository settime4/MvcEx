<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<tr>
			<th>id</th>
			<th>writer</th>
			<th>title</th>
			<th>filename</th>
		</tr>
		<c:forEach var="file" items="${fileList}">
			<tr>
				<td>${file.id }</td>
				<td>${file.writer }</td>
				<td>${file.title }</td>
				<td><a href="download_v1?id=${file.id}">${file.originalfilename }</a> <a href="delete?id=${file.id }"><img alt="delete" src="../resources/img/car1.gif"></a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>