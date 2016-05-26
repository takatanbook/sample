package jp.ac.asojuku.bookstore.check;
/*
 *  @author TAKAMICHI TANAKA
 *  フォームから入力された情報が特殊な文字列が入っていなかを判定（XSSの対策）
 * */
public class EscapeHtmlTest {
	
	/**
	 * 引数で与えられた文字列に特集な文字列が入っていないか
	 * @param str
	 * @return msg (true or false)
	 */
	static public boolean escapeHTML(String str){
		// 文字列の結合を繰り返すため、StringBuffer（可変の文字列を扱う）を使用
		//StringBuffer escapeStr = new StringBuffer();
		boolean msg = true;
		for(int i=0; i < str.length(); i++){
			char c = str.charAt(i);

			if(c == '<'){
				msg = false;
			}
			else if(c == '>'){
				msg = false;
			}
			else if(c == '&'){
				msg = false;
			}
			else if(c == '"'){
				msg = false;
			}
			else if(c == '\''){
				msg = false;
			}
			else{
				msg = true;
			}
		}
		return msg;// 許容内であった場合(true)　それ以外は（false)
	}
}
