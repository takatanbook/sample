package jp.ac.asojuku.bookstore.error;

import java.util.ArrayList;
import java.util.List;

import jp.ac.asojuku.bookstore.config.MessageProperty;
import jp.ac.asojuku.bookstore.exception.BookStoreSystemErrorException;


public class ErrorsAction {
	private List<ErrorAction>errList;
	public ErrorsAction(){
		errList = new ArrayList<ErrorAction>();
	}
	public void add(ErrorAction errObj){
		errList.add(errObj);
		
	}
	public void add(CodeError code, String message){
		errList.add( new ErrorAction(code,message));
		
	}
	public void add(CodeError code) throws BookStoreSystemErrorException{
		String errMsg = MessageProperty.getInstance().getErrorMsgFromErrCode(code);
		errList.add( new ErrorAction(code,errMsg));
	}
	public List<ErrorAction> getList(){
		return errList;
		
	}
	public boolean isHasErr(){
		return ( errList.size() == 0 ? false:true );
	}
	

}
