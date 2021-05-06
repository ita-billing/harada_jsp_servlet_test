<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<html>
<head>
<title>処理結果</title>
</head>
<body>
    <h2>【処理結果】</h2>

	<%
	  String status = (String) request.getAttribute("status");
	  String username = (String)session.getAttribute("username");
	%>

	<%=status%>
	<br>
	<br>

	<a href="./db_index.jsp">トップページに戻る</a>


</body>
</html>
