<%@ page language="java" contentType="text/html;charset=Windows-31J" %>

<html>
<head>
	<title>�Z�b�V����</title>
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

<a href="/jsp_servlet_test/result.jsp">�O�̃y�[�W�ɖ߂�</a>
<a href="/jsp_servlet_test/logout.jsp">���O�A�E�g</a>
<br><br><br><br>

</body>
</html>