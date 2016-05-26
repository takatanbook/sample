package jp.ac.asojuku.bookstore.entity;
import java.util.Date;
public class LoginLogEntity {
	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id セットする id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return member_id
	 */
	public String getMember_id() {
		return member_id;
	}
	/**
	 * @param member_id セットする member_id
	 */
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	/**
	 * @return date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date セットする date
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return date_logout
	 */
	public Date getDate_logout() {
		return date_logout;
	}
	/**
	 * @param date_logout セットする date_logout
	 */
	public void setDate_logout(Date date_logout) {
		this.date_logout = date_logout;
	}
	public static String MEMBER_ID = "id";
	public static String MEMBER_MAIL = "memb_id";
	public static String LOGIN_DATE = "login_date";
	public static String LOGOUT_DATE = "logout_date";
	
	private int id;
	private String member_id;
	private Date date;
	private Date date_logout;
	

}
