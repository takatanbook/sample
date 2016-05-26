package jp.ac.asojuku.bookstore.dto;

public class SystemError {
	/**
	 * @return systemError
	 */
	public String getSystemError() {
		return SystemError;
	}

	/**
	 * @param systemError セットする systemError
	 */
	public void setSystemError(String systemError) {
		SystemError = systemError;
	}

	/**
	 * @return mailError
	 */
	public String getMailError() {
		return MailError;
	}

	/**
	 * @param mailError セットする mailError
	 */
	public void setMailError(String mailError) {
		MailError = mailError;
	}

	private String MailError;
	private String SystemError;
	

}
