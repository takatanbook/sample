package jp.ac.asojuku.bookstore.error;

public enum CodeError {
	SUCCESS("0000"),
	//login(00xx)
	ERROR_LOGIN("0001"),
	//member registration
	ERROR_MEMBER_NEW_NAME("0101"),
	ERROR_MEMBER_NEW_NAME2("0102"),
	ERROR_MEMBER_NEW_NAME_HURIGANA("0103"),
	ERROR_MEMBER_NEW_NAME2_HURIGANA("0104"),
	ERROR_MEMBER_NEW_NICKNAME("0105"),
	ERROR_MEMBER_NEW_POST_CODE("0106"),
	ERROR_MEMBER_NEW_PREFECTURE_ACCIDENT("0107"),
	ERROR_MEMBER_NEW_CITY("0108"),
	ERROR_MEMBER_NEW_ADDRES_MANSINON("0109"),
	ERROR_MEMBER_NEW_SEX("0110"),
	ERROR_MEMBER_NEW_PASS_ONE("0111"),
	ERROR_MEMBER_NEW_MAIL_ONE("0112"),
	ERROR_MEMBER_NEW_MAIL_CHECK("0113"),
	ERROR_MEMBER_NEW_MAIL_MACH("0114"),
	ERROR_MEMBER_NEW_PASS_LENGS("0115"),
	ERROR_MEMBER_NEW_NAME_EMPTY("0116"),
	ERROR_MEMBER_NEW_NAME_HURIGANA_EMPTY("0117"),
	ERROR_MEMBER_NEW_NICKNAME_EMPTY("0118"),
	ERROR_MEMBER_NEW_POST_CODE_EMPTY("0119"),
	ERROR_MEMBER_NEW_CITY_EMPTY("0120"),
	ERROR_MEMBRE_NEW_ADDRES_MANSION_EMPTY("0121"),
	ERROR_MEMBER_NEW_TELNUMBER_CHECK("0122"),
	ERROR_MEMBER_NEW_TELNUMBER_EMPTY("0123"),
	ERROR_MEMBER_NEW_XSS("0124"),
	ERROR_MEMBER_NEW_MAIL_EMPTY("0125"),
	ERROR_MEMBER_NEW_PASS_EMPTY("0126"),
	ERROR_MEMBER_NEW_NAME_HURIGANA_CODE("0127"),
	
	
	//その他のエラー
	ERROR_SESSION_INVLIDATE("9901"),
	ERROR_SYSTEM_ERROR("9999"),
	;
	private String code;

	private CodeError(String code){ 
		this.code = code; 
	}

	public String getCode(){ 
		return code;
	}
	
}
