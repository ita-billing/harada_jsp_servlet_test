<%@ page language="java" contentType="text/html;charset=Windows-31J" %>

<html>
<head>
	<title>�g�b�v</title>
</head>
<body>
<br>

<%
	String message = (String)request.getAttribute( "login" );
	String name = (String)session.getAttribute( "name" );
%>

<br><br>
 <%= message %> <br><br>
 
����ɂ��́@<%= name %> ����<br><br>

<a href="/jsp_servlet_test/name.jsp">���̃y�[�W�ɍs��</a>


</body>
</html>
