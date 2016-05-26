package jp.ac.asojuku.bookstore.dto;

public class LoginInfoDTO {
	/**
	 * @return memb_name
	 */
	public String getMemb_name() {
		return memb_name;
	}
	/**
	 * @param memb_name セットする memb_name
	 */
	public void setMemb_name(String memb_name) {
		this.memb_name = memb_name;
	}
	private String memb_id;
	private String memb_name;
	public String getMemb_id(){
		return memb_id;
	}
	public void setMemb_id(String memb_id){
		this.memb_id = memb_id; 	
	}
	

}
