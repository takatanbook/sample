package jp.ac.asojuku.bookstore.bao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.ac.asojuku.bookstore.dto.MemberDTO;
import jp.ac.asojuku.bookstore.entity.MemberEntity;
import jp.ac.asojuku.bookstore.exception.DBConnectException;

public class EntlyMemberDao extends DBManager{
	//メールアドレスが既に存在しないかのSQL分
	private static final String MEMBER_INFO_BY_UP_SQL = "SELECT * FROM member WHERE "
			+ MemberEntity.MEMBER_ID+"=?";
	//会員登録に使用するSQL分
	private static final String MEMBER_INSERT_UP_SQL ="INSERT INTO member("
			+ MemberEntity.MEMBER_ID + ","+
			MemberEntity.MEMBER_FAST_NAME + "," +
			MemberEntity.MEMBER_LAST_NAME + "," +
			MemberEntity.MEMBER_NAME_FAST + "," +
			MemberEntity.MEMBER_NAME_LAST + "," +
			MemberEntity.MEMBER_NICKNAME + "," +
			MemberEntity.MEMBER_POSTAL_CODE + "," +
			MemberEntity.MEMBER_PREFECTURE + "," +
			MemberEntity.MEMBER_CITY + "," +
			MemberEntity.MEMBER_HOSE_NUM + "," +
			MemberEntity.MEMBER_NUMBER + "," + 
			MemberEntity.SEX +","+
			MemberEntity.PASSWORD + ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final int INSERT_MEMBER_ID = 1;
	private static final int INSERT_MEMBER_FAST_NAME =2;
	private static final int INSERT_MEMBER_LAST_NAME = 3;
	private static final int INSERT_MEMBER_NAME_FAST = 4;
	private static final int INSERT_MEMBER_NAME_LAST = 5;
	private static final int INSERT_MEMBER_NICKNAME = 6;
	private static final int INSERT_MEMBER_POSTAL_CODE = 7;
	private static final int INSERT_MEMBER_PREFECTURE =8;
	private static final int INSERT_MEMBER_CITY = 9;
	private static final int INSERT_MEMBER_HOSE_NUM = 10;
	private static final int INSERT_MEMBER_NUMBER = 11;
	private static final int INSERT_MEMBER_SEX = 12;
	private static final int INSERT_PASSWORD = 13;
	
	public MemberEntity getMail(String mail)throws SQLException, DBConnectException {
		Logger logger = LoggerFactory.getLogger(EntlyMemberDao.class);
		MemberDTO member = new MemberDTO();
		PreparedStatement statement = null;
		ResultSet rs = null;
		MemberEntity entity = null;
		int num = 0;
		
		try{
			
		
		connect();
		if( con == null ){
			return null;
		}
		
		
			
			statement = con.prepareStatement(MEMBER_INFO_BY_UP_SQL);
			statement.setString(INSERT_MEMBER_ID,mail);
			rs = statement.executeQuery();
			
			while(rs.next()){
				entity = new MemberEntity();
				entity.setMemb_id(rs.getString(MemberEntity.MEMBER_ID));
				entity.setMemb_fast_name(rs.getString(MemberEntity.MEMBER_FAST_NAME));
				entity.setMemb_last_name(rs.getString(MemberEntity.MEMBER_LAST_NAME));
				entity.setMemb_name_fast(rs.getString(MemberEntity.MEMBER_NAME_FAST));
				entity.setMemb_name_last(rs.getString(MemberEntity.MEMBER_NAME_LAST));
				entity.setMemb_nickname(rs.getString(MemberEntity.MEMBER_NICKNAME));
				entity.setMemb_postal_code(rs.getString(MemberEntity.MEMBER_POSTAL_CODE));
				entity.setMemb_prefecture(rs.getString(MemberEntity.MEMBER_PREFECTURE));
				entity.setMemb_city(rs.getString(MemberEntity.MEMBER_CITY));
				entity.setMemb_house_num(rs.getString(MemberEntity.MEMBER_HOSE_NUM));
				entity.setMemb_number(rs.getString(MemberEntity.MEMBER_NUMBER));
				entity.setSex(rs.getString(MemberEntity.SEX));
				entity.setPassword(rs.getString(MemberEntity.PASSWORD));
			}
			
		
		}catch (SQLException e){
			
			
		} finally {
			
		    // 接続を閉じる
	        if( rs != null ){
				rs.close();
	        }
	        if( statement != null ){
		        statement.close();
	        }
		}
			
		
		return entity;
	}
	
	public int setMember(MemberDTO memberinfo )throws SQLException, DBConnectException {
		
		
		int num = 0;
		Logger logger = LoggerFactory.getLogger(EntlyMemberDao.class);
		MemberDTO member = new MemberDTO();
		PreparedStatement statement = null;
		ResultSet rs = null;
		MemberEntity entity = null;
		
		
		
		try{
			//電話番号のTel1とTel2とTel3を電話番号の形にする
			String NUMBER = memberinfo.getTel1() + "-" + memberinfo.getTel2() + "-" + memberinfo.getTel3();
			
			connect();
			if( con == null ){
				return 0;
			}
			//トランザクションを開始
			beginTranzaction();
			
			//パラメーターに値をセットする
			statement = con.prepareStatement(MEMBER_INSERT_UP_SQL);
			statement.setString(INSERT_MEMBER_ID,memberinfo.getMail1());
			statement.setString(INSERT_MEMBER_FAST_NAME,memberinfo.getName_sei() );
			statement.setString(INSERT_MEMBER_LAST_NAME,memberinfo.getName_mei());
			statement.setString(INSERT_MEMBER_NAME_FAST,memberinfo.getName_hurigana_sei());
			statement.setString(INSERT_MEMBER_NAME_LAST, memberinfo.getName_hurigana_mei());
			statement.setString(INSERT_MEMBER_NICKNAME, memberinfo.getNickname());
			statement.setString(INSERT_MEMBER_POSTAL_CODE,memberinfo.getYuubinNo());
			statement.setString(INSERT_MEMBER_PREFECTURE, memberinfo.getPrefecture());
			statement.setString(INSERT_MEMBER_CITY, memberinfo.getAddres1());
			statement.setString(INSERT_MEMBER_HOSE_NUM, memberinfo.getAddres2());
			statement.setString(INSERT_MEMBER_NUMBER, NUMBER);
			statement.setString(INSERT_MEMBER_SEX,memberinfo.getSex());
			statement.setString(INSERT_PASSWORD, memberinfo.getHashpassword());
			
			//SQLの実行
			num = statement.executeUpdate();
			
			//コミット
			commit();
		
		}finally {
			try {
		        // 接続を閉じる
	        	if( rs != null ){
					rs.close();
	        	}
	        	if( statement != null ){
		        	statement.close();
	        	}
			} catch (SQLException e) {
				;	//closeの失敗は無視
			}
		}
		
		
		return num;
	}
	
	

}
