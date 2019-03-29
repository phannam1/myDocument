package dto;

public class questionDTO {
	private int questionId;
	private String questionName;
	private String time;
	private int createById;
	private int lastModifiedById;
	private String lastModifiedDate;
	public questionDTO() {
		
	}
	
	public questionDTO(int questionId, String questionName, String time, int createById, int lastModifiedById,
			String lastModifiedDate) {
		super();
		this.questionId = questionId;
		this.questionName = questionName;
		this.time = time;
		this.createById = createById;
		this.lastModifiedById = lastModifiedById;
		this.lastModifiedDate = lastModifiedDate;
	}

	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestionName() {
		return questionName;
	}
	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getCreateById() {
		return createById;
	}
	public void setCreateById(int createById) {
		this.createById = createById;
	}
	public int getLastModifiedById() {
		return lastModifiedById;
	}
	public void setLastModifiedById(int lastModifiedById) {
		this.lastModifiedById = lastModifiedById;
	}
	public String getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
}
