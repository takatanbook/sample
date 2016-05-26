package jp.ac.asojuku.bookstore.check;

/*
 * @author TAKAMICHI TANAKA
 * フォームから入力された値を検査するクラス
 * ！エクスクラメーション
 * 
 * */
public class CheckSecurity {
	//ひらがなの正規表現(Unicode １６進数　ひらがなの範囲)
	private static final String P_HIRAGANA_ONLY = "^[\\u3040-\\u309F]+$";
	//漢字の正規表現(Unicode １６進数　漢字の範囲)
	private static final String P_KANG_ONLY = "^[\\u4E00-\\u9FFF]+$";
	//郵便番号の正規表現
	private static final String P_ZIPCODE	    = "^\\d{3}(-\\d{4}|-\\d{2}|)$";
	//電話番号の正規表現
	private static final String P_NUMBER        = "^0\\d{1,4}-\\d{1,4}-\\d{4}$";
	//メールアドレスの正規表現
	private static final String P_MAILADDRES    = "^[a-zA-Z0-9!#$%&'_`/=~\\*\\+\\-\\?\\^\\{\\|\\}]+(\\.[a-zA-Z0-9!#$%&'_`/=~\\*\\+\\-\\?\\^\\{\\|\\}]+)*+(.*)@[a-zA-Z0-9][a-zA-Z0-9\\-]*(\\.[a-zA-Z0-9\\-]+)+$";

	//文字数を検査する（文字列、最小値、最大値）
	public static boolean stringLengthCheck(String input, int min, int max) {
		//フラグの設定
		boolean msg = true;
	    // 長さであるかを取得
	    int length = input.length();
	    if(length < min) { // 最小文字数よりも少なかった場合
	    	msg = false;
	    }
	    if(length > max) { // 最大文字数よりも多かった場合
	    	msg = false;
	    }
	    return msg; // 許容内であった場合(true)　それ以外は（false)
	}
	/* 
	 * 郵便番号チェック（return true or false）
	 * str値は、入力される値
	 */
	public static boolean isZipCode(String str) {
		//あたいが正規表現の値とマッチするか
        return str.matches(P_ZIPCODE);
    }
	
	/*
	 * 平仮名チェック（return true or false）
	 * str値は、入力される値
	 * */
	public static boolean isHiraganaOnly(String str) {
		//あたいが正規表現の値とマッチするか
	    return str.matches(P_HIRAGANA_ONLY);
	}
	/*電話番号チェック（return true or false）
	 * str値は、入力される値
	 */
	public static boolean isNumber(String str){
		//あたいが正規表現の値とマッチするか
		return str.matches(P_NUMBER);
		
	}
	
	/*漢字チェック（return true or false）
	 * str値は、入力される値
	 */
	public static boolean isKanji(String str){
		//あたいが正規表現の値とマッチするか
		return str.matches(P_KANG_ONLY );
		
	}
	
	/*
	 *メールアドレスをチェック（return true or false） 
	 *str値は、入力される値
	 * */
	public static boolean isMail(String str){
		//あたいが正規表現の値とマッチするか
		return str.matches(P_MAILADDRES);
	}
	
	/* 二つの文字列が一致チェック（return true or false）
	 * str値は、入力される値
	 * */
	public static boolean matc(String str1, String str2){
		//フラグの設定
		boolean data = true;
		//値が女性か男性か？
		if(str1.equals(str2)){
			data = false;
		}
		return data;
	}
	
	/* 文字列が空かnullチェック（return true or false）
	 * str値は、入力される値
	 * */
	public static boolean isEmpty(String value){
		//フラグの設定
		boolean msg = true;
		if(value == null || value.length() == 0){
			msg = false;
		}
		return msg;
	}


}
