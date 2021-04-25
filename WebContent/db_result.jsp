<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<html>
<head>
<title>処理結果</title>
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
