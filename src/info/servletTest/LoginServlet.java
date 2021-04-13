package info.servletTest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet  {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{

		// 初期値を設定
		String name = "ゲストユーザー";
		String status = "ログイン失敗";
		request.setCharacterEncoding("windows-31J"); 

		String id = request.getParameter("id");
		String pass = request.getParameter("pass");

		// IDとパスワードのチェック
		if(id.equals("id") && pass.equals("password")) {
			name = "JP";
			status = "成功";
		}else if(id.equals("") && pass.equals("")) {
			name = "noname";
			status = "未入力";
		}
		// statusをloginに渡す
		request.setAttribute("login", status);

		// セッションに名前を保持
		HttpSession session = request.getSession(true);
		session.setAttribute("name",name);

		// result.jspを呼び出す
		request.getRequestDispatcher("/result.jsp").forward(request,response);
	}
}
