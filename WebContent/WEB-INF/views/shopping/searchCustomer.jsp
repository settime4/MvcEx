<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h5>Customer</h5>
	<fieldset>
		<sf:form method="post" modelAttribute="customer">
		Customer name: <sf:input type="text" path="name" /><br>
		Customer address: <sf:input type="text" path="address" /><br>
		Customer email: <sf:input type="text" path="email" /><br>
			<input type="submit" value="검색" />
		</sf:form>
	</fieldset>

</body>
</html>