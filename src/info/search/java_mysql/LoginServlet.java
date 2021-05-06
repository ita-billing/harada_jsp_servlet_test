package info.search.java_mysql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet  {
	
	//データソースの作成
	DataSource ds;
	  
	// 初期化処理
    public void init() throws ServletException {
        try {
            // 初期コンテキストを取得
            InitialContext ic = new InitialContext();
            // ルックアップしてデータソースを取得
            ds = (DataSource) ic.lookup("java:comp/env/jdbc/search");
        } catch (Exception e) {
        
        }
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{

		// DB関連の初期設定
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		// 初期値を設定
		String status = "";
		String name = "";
		
		// 文字コードの設定
		request.setCharacterEncoding("utf-8");
				
		// db_login.jspで入力したidの取得
		String id = request.getParameter("id");

		// db_login.jspで入力したpasswordの取得
		String password = request.getParameter("password");
		
		// IDとパスワードのチェック
		if(id.equals("") && password.equals("")) {
			status = "IDとパスワードが未入力です。";
		    request.setAttribute("status", status);
		    request.getRequestDispatcher("/db_login.jsp").forward(request, response);
		}else if(id.equals("")) {
			status = "IDが未入力です。";
		    request.setAttribute("status", status);
		    request.getRequestDispatcher("/db_login.jsp").forward(request, response);
		}else if(password.equals("")) {
			status = "パスワードが未入力です。";
		    request.setAttribute("status", status);
		    request.getRequestDispatcher("/db_login.jsp").forward(request, response);
		}else{
			try {
				// データソースからConnectionを取得
				conn = ds.getConnection();

				// sql文作成の準備
				StringBuffer sql = new StringBuffer();

				// sql文 の作成
				sql.append("SELECT name AS NAME FROM administrator_table WHERE id = '" + id + "' ");
				sql.append("AND password = '" + password + "'");

				// sql文実行準備
				pstmt = conn.prepareStatement(new String(sql));

				// sql文実行
				pstmt.execute();

				// 実行結果を、ResultSetクラスに代入
				rset = pstmt.executeQuery();

				// IDとパスワードのチェック
				if(rset.next()) {
					// 該当データあり
					name = rset.getString("name");

					// セッションにユーザー名を保持
					HttpSession session = request.getSession(true);
					session.setAttribute("username",name);

					// db_index.jspへ遷移
					request.getRequestDispatcher("/db_index.jsp").forward(request, response);
			
				}else{				
					// 該当データなし
					status ="該当するユーザーが見つかりませんでした。";
				    request.setAttribute("status", status);
				    request.getRequestDispatcher("/db_login.jsp").forward(request, response);
				    //rset.close();
				    //pstmt.close();
				    //conn.close();

				    }

				} catch (Exception e) {
					e.printStackTrace();

					// sql文の実行時にエラーだった場合
					status ="ログインに失敗しました。管理者に連絡してください。";
					request.setAttribute("status", status);
					request.getRequestDispatcher("/db_login.jsp").forward(request, response);
					} finally {
						try {
							// finallyでDBとの接続を切断
							conn.close();
							} catch (Exception e) {
							
							}
						}
			}
		}
}
