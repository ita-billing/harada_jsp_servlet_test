<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@page import="info.search.java_mysql.ShainBeans"%>

<html>
<head>
	<title>編集画面</title>
</head>
<body>

    <%
      ShainBeans shain = (ShainBeans) request.getAttribute("shain");
      String username = (String)session.getAttribute( "username" );
    %>
          
    <h2>【編集】</h2>      
          以下から変更できます。
    <br>（空欄は登録不可能です）
    <br>
    <br>
    <form action="/jsp_servlet_test/Edit" method="POST">
        ID:
        <%=shain.getId()%>（変更不可） <input type="hidden" name="id" value="<%=shain.getId()%>">
            <br>               
                           名前: <input type="text" name="name" value="<%=shain.getName()%>"> 
                           性別：
            <SELECT NAME="sei">
              <OPTION VALUE="<%=shain.getSei()%>" selected><%=shain.getSei()%></OPTION>
              <OPTION VALUE="男">男</OPTION>
              <OPTION VALUE="女">女</OPTION>
            </SELECT> 
                           入社年：
            <SELECT NAME="nen">
              <OPTION VALUE="<%=shain.getNen()%>" selected><%=shain.getNen()%></OPTION>
              <OPTION VALUE="2002">2002</OPTION>
              <OPTION VALUE="2003">2003</OPTION>
              <OPTION VALUE="2004">2004</OPTION>
              <OPTION VALUE="2005">2005</OPTION>
              <OPTION VALUE="2006">2006</OPTION>
            </SELECT> 
                           住所: <input type="text" name="address" value="<%=shain.getAddress()%>"> 
            <br>
            <br> 
            <input type="hidden" name="mode" value="update"> <input type="submit" value="変更する">
    </form>

    <a href="./db_index.jsp">トップに戻る</a>

</body>
</html>