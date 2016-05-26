package jp.ac.asojuku.bookstore.security;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecutityUtil {
	
	/**
	* 文字列をハッシュ化するメソッド
	*
	* @param text ハッシュ化するテキスト
	*
	* @return ハッシュ化した計算値(16進数)
	* 
	* このサンプルコードはパスワードをSHA-256で暗号化してるんだけど、
	* じゃあどうやって復号すんの？って思いますよね。
	* ハッシュ関数なんだから、一方通行の暗号化です。そのまま復号ってのは不可能。
	*/
	public static String ecryptStr(String text){
		//変数初期化
		/* メッセージダイジェストアルゴリズム */
		MessageDigest md = null;
		//空のオブジェクトを生成する。　ただし、後の文字列の追加に備えて16文字分のメモリ領域を伴う
		// StringBufferクラスの参照型変数に、
        // StringBufferクラスのインスタンスへの参照を格納します。
	    StringBuffer buffer = new StringBuffer();
	    /*
		 * 引数でメッセージダイジェストアルゴリズムを指定する。
		 * MD2, MD5, SHA, SHA-256, SHA-384, SHA-512が利用可能。
		 */
	    try {
	        // メッセージダイジェストインスタンス取得
	        md = MessageDigest.getInstance("SHA-256");
	    } catch (NoSuchAlgorithmException e) {
	        // 例外発生時、エラーメッセージ出力
	        System.out.println("指定された暗号化アルゴリズムがありません");
	    }
	    
	    // メッセージダイジェストアルゴリズムを使い、文字列をハッシュ値へ変換する。
	    // メッセージダイジェスト更新
	    md.update(text.getBytes());

	    // ハッシュ値を格納
	    byte[] valueArray = md.digest();

	    // ハッシュ値の配列をループ
	    for(int i = 0; i < valueArray.length; i++){
	        // 値の符号を反転させ、16進数に変換(255)
	        String tmpStr = Integer.toHexString(valueArray[i] & 0xff);

	        if(tmpStr.length() == 1){
	            // 値が一桁だった場合、先頭に0を追加し、バッファに追加
	            buffer.append('0').append(tmpStr);
	        } else {
	            // その他の場合、バッファに追加
	            buffer.append(tmpStr);
	        }
	    }

	    //完了したハッシュ計算値を返却
	    return buffer.toString();
	}
}