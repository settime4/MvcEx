<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="/MvcEx/js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="/MvcEx/js/jquery.tmpl.min.js"></script>
<script id="itemTemplate" type="text/x-jquery-tmpl">
	<tr>
		<td>\${name}</td>
		<td>\${email}</td>
	</tr>
</script>

<script type="text/javascript">
	$(function(){
		$.getJSON("http://localhost:8888/MvcEx/rest/employees/ver1/lim.j", { }, function(json){
			var employees = json.employees;
			var div = $("#itemTemplate").tmpl(employees);
			
			$("#list").append(div);
		})
	})
</script>
</head>
<body>
<h1>json</h1>
	<table id="list">
		<tr>
			<th>name</th>
			<th>email</th>		
		</tr>
	</table>
</body>
</html>