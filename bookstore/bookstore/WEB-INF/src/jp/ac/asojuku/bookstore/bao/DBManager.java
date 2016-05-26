package jp.ac.asojuku.bookstore.bao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.ac.asojuku.bookstore.exception.DBConnectException;

public class DBManager {
	Logger logger = LoggerFactory.getLogger(DBManager.class);
	Connection con = null;
	/*データベースに接続するクラス
	 * コネクトするメソッド
	 * 
	 */
	public void connect() throws DBConnectException{
		

		PreparedStatement ps = null;
		RequestDispatcher rd = null;
        	InitialContext ctx;
			try {
				ctx = new InitialContext();

	        	DataSource ds =
	        		(DataSource)ctx.lookup("java:comp/env/jdbc/myds");

				// MySQLに接続
		        con = ds.getConnection();

			} catch (NamingException e) {
				System.out.println(e);
				throw new DBConnectException(e);
			} catch (SQLException e) {
				System.out.println(e);
				throw new DBConnectException(e);
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
				logger.info("cloze No can do.");
				
			}
		}
	}

	protected Connection getConnection(){
		return con;
	}
	//トランザクションを実行する
	public void beginTranzaction() throws SQLException{
		if( con != null ){
			con.setAutoCommit(false);
		}
	}
	//トランザクションを確定
	public void commit() throws SQLException{
		if( con != null ){
			try {
				con.commit();
			} finally{
				con.setAutoCommit(true);
			}
		}

	}
	//ロールバックします
	public void rollback() throws SQLException{
		if( con != null ){
			try {
				con.rollback();
			} finally{
				con.setAutoCommit(true);
			}
		}

	}
}