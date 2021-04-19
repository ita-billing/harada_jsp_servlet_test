<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<html>
<head>
<title>エラーページ</title>
</head>
<body>
	<br>

	<%
		String status = (String) request.getAttribute("status");
	%>

	<br>
	<br>
	<%=status%>
	<br>
	<br>

	<a href="./db_index.jsp">トップページに戻る</a>


</body>
</html>
