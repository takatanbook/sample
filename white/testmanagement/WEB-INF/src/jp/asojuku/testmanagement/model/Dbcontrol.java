package jp.asojuku.testmanagement.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class Dbcontrol {
	Connection con = null;
	/*データベースに接続するクラス
	 * コネクトするメソッド
	 *
	 */
	public void connect() throws NamingException,SQLException{


    	InitialContext ctx;
		try {
			ctx = new InitialContext();

        	DataSource ds =
        		(DataSource)ctx.lookup("java:comp/env/jdbc/myds");

			// MySQLに接続
	        con = ds.getConnection();

		} catch (NamingException e) {
			System.out.println(e);
			throw e;
			
			
		} catch (SQLException e) {
			
			System.out.println(e);
			throw e;
		}


	}
    //データベースを閉じる
	public void close(){

		if( con != null ){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
				System.out.println("cloze No can do.");

			}
		}
	}
	public PreparedStatement  prepareStatement(String name) throws SQLException{
		if( con != null ){
			return null;
		}
		return con.prepareStatement(name);
		
	}
	

}
