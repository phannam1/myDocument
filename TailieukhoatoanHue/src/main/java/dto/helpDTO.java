package dto;

import java.util.Date;

public class helpDTO {
	private int helpId;
	private String userName;
	private String content;
	private int createById;
	private String time;
	public helpDTO() {
		
	}
	public helpDTO( String content, int createById) {	
		this.content = content;
		this.createById = createById;
	}
	
	
	public helpDTO(int helpId, String content, int createById, String time, String userName) {
		super();
		this.helpId = helpId;
		this.userName = userName;
		this.content = content;
		this.createById = createById;
		this.time = time;
	}
	public int getHelpId() {
		return helpId;
	}
	public void setHelpId(int helpId) {
		this.helpId = helpId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCreateById() {
		return createById;
	}
	public void setCreateById(int createById) {
		this.createById = createById;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}