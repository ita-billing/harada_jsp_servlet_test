<%@ page language="java" contentType="text/html;charset=UTF-8" %>

<html>
<head>
	<title>認証画面</title>
</head>
<body>
	<h2>【ログイン】</h2>

	<%
	  String status = (String) request.getAttribute("status");
	  // セッション終了
	  session.invalidate();
	%>

    <!-- ログインが失敗時、エラーメッセージを出す -->
    <% if (status == null) { %>
    <% } else { %>
    <h3><%= status %></h3>
    <% } %>

<form action="/jsp_servlet_test/Login" method="POST">
	ログインＩＤ: <input type="text" name="id">
	<br><br>
	パスワード: <input type="text" name="password">
	<br><br>

	<input type="submit" value="ログイン">
</form>

</body>
</html>