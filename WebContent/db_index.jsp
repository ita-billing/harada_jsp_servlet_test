<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<html>
<head>
	<title>トップ画面</title>
</head>
<body>

	<%
	  String username = (String)session.getAttribute("username");
	%>

    <form action="/jsp_servlet_test/Logout" method="POST">
           ユーザー名: <%= username %>   
	 <input class ="logout" type="submit" value="ログアウト">	
	</form>

	<h2>【検索】</h2>
	検索条件を入力してください。
	<br>（何も入力しないと全件抽出します）
	<br><br>

	<form action="/jsp_servlet_test/Search" method="POST">
		ID: <input type="text" name="id"> 名前: <input type="text" name="name"> 
		性別：
		<SELECT NAME="sei">
		  <OPTION VALUE="" selected></OPTION>
		  <OPTION VALUE="男">男</OPTION>
		  <OPTION VALUE="女">女</OPTION>
		</SELECT> 
		入社年：
		<SELECT NAME="nen">
		  <OPTION VALUE="" selected></OPTION>
		  <OPTION VALUE="2002">2002</OPTION>
		  <OPTION VALUE="2003">2003</OPTION>
		  <OPTION VALUE="2004">2004</OPTION>
		  <OPTION VALUE="2005">2005</OPTION>
		  <OPTION VALUE="2006">2006</OPTION>
		</SELECT>
		<br>
		<br>
		<input type="submit" value="検索">
	</form>

    <!-- 登録フォーム -->
    <h2>【登録】</h2>
         以下から登録できます。
    <br>（空欄は登録不可能です）
    <br><br>
    <form action="/jsp_servlet_test/Edit" method="POST">
        ID: <input type="text" name="id"> 
                  名前: <input type="text" name="name"> 
                  性別：
        <SELECT NAME="sei">
          <OPTION VALUE="" selected></OPTION>
          <OPTION VALUE="男">男</OPTION>
          <OPTION VALUE="女">女</OPTION>
        </SELECT> 
                  入社年：
        <SELECT NAME="nen">
          <OPTION VALUE="" selected></OPTION>
          <OPTION VALUE="2002">2002</OPTION>
          <OPTION VALUE="2003">2003</OPTION>
          <OPTION VALUE="2004">2004</OPTION>
          <OPTION VALUE="2005">2005</OPTION>
          <OPTION VALUE="2006">2006</OPTION>
        </SELECT> 
                  住所: <input type="text" name="address">
        <br>
        <br>
        <input type="hidden" name="mode" value="add"> <input type="submit" value="登録">
    </form>

</body>
</html>