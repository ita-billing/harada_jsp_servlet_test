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

public class SearchServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

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
			throws ServletException, IOException {

		// DB関連の初期設定
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		// 文字コードの設定
		request.setCharacterEncoding("utf-8");

		// db_index.jspで入力したnameの取得
		String name = request.getParameter("name");

		// db_index.jspで入力したidの取得
		String id = request.getParameter("id");

		// db_index.jspで入力したseiの取得
		String sei = request.getParameter("sei");

		// db_index.jspで入力したnenの取得
		String nen = request.getParameter("nen");
		
	
		try {
			// データソースからConnectionを取得
			conn = ds.getConnection();
			
			// sql文作成の準備
			StringBuffer sql = new StringBuffer();

			// sql文 の作成（nameから）
			sql.append("SELECT id, name, sei, nen, address FROM shain_table WHERE name LIKE '%");
			sql.append(name + "%'");

			// idが選択されている場合は、追加する
			if (id != "") {
				sql.append("AND id ='" + id + "' ");
			}

			// seiが選択されている場合は、追加する
			if (sei != "") {
				sql.append("AND sei ='" + sei + "' ");
			}

			// nenが選択されている場合は、追加する
			if (nen != "") {
				sql.append("AND nen ='" + nen + "' ");
			}
			
			// IDの降順に並び替え
			sql.append("ORDER BY id");

			// sql文実行準備
			pstmt = conn.prepareStatement(new String(sql));

			// sql文実行
			pstmt.execute();

			// 実行結果を、ResultSetクラスに代入
			rset = pstmt.executeQuery();

			// 遷移ページへ、引渡し（Attributeで追加する）
			request.setAttribute("kekka", rset);

			// db_search.jspへ遷移
			request.getRequestDispatcher("/db_search.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			
			// sql文の実行時にエラーだった場合
			String status ="検索に失敗しました。管理者に連絡してください。";					
			request.setAttribute("status", status);
			request.getRequestDispatcher("/db_result.jsp").forward(request, response);

		} finally {
			try {
				// finallyでDBとの接続を切断
				conn.close();
			} catch (Exception e) {
			}
		}
	}

}
