package jp.ac.asojuku.bookstore.bo;

import jp.ac.asojuku.bookstore.dto.LoginInfoDTO;
import jp.ac.asojuku.bookstore.exception.LoginFailureException;


public interface LoginBo {
	LoginInfoDTO login(String member_id, String password)throws LoginFailureException;
	
}



