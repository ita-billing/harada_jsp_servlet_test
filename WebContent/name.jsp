<%@ page language="java" contentType="text/html;charset=Windows-31J" %>

<html>
<head>
	<title>セッション</title>
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

<a href="/jsp_servlet_test/result.jsp">前のページに戻る</a>
<a href="/jsp_servlet_test/logout.jsp">ログアウト</a>
<br><br><br><br>

</body>
</html>