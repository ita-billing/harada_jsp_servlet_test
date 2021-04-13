<%@ page language="java" contentType="text/html;charset=Windows-31J" %>

<html>
<head>
	<title>トップ</title>
</head>
<body>
<br>

<%
	String message = (String)request.getAttribute( "login" );
	String name = (String)session.getAttribute( "name" );
%>

<br><br>
 <%= message %> <br><br>
 
こんにちは　<%= name %> さん<br><br>

<a href="/jsp_servlet_test/name.jsp">次のページに行く</a>


</body>
</html>
