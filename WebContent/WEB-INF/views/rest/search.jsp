<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="/MvcEx/js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="/MvcEx/js/jquery.tmpl.min.js"></script>
<script id="itemTemplate" type="text/x-jquery-tmpl">
<div>
	<p>author:\${author}</p>
	<p>title:\${title}</p>
	<p>description:\${description}</p>
	<img src='\${image}'>
	<p>price:\${price}</p>
</div>
</script>

<script type="text/javascript">
	$(function() {
		$("#mybtn").click(function() {
			alert("클릭")
			$.ajax({
				url : "/MvcEx/rest/naver/book/search",
				type : "post",
				data : "keyword=" + $("#keyword").val(),
				dataType : "json",
				timeout : 30000,
				cache : false,
				success : function(json) {
					alert("여기옴")
					var item = json.rss.channel.item;
					var div = $("#itemTemplate").tmpl(item);
					$("#result").append(div)
				},
				error : function(xhr, textStatus, errorThrown) {
					$("#result").html(textStatus + ":" + xhr.status + ":" + errorThrown)
				}
			});
		});
	});
</script>

</head>
<body>
	<h1>json</h1>
		<input type="text" id="keyword"> <input id="mybtn" type='button' value="전송">
	<div id="result"></div>
</body>
</html>