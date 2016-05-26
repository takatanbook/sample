package jp.ac.asojuku.bookstore.check;
/*
 * @author TAKAMICHI TANAKA
 * 本当は　source　name　PullDownCheck
 * 間違えてそのままにしています
 * このクラスは、プルダウンメニューで選ばれたものが正しいかを判定
 * */
public class RdioCheck {
	 //日本の都道府県の配列
	private static final String[] prefe = new String[] {"北海道","青森県","岩手県","宮城県","秋田県","山形県","福島県",
			 "茨城県","栃木県","群馬県","埼玉県","千葉県","東京都","神奈川県",
			 "新潟県","富山県","石川県","福井県","山梨県","長野県","岐阜県",
			 "静岡県","愛知県","三重県","滋賀県","京都府","大阪府","兵庫県",
			 "奈良県","和歌山県","鳥取県","島根県","岡山県","広島県","山口県",
			 "徳島県","香川県","愛媛県","高知県","福岡県","佐賀県","長崎県",
			 "熊本県","大分県","宮崎県","鹿児島県","沖縄県"
			 };
	///private static final String[] names = new String[] {
		//"あ","い","う","え","お","か","き","く","け","こ","さ","し","す","せ","そ","た","ち","つ","て","と","な",
		//"に","ぬ","ね","の","は","ひ","ふ","へ","ほ","ま","み","む","め","も","や","ゆ","よ",
		//"ら","り","る","れ","ろ","わ","を","ん"
	//};
	//平仮名範囲をUnicode
	public static final String HIRAGANA_CODES = "\\u3040-\\u309F";
    //カタカナの範囲をUnicode
	public static final String KATAKANA_CODES = "\\u30A0-\\u30FF";
	
	//男性か女性をチェックします。
	public static  boolean Check1(String sex){
		//男性と女性の配列
		String[] sext = new String [] {"men","woman"};
		//フラグの設定
		boolean data = false;
		for (int i = 0; i < 2; i++){
			if (sex.equals(sext[i])){
				data = true;
			}
		}

		return data;// 許容内であった場合(true)　それ以外は（false)
	}
	//都道府県チェックをする
	public static  boolean Check2(String prefecture){
		//フラグの設定
		boolean data = false;
		//４７都道府県とプルダウメニューから選ばれた値が一致しているか
		for (int i = 0; i < 47; i++){
			if (prefecture.equals(prefe[i])){
				data = true;
			}
		}
		return data;// 許容内であった場合(true)　それ以外は（false)
	}
	//使わないメソッド(平仮名)
	/*
	public static boolean Check3(String name){
		boolean data = true;
		int num = names.length;
		for(int i =0; i < num; i++){
			if(name.equals(names[i])){
				data = false;
			}
		}
		return data;// 許容内であった場合(true)　それ以外は（false)
	}*/
	//平仮名かカタカナをチェックします。
	public static boolean Check4(String name){
		boolean msg = false;
		//平仮名かカタカナを正規表現で一致するか（カタカナとひらがなの正規表現を合体）
		if (name.matches(toMatchRegex(HIRAGANA_CODES + KATAKANA_CODES))) {
			msg = true;
		}
		return msg;// 許容内であった場合(true)　それ以外は（false)
	}
	//平仮名とカタカナをコードを合体
	public static String toMatchRegex(String codes) {
		return "^[" + codes + "]+$";
	}

}
