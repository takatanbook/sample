package jp.ac.asojuku.bookstore.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class BookStoreSystemErrorException extends Exception{
	//LoggerFactpry.getLogger(Class)メソッドを使ってLoggerインスタンスを取得する。
	Logger logger = LoggerFactory.getLogger(BookStoreSystemErrorException.class);
	/*警告を消すためには，１つメソッドを定義するごとに毎回，
	 * 「@SuppressWarnings("unused")」のアノテーションを付与しなければならない。
	 */
	@SuppressWarnings("unused")
	private BookStoreSystemErrorException(){
		
	}
	
	public BookStoreSystemErrorException(Exception e){
		//error out
		logger.info("BookStoreSystemErrorException",e);
	}
	
	public BookStoreSystemErrorException(Exception e,String msg){
		//error out
		logger.info("BookStoreSystemErrorException",e);
	}

}
