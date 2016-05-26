package jp.ac.asojuku.bookstore.bo.impl;
import java.sql.SQLException;

import jp.ac.asojuku.bookstore.bao.MemberDao;
import jp.ac.asojuku.bookstore.bo.LoginBo;
import jp.ac.asojuku.bookstore.dto.LoginInfoDTO;
import jp.ac.asojuku.bookstore.entity.MemberEntity;
import jp.ac.asojuku.bookstore.exception.DBConnectException;
import jp.ac.asojuku.bookstore.exception.LoginFailureException;
import jp.ac.asojuku.bookstore.security.SecutityUtil;

public class LoginBoImpl  implements LoginBo{
	@Override
	public LoginInfoDTO login(String memb_id, String password) throws LoginFailureException{
		LoginInfoDTO login = new LoginInfoDTO();
		MemberDao dao = new MemberDao();
		try{
			//TODO password をハッシュ化する（パスワードとメールアドレス連結）
			String pass = password + memb_id;  
			String userName = "";
			userName = SecutityUtil.ecryptStr(pass);
			dao.connect();
			
			MemberEntity entity = 
					dao.getMemberInfoByUserPaassword(memb_id,userName);
			login = MemberEntityToLoginInfoDTO(entity);
		}catch (DBConnectException e){
			throw new LoginFailureException();
			
		} catch (SQLException e){
			throw new LoginFailureException();
		}finally{
			dao.close();
			
		}
		return login;
	}
	
	private LoginInfoDTO MemberEntityToLoginInfoDTO(MemberEntity entity){
		if(entity == null){
			return null;
		}
		LoginInfoDTO loginDto = new LoginInfoDTO();
		loginDto.setMemb_name(entity.getMemb_fast_name());
		loginDto.setMemb_id(entity.getMemb_id());
		return loginDto;
		
	}
	

}
