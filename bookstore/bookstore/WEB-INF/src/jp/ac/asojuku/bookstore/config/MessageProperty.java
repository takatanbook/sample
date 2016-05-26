package jp.ac.asojuku.bookstore.config;
import jp.ac.asojuku.bookstore.error.CodeError;
import jp.ac.asojuku.bookstore.exception.BookStoreSystemErrorException;
public class MessageProperty extends ConfigBase{

	public MessageProperty() throws BookStoreSystemErrorException{
		super();
	}

	//シングルトン
	private static MessageProperty prop = null;
	private static final String CONFIG_NAME = "message.properties";
	/** 設定パラメータ */
	public static final String LOGIN_ERR_LOGINERR = "login.err.loginerr";
	public static final String ERR_PROP_PREFIX = "errmsg";
  //インスタンスの取得
	public static MessageProperty getInstance() throws BookStoreSystemErrorException{
		if (prop == null){
			//Propertiesクラスがプロパティファイルの内容を読み込みます
			prop = new MessageProperty();
		}
		return prop;
	}
	//エラーコードよりエラーメッセージを取得する
	public String getErrorMsgFromErrCode(CodeError code){

		return getProperty(ERR_PROP_PREFIX+code.getCode());
	}
	//　コンフィグファイルの名前を返す
	protected String getConfigName(){
		return CONFIG_NAME;

	}

}
