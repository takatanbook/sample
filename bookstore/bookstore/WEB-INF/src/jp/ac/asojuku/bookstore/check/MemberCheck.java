package jp.ac.asojuku.bookstore.check;

import java.sql.SQLException;

import jp.ac.asojuku.bookstore.bao.EntlyMemberDao;
import jp.ac.asojuku.bookstore.error.CodeError;
import jp.ac.asojuku.bookstore.exception.BookStoreSystemErrorException;
import jp.ac.asojuku.bookstore.exception.DBConnectException;

public class MemberCheck {
	private static int passsize = 8;//passwordは8文字以上
	/*名前の性を入力チャックをする*/
	public static CodeError CheckNameSei (String name) throws BookStoreSystemErrorException {
		CodeError result = CodeError.SUCCESS;
		//特殊な文字が含まれていないか判定
		if (EscapeHtmlTest.escapeHTML(name) == false){
			return CodeError.ERROR_MEMBER_NEW_XSS;
		}
		//文字列が１文以上１８文字以内
		if (CheckSecurity.stringLengthCheck(name, 1, 18) == false){
			result  = CodeError.ERROR_MEMBER_NEW_NAME;

		}
		//文字列かnullか空を判定
		if (name == null || name.length() == 0){
			result =  CodeError.ERROR_MEMBER_NEW_NAME_EMPTY;
		}
		return result;
	}
	/*名前の名を入力チャックをする*/
	public static CodeError CheckNameMei (String name) throws BookStoreSystemErrorException {
		CodeError result = CodeError.SUCCESS;
		//特殊な文字が含まれていないか判定
		if (EscapeHtmlTest.escapeHTML(name) == false){
			return CodeError.ERROR_MEMBER_NEW_XSS;
		}
		//文字列が１文以上１８文字以内
		if (CheckSecurity.stringLengthCheck(name, 1, 18) == false){
			result = CodeError.ERROR_MEMBER_NEW_NAME2;
		}
		//文字列かnullか空を判定
		if (name == null || name.length() == 0){
			result =  CodeError.ERROR_MEMBER_NEW_NAME_EMPTY;
		}
		return result;
	}
	/*名前の姓のふりがなをチャックします。*/
	public static CodeError CheckNameHuriganaSei (String name) throws BookStoreSystemErrorException {
		CodeError result = CodeError.SUCCESS;
		//特殊な文字が含まれていないか判定
		if (EscapeHtmlTest.escapeHTML(name) == false){
			return CodeError.ERROR_MEMBER_NEW_XSS;
		}

		//文字列が１文以上38文字以内
		if (CheckSecurity.stringLengthCheck(name, 1, 38) == false){
			result = CodeError.ERROR_MEMBER_NEW_NAME_HURIGANA;
		}
		
		//文字列が平仮名判定する
		if (CheckSecurity.isHiraganaOnly(name) == false){
			result = CodeError.ERROR_MEMBER_NEW_NAME_HURIGANA_CODE;
		}
		
		//文字列かnullか空を判定
		if (name == null || name.length() == 0){
			result = CodeError.ERROR_MEMBER_NEW_NAME_HURIGANA;
		}
		return result;
	}
	/*名前の名のふりがなをチェックします。*/
	public static CodeError CheckNameHuriganaMei (String name) throws BookStoreSystemErrorException {
		CodeError result = CodeError.SUCCESS;
		//特殊な文字が含まれていないか判定
		if (EscapeHtmlTest.escapeHTML(name) == false){
			return CodeError.ERROR_MEMBER_NEW_XSS;
		}

		//文字列が１文以上38文字以内
		if (CheckSecurity.stringLengthCheck(name, 1, 38) == false){
			result = CodeError.ERROR_MEMBER_NEW_NAME2_HURIGANA;
		}
		
		//文字列が平仮名判定する
		if (CheckSecurity.isHiraganaOnly(name) == false){
			result = CodeError.ERROR_MEMBER_NEW_NAME_HURIGANA_CODE;
		}
		
		//文字列かnullか空を判定
		if (name == null || name.length() == 0){
			result = CodeError.ERROR_MEMBER_NEW_NAME_HURIGANA;
		}
		return result;
	}
	/*ニックネームをチェックします。*/
	public static CodeError CheckNickname(String nickname) throws BookStoreSystemErrorException{
		CodeError result = CodeError.SUCCESS;
		//特殊な文字が含まれていないか判定
		if (EscapeHtmlTest.escapeHTML(nickname) == false){
			return CodeError.ERROR_MEMBER_NEW_XSS;
		}
		
		//文字列が１文以上30文字以内
		if (CheckSecurity.stringLengthCheck(nickname, 1, 30) == false){
			result = CodeError.ERROR_MEMBER_NEW_NICKNAME;
		}
		
		//文字列かnullか空を判定
		if (nickname == null || nickname.length() == 0){
			result = CodeError.ERROR_MEMBER_NEW_NICKNAME_EMPTY;
		}
		return result;
	}
	/*郵便番号をチャックします。*/
	public static CodeError CheckPostnumber(String postnumber) throws BookStoreSystemErrorException{
		CodeError result = CodeError.SUCCESS;
		//特殊な文字が含まれていないか判定
		if (EscapeHtmlTest.escapeHTML(postnumber) == false){
			return CodeError.ERROR_MEMBER_NEW_XSS;
		}
		
		//郵便番号の型判定
		if (CheckSecurity.isZipCode(postnumber) == false){
			result = CodeError.ERROR_MEMBER_NEW_POST_CODE;
		}
		
		//文字列かnullか空を判定
		if (postnumber == null || postnumber.length() == 0){
			result = CodeError.ERROR_MEMBER_NEW_POST_CODE;
		}

		return result;
	}
	/*都道府県のラジオボタンをチェックします。*/
	public static CodeError CheckPrefecture(String prefecture) throws BookStoreSystemErrorException{
		CodeError result = CodeError.SUCCESS;
		//特殊な文字が含まれていないか判定
		if (EscapeHtmlTest.escapeHTML(prefecture) == false){
			return CodeError.ERROR_MEMBER_NEW_XSS;
		}
		
		//プルダウンメニューで選んでいるかを判定
		if (RdioCheck.Check2(prefecture) == false){
			result = CodeError.ERROR_MEMBER_NEW_PREFECTURE_ACCIDENT;
		}
		
		//文字列かnullか空を判定
		if (prefecture == null || prefecture.length() == 0){
			result = CodeError.ERROR_MEMBER_NEW_PREFECTURE_ACCIDENT;
		}
		return result;
	}
	//住所の市町村をチャックする
	public static CodeError CheckADDRES1(String addres1){
		
		CodeError result = CodeError.SUCCESS;
		
		//特殊な文字が含まれていないか判定
		if (EscapeHtmlTest.escapeHTML(addres1) == false){
			return CodeError.ERROR_MEMBER_NEW_XSS;
		}
		
		//文字列が１文以上30文字以内
		if (CheckSecurity.stringLengthCheck(addres1, 1, 30) == false){
			result = CodeError.ERROR_MEMBER_NEW_CITY;
		}
		
		//文字列かnullか空を判定
		if (addres1 == null || addres1.length() == 0){
			result = CodeError.ERROR_MEMBER_NEW_CITY_EMPTY;
		}
		
		return result;
	}
	//住所の番地とマンション名または建物名
	public static CodeError CheckADDRES2(String addres2){
		
		CodeError result = CodeError.SUCCESS;
		
		//特殊な文字が含まれていないか判定
		if (EscapeHtmlTest.escapeHTML(addres2) == false){
			return CodeError.ERROR_MEMBER_NEW_XSS;
		}
		
		//文字列が１文以上６0文字以内
		if (CheckSecurity.stringLengthCheck(addres2, 1, 60) == false){
			result = CodeError.ERROR_MEMBER_NEW_ADDRES_MANSINON;
		}
		//文字列かnullか空を判定
		if (addres2 == null || addres2.length() == 0){
			result = CodeError.ERROR_MEMBRE_NEW_ADDRES_MANSION_EMPTY;
		}
		
		return result;
	}
	/*電話番号をチェックする*/
	public static CodeError CheckNomber(String tel1,String tel2,String tel3) throws BookStoreSystemErrorException{
		CodeError result = CodeError.SUCCESS;
		
		//特殊な文字が含まれていないか判定
		if (EscapeHtmlTest.escapeHTML(tel1) == false){
			return CodeError.ERROR_MEMBER_NEW_XSS;
		}
		//特殊な文字が含まれていないか判定
		if (EscapeHtmlTest.escapeHTML(tel2) == false){
			return CodeError.ERROR_MEMBER_NEW_XSS;
		}
		
		//特殊な文字が含まれていないか判定
		if (EscapeHtmlTest.escapeHTML(tel3) == false){
			return CodeError.ERROR_MEMBER_NEW_XSS;
		}
		
		String Numeber = tel1 + "-" + tel2  + "-" + tel3;
		
		//特殊な文字が含まれていないか判定
		if (CheckSecurity.isNumber(Numeber) == false){
			result = CodeError.ERROR_MEMBER_NEW_TELNUMBER_CHECK;
		}
		
		//文字列かnullか空を判定
		if (tel1 == null || tel1.length() == 0
				|| tel2 == null || tel2.length() == 0
				|| tel3 == null || tel3.length() == 0){
			result =  CodeError.ERROR_MEMBER_NEW_TELNUMBER_EMPTY;
		}

		return result;
	}
	/*メールアドレスをチェックする*/
	public static CodeError CheckMail(String mail1, String mail2) throws BookStoreSystemErrorException{
		CodeError result = CodeError.SUCCESS;
		EntlyMemberDao dao =  new EntlyMemberDao();
		
		//特殊な文字が含まれていないか判定
		if (EscapeHtmlTest.escapeHTML(mail1) == false){
			return CodeError.ERROR_MEMBER_NEW_XSS;
		}
		
		//特殊な文字が含まれていないか判定
		if (EscapeHtmlTest.escapeHTML(mail2) == false){
			return CodeError.ERROR_MEMBER_NEW_XSS;
		}
		
		//メールアドレスの型を判定
		if (CheckSecurity.isMail(mail1) == false){
			result = CodeError.ERROR_MEMBER_NEW_MAIL_CHECK;
		}
		
		//メールアドレスを確認ように二つ入力された値が一致しているか判定
		if (CheckSecurity.matc(mail1, mail2) == true){
			result = CodeError.ERROR_MEMBER_NEW_MAIL_ONE;
		}
		
		//文字列かnullか空を判定
		if (mail1 == null || mail1.length() == 0 || mail2 == null || mail2.length() == 0){
			result = CodeError.ERROR_MEMBER_NEW_MAIL_EMPTY;
		}
		try {
			//メールアドレスが既に存在していないか判定。
			if(dao.getMail(mail1) != null){
				result = CodeError.ERROR_MEMBER_NEW_MAIL_MACH;
			}

			return result;
		} catch (DBConnectException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return result;
	}
	/*パスワードチャックします。*/
	public static CodeError CheckPassword(String pass1, String pass2) throws BookStoreSystemErrorException{
		CodeError result = CodeError.SUCCESS;
		//特殊な文字が含まれていないか判定
		if (EscapeHtmlTest.escapeHTML(pass1) == false){
			return CodeError.ERROR_MEMBER_NEW_XSS;
		}
		//特殊な文字が含まれていないか判定
		if (EscapeHtmlTest.escapeHTML(pass2) == false){
			return CodeError.ERROR_MEMBER_NEW_XSS;
		}
		
		//パスワードが８文字以上（判定）
		if (pass1.length() < passsize || pass2.length() < passsize){
			result = CodeError.ERROR_MEMBER_NEW_PASS_LENGS;
		}
		
		//パスワードを確認ように二つ入力された値が一致しているか判定
		if (CheckSecurity.matc(pass1, pass2) == true){
			result = CodeError.ERROR_MEMBER_NEW_PASS_ONE;
		}
		
		//文字列かnullか空を判定
		if (pass1 == null || pass1.length() == 0 || pass2 == null || pass2.length() == 0){
			return CodeError.ERROR_MEMBER_NEW_PASS_EMPTY;
		}
		return result;
	}
	/*性別のラジオのボックス検査*/
	public static CodeError CheckSex(String sex) throws BookStoreSystemErrorException{
		CodeError result = CodeError.SUCCESS;
		//特殊な文字が含まれていないか判定
		if (EscapeHtmlTest.escapeHTML(sex) == false){
			return CodeError.ERROR_MEMBER_NEW_XSS;
		}
		
		//プルダウンメニューでmenかwomanが選ばれているか判定
		if (RdioCheck.Check1(sex) == false){
			result = CodeError.ERROR_MEMBER_NEW_SEX;
		}
		
		//文字列かnullか空を判定
		if (sex == null || sex.length() == 0){
			result = CodeError.ERROR_MEMBER_NEW_SEX;
		}
		return result;
	}
}
