<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@page import="java.sql.*"%>

<html>
<head>
<title>検索結果</title>
</head>
<body>
	<br>

	<%
		ResultSet rset = (ResultSet) request.getAttribute("kekka");
	%>
	<table border="1">
		<tr bgcolor="#cccccc">
			<td><b>ID</b></td>
			<td><b>名前</b></td>
			<td><b>性別</b></td>
			<td><b>入社年</b></td>
			<td><b>住所</b></td>
		</tr>
		<%
			while (rset.next()) {
		%>
		<tr>
			<td><%=rset.getString(1)%></td>
			<td><%=rset.getString(2)%></td>
			<td><%=rset.getString(3)%></td>
			<td><%=rset.getString(4)%></td>
			<td><%=rset.getString(5)%></td>
		</tr>
		<%
			}
		%>
	</table>

	<br>

	<a href="./db_index.jsp">トップに戻る</a>

</body>
</html>
