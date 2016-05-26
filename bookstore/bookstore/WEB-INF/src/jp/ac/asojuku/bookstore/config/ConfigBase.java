package jp.ac.asojuku.bookstore.config;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import jp.ac.asojuku.bookstore.exception.BookStoreSystemErrorException;
//コンフィグクラスのベースクラス
public abstract class ConfigBase {
	/*
	*プロパティファイルを使用するには、
	*JavaのコアAPIとして用意されているjava.util.Propertiesクラスを利用します。
	*このPropertiesクラスは、サブクラス化する必要もなく、
	*そのままインスタンス化して用いることができます。
	*/

	private Properties config = new Properties();



	public ConfigBase() throws BookStoreSystemErrorException{
		InputStream inputStream;
		try{
		//クラス・ローダーを呼び出して、そのクラス・ローダーに
		//ファイルをクラスパスから探させていました。

		inputStream = this.getClass().getClassLoader().getResourceAsStream(getConfigName());
		/*
		*メソッドを用いてプロパティファイルを読み込んでおけば、
		*Propertiesフィールドを通して、どのメソッドから
		*もプロパティファイルの値を参照できるようになりま
		*す。
		*/
		config.load(inputStream);

		} catch (FileNotFoundException e){
			// システムエラー
			throw new BookStoreSystemErrorException(e);

		} catch (IOException e){
			// システムエラー
			throw new BookStoreSystemErrorException(e);
		}
	}

	//コンフィグファイルから情報取得する
	public String getProperty(String paramName){

		return config.getProperty(paramName);

	}
	abstract protected String getConfigName();

}
