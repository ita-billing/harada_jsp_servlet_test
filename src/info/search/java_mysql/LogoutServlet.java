package info.search.java_mysql;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet  {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{

		// 文字コードの設定
		request.setCharacterEncoding("utf-8");

		// 初期値を設定
		String status = "";
		
		try {
			status ="ログアウトしました。";
			request.setAttribute("status", status);
			request.getRequestDispatcher("/db_login.jsp").forward(request, response);


			} catch (Exception e) {
				e.printStackTrace();
						
				// 例外処理
				status ="異常終了しました。管理者に連絡してください。";
				request.setAttribute("status", status);
				request.getRequestDispatcher("/db_login.jsp").forward(request, response);
					}
		}
}
