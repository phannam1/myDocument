package dto;

public class documentDTO {
	private int id;
	private String documentName;
	private String major;
	private String semester;
	private String subject;
	private int courseCredit;
	private String nameTeacher;
	private String typeData;
	private String linkData;
	private int downloads;
	private int isShow;
	private int createById;
	private int lastModifiedById;
	public documentDTO() {
		
	}
	
	public documentDTO(String documentName, String major, String semester, String subject, int courseCredit,
			String nameTeacher, String typeData, String linkData, int createById, int lastModifiedById) {
		super();
		this.documentName = documentName;
		this.major = major;
		this.semester = semester;
		this.subject = subject;
		this.courseCredit = courseCredit;
		this.nameTeacher = nameTeacher;
		this.typeData = typeData;
		this.linkData = linkData;
		this.createById = createById;
		this.lastModifiedById = lastModifiedById;
	}

	public documentDTO(int id, String documentName, String major, String semester, String subject, int courseCredit,
			String nameTeacher, String typeData, String linkData, int downloads, int isShow, int createById,
			int lastModifiedById) {
		super();
		this.id = id;
		this.documentName = documentName;
		this.major = major;
		this.semester = semester;
		this.subject = subject;
		this.courseCredit = courseCredit;
		this.nameTeacher = nameTeacher;
		this.typeData = typeData;
		this.linkData = linkData;
		this.downloads = downloads;
		this.isShow = isShow;
		this.createById = createById;
		this.lastModifiedById = lastModifiedById;
	}

	public documentDTO(String documentName, String major, String semester, String subject, int courseCredit,
			String nameTeacher) {
		super();
		this.documentName = documentName;
		this.major = major;
		this.semester = semester;
		this.subject = subject;
		this.courseCredit = courseCredit;
		this.nameTeacher = nameTeacher;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getCourseCredit() {
		return courseCredit;
	}
	public void setCourseCredit(int courseCredit) {
		this.courseCredit = courseCredit;
	}
	public String getNameTeacher() {
		return nameTeacher;
	}
	public void setNameTeacher(String nameTeacher) {
		this.nameTeacher = nameTeacher;
	}
	public String getTypeData() {
		return typeData;
	}
	public void setTypeData(String typeData) {
		this.typeData = typeData;
	}
	public String getLinkData() {
		return linkData;
	}
	public void setLinkData(String linkData) {
		this.linkData = linkData;
	}
	public int getDownloads() {
		return downloads;
	}
	public void setDownloads(int downloads) {
		this.downloads = downloads;
	}
	public int getIsShow() {
		return isShow;
	}
	public void setIsShow(int isShow) {
		this.isShow = isShow;
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
	
}
