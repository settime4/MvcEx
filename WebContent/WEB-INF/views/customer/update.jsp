<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
${msg }
<title>Insert title here</title>
</head>
<body>
	<sf:form modelAttribute="customer" method="post">
		<fieldset>
			<table>
				<tr>
					<th>�̸�</th>
					<td><sf:input path="name" /></td>
				</tr>
				<tr>
					<th>�̸���</th>
					<td><sf:input path="email"/></td>
				</tr>
				<tr>
					<th>�ּ�</th>
					<td><sf:input path="address"/></td>
				</tr>
				<tr>
					<td colspan="2"><input name="commit" type="submit" value="����"></td>
				</tr>
			</table>		
		</fieldset>
	</sf:form>
	
</body>
</html>