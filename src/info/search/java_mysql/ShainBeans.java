package info.search.java_mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import javax.servlet.http.HttpSession;

public class ShainBeans {
    
    private String id;
    private String name;
    private String sei;
    private String nen;
    private String address;
    private String username;
    
    // DB関連の初期設定
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private DataSource ds = null;
    
    // 初期設定
    int count;
    int result;
    
    // コンストラクタ
    public ShainBeans(HttpServletRequest request) {
    	setId(request.getParameter("id"));
    	setName(request.getParameter("name"));
    	setSei(request.getParameter("sei"));
    	setNen(request.getParameter("nen"));
    	setAddress(request.getParameter("address"));

    	HttpSession session = request.getSession(true);
    	session.getAttribute("username");

    	setUsername(request.getParameter("username"));
    }

    // データベースへのアクション
    private void doDataBase(String sql) throws Exception {

    	// コンテキストを取得
    	InitialContext ic = new InitialContext();

    	// ルックアップしてデータソースを取得
    	ds = (DataSource) ic.lookup("java:comp/env/jdbc/search");
    	conn = ds.getConnection();

    	// sql文を表示
    	//System.out.println(sql);

    	// sql文実行
    	pstmt = conn.prepareStatement(sql);
    	count = pstmt.executeUpdate();
    	
    	// 実行結果
    	result = count;

    	// 使用したオブジェクトを終了させる
    	pstmt.close();
    	conn.close();
    }

    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSei() {
		return sei;
	}
	public void setSei(String sei) {
		this.sei = sei;
	}
	public String getNen() {
		return nen;
	}
	public void setNen(String nen) {
		this.nen = nen;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public Boolean addData() {
		try {
			
			// 必須項目のチェック
			if (id == "" || name == "" || sei == "" || nen == "" || address == "")  {
				return false;
			}
			
			// sql文 の作成
			String sql = "INSERT INTO SHAIN_TABLE(id, name, sei, nen, address, updateuser, updatetime) " 
			        + "VALUES ('" + id + "','" + name + "','" + sei + "','" + nen + "','" + address +  "','" + username + "',now())";

			// データベース接続＆ｓｑｌの実行
			doDataBase(sql);
			
			// ｓｑｌの実行結果の確認
			if (result == 1) {
				return true;
			}else{
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Boolean deleteData() {
	    try {
            // sql文 の作成
            String sql = "DELETE FROM SHAIN_TABLE WHERE ID = " + id;

            // データベース接続＆ｓｑｌの実行
            doDataBase(sql);

			// ｓｑｌの実行結果の確認
			if (result == 1) {
				return true;
			}else{
				return false;
			}
				
        } catch (Exception e) {
          e.printStackTrace();
          return false;
        }
    }

	public Boolean updateData() {
		try {
			
			// 必須項目のチェック
			if (name == "" || sei == "" || nen == "" || address == "")  {
				return false;
			}

			// sql文 の作成
			String sql = "UPDATE SHAIN_TABLE SET " 
			        + "name = '" + name + "', sei = '" + sei + "', nen = '" + nen + "', address ='" + address + "', updateuser = 'change', updatetime = now() "
					+ "WHERE id = '" + id + "'";

			// データベース接続＆ｓｑｌの実行
			doDataBase(sql);

			// ｓｑｌの実行結果の確認
			if (result == 1) {
				return true;
			}else{
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
