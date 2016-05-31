package jp.asojuku.testmanagement.bo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import jp.asojuku.testmanagement.entity.MemberEntity;
import jp.asojuku.testmanagement.exception.SystemErrorExcepton;
import jp.asojuku.testmanagement.model.Dbcontrol;

public class LoginBo {
	
	// ユーザーIDとパスワードを指定してユーザー情報を取得する
	private static final String MEMBER_INFO_BY_UP_SQL =
				"SELECT * FROM member_tbl WHERE "+MemberEntity.MAIL_ADRESS+"=? AND "+MemberEntity.PASSWORD+"=?";
	private static final int MEMBER_INFO_BY_UP_NAME_IDX = 1;
	private static final int MEMBER_INFO_BY_UP_PASS_IDX = 2;
	
	
	
	//
	public MemberEntity getMemberInfoByUserPassword(String userName,String password) throws SQLException, SystemErrorExcepton{
		
		try {
			
		} catch (Exception e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		MemberEntity entity = null;
		Dbcontrol db = new Dbcontrol();
        try {
        	
        	db.connect();
        	

    		// ステートメント生成
        	
        	
			ps = db.prepareStatement(MEMBER_INFO_BY_UP_SQL);

	        ps.setString(MEMBER_INFO_BY_UP_NAME_IDX, userName);
	        ps.setString(MEMBER_INFO_BY_UP_PASS_IDX, password);

	        // SQLを実行
	        rs = ps.executeQuery();


	        //値を取り出す
	        while(rs.next()){
	        	entity = new MemberEntity();
	            //MemberEntityへ値を入れる
	        	
	        	entity.setMailAddress(rs.getString(MemberEntity.MAIL_ADRESS));
	        	

	        }

		} catch (SQLException e) {
			//例外発生時はログを出力し、上位へそのままスロー
			throw new SystemErrorExcepton();

		} catch (NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new SystemErrorExcepton();
		} finally {
        	

	        // 接続を閉じる
        	if( rs != null ){
				rs.close();
        	}
        	if( ps != null ){
	        	ps.close();
        	}
        	
    		db.close();
		}

		return entity;
	}

	
	
}