package info.search.java_mysql;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 文字コードの設定
        request.setCharacterEncoding("utf-8");

        // modeの取得
        String mode = request.getParameter("mode");

        // 実行ステータスの宣言
        String status = "成功しました";

        // JavaBeansの初期化
        ShainBeans shain = new ShainBeans(request);

        switch (mode) {

        // 登録する場合
        case "add":
        	// 失敗した場合
        	if (shain.addData() == false) {
                status = "失敗しました";
            }
            break;

        // 削除する場合
        case "delete":
            if (shain.deleteData() == false) {
            	status = "失敗しました";
            }
            break;

        
        // 変更する場合
        case "change":
        	request.setAttribute("shain", shain);
        	request.getRequestDispatcher("/db_change.jsp").forward(request, response);
        	return;

        // 変更の確定
        case "del_add":
        	if (!(shain.deleteData() && shain.addData())) {
        		status = "失敗しました";
        	}
        	break;
        }      	

        // statusをセットして、db_result.jspに転送
        request.setAttribute("status", status);
        request.getRequestDispatcher("/db_result.jsp").forward(request, response);
    }

    //doGetの追加
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	
        doPost(request, response);
    }

}
