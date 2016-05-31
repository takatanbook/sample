package jp.ac.asojuku.bookstore.bao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.ac.asojuku.bookstore.dto.LoginInfoDTO;
import jp.ac.asojuku.bookstore.dto.MemberDTO;
import jp.ac.asojuku.bookstore.entity.LoginLogEntity;
import jp.ac.asojuku.bookstore.exception.DBConnectException;

public class LoginLog extends DBManager{
	private  static final String SQLINSERT = "INSERT INTO logininfo(" 
			+ LoginLogEntity.MEMBER_MAIL +  ") VALUES (?)";
	private static final String UPDATE_LOGIN = "UPDATE logininfo SET "
			+LoginLogEntity.LOGIN_DATE + " = " + "?" + " WHERE " + LoginLogEntity.MEMBER_MAIL 
			+ " = ?";
	private static final String UPDATE_LOGOUT = "UPDATE logininfo SET "
			+ LoginLogEntity.LOGOUT_DATE + " = " + "?" +  " WHERE " + LoginLogEntity.MEMBER_MAIL 
			+ "= ?";
	//新規に会員登録された時にinsertする時の引数
	private static final int  LOGININFO_INSERT  = 1;
	//ログイン時にデータベースにログイン情報を保持
	private static final int  UPDATE_LOGININFO_INSERT_DATE  = 1;
	private static final int  UPDATE_LOGININFO_INSERT_MAIL  = 2;
	//ログアウト時にデータベースにログアウト情報を保持
	private static final int UPDATE_LOGOUTINFO_INSERT_DATE = 1;
	private static final int UPDATE_LOGOUTINFO_INSERT_MAIL = 2;
	
	
	public int setLoginlog(MemberDTO member)throws SQLException, DBConnectException{
		Logger logger = LoggerFactory.getLogger(LoginLog.class);
		PreparedStatement statement = null;
		ResultSet rs = null;
		LoginLogEntity entity = null;
		int num = 0;
		try{
			
		//データベースに接続
		connect();
		if( con == null ){
			return num;
		}
		//トランザクションを開始
		beginTranzaction();
		
		statement = con.prepareStatement(SQLINSERT);
		statement.setString(LOGININFO_INSERT,member.getMail1());
		num = statement.executeUpdate();
		
		//コミット
		commit();
		
		} catch (SQLException e){
			e.printStackTrace();
			logger.info("登録時にログイン時為にユーザーIDをログイン情報テーブルにデータを保持できませんでした" + e);
			
		}catch (Exception e){
			logger.info("登録時にログイン時為にユーザーIDをログイン情報テーブルにデータを保持できませんでした" + e);
		} finally {
			try {
		        // 接続を閉じる
	        	if( rs != null ){
					rs.close();
	        	}
	        	if( statement != null ){
		        	statement.close();
	        	}
	        		
	        	}catch(SQLException e){
	        		e.printStackTrace();
	        		logger.info("接続をとじれませんでした" + e);
	        	}
		}
		return num;
	}
	public  int setLoginDate(LoginInfoDTO loginInfo,String date)throws SQLException, DBConnectException{
		Logger logger = LoggerFactory.getLogger(LoginLog.class);
		PreparedStatement statement = null;
		ResultSet rs = null;
		
		LoginLogEntity entity = null;
		int num = 0;
		
		
		try{
			
			
			
	        // Date型変換
	        //Date formatDate =  sdf.parse(date);
	        
	        
			//データベースに接続
			connect();
			if( con == null ){
				return num;
			}
			
			//トランザクションを開始
			beginTranzaction();
			
			statement = con.prepareStatement(UPDATE_LOGIN);
			statement.setString(UPDATE_LOGININFO_INSERT_DATE, date);
			statement.setString(UPDATE_LOGININFO_INSERT_MAIL,loginInfo.getMemb_id());
			num = statement.executeUpdate();
			
			//コミット
			commit();
			
			} catch (SQLException e){
				e.printStackTrace();
				 logger.info("ログイン情報を保存する時にエラーが発生しました"+e);
				 rollback();
			}catch(Exception e){
				rollback();
				
			} finally {
				try {
			        // 接続を閉じる
		        	if( rs != null ){
						rs.close();
		        	}
		        	if( statement != null ){
			        	statement.close();
		        	}
		        		
		        	}catch(SQLException e){
		        		e.printStackTrace();
		        		logger.info("接続をとじれませんでした" + e);
		        	}
			}
			return num;
		
	}
	public  int setLogoutDate(LoginInfoDTO loginInfo,String date)throws SQLException, DBConnectException{
		Logger logger = LoggerFactory.getLogger(LoginLog.class);
		PreparedStatement statement = null;
		ResultSet rs = null;
		LoginLogEntity entity = null;
		int num = 0;
		
		try{
			
			//データベースに接続
			connect();
			if( con == null ){
				return num;
			}
			//トランザクションを開始
			beginTranzaction();
			
			statement = con.prepareStatement(UPDATE_LOGOUT);
			statement.setString(UPDATE_LOGOUTINFO_INSERT_DATE,date);
			statement.setString(UPDATE_LOGOUTINFO_INSERT_MAIL,loginInfo.getMemb_id() );
			num = statement.executeUpdate();
			
			//コミット
			commit();
			
			} catch (SQLException e){
				e.printStackTrace();
				 logger.info("ログイン情報を保存する時にエラーが発生しました"+e);
				 rollback();
			}catch (Exception e){
				logger.info("ログイン情報を保存する時にエラーが発生しました"+e);
				rollback();
			} finally {
				try {
			        // 接続を閉じる
		        	if( rs != null ){
						rs.close();
		        	}
		        	if( statement != null ){
			        	statement.close();
		        	}
		        		
		        	}catch(SQLException e){
		        		e.printStackTrace();
		        		logger.info("接続をとじれませんでした" + e);
		        	}
			}
			return num;
		
	}

}