package jp.ac.asojuku.bookstore.error;

public class ErrorAction {
	private CodeError code;
	private String message;
	
	public ErrorAction(CodeError code, String message){
		this.code = code;
		this.message = message;
	}
	/**
	 * @return code
	 */
	public CodeError getCode() {
		return code;
	}

	/**
	 * @param code セットする code
	 */
	public void setCode(CodeError code) {
		this.code = code;
	}

	/**
	 * @return message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message セットする message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	
	
}
