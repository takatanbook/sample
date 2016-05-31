package jp.ac.asojuku.bookstore.bao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.ac.asojuku.bookstore.entity.MemberEntity;

public class MemberDao extends DBManager{
	private static final String MEMBER_INFO_BY_UP_SQL = "SELECT * FROM member WHERE "
			+ MemberEntity.MEMBER_ID+"=? AND " +MemberEntity.PASSWORD+"=?";

	public MemberEntity getMemberInfoByUserPaassword(String memb_id, String password) throws SQLException{
		if(con == null){
			return null;

		}
		PreparedStatement ps = null;
		ResultSet rs = null;
		MemberEntity entity = null;
		try{
			ps = con.prepareStatement(MEMBER_INFO_BY_UP_SQL);
			ps.setString(1, memb_id);
			ps.setString(2, password);


			rs = ps.executeQuery();
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
		}catch(SQLException e){
			System.out.println(e);
			throw e;

		}finally{
			try{
				if(rs != null){
					rs.close();
				}
				if(ps != null){
					ps.close();
				}
			}catch (SQLException e){
				;
			}
		}
		return entity;

	}
	
}