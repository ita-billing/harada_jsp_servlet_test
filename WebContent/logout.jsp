<%@ page language="java" contentType="text/html;charset=Windows-31J" %>

<html>
<head>
<title></title>
</head>
<body>
<br>

<%
//セッション終了
session.invalidate();
%>

<br><br>
ログアウトしました<br><br>

<a href="/jsp_servlet_test/index.jsp">ログインページに戻る</a>
<br><br><br><br>

</body>
</html>