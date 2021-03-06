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
	private int views;
	private int isShow;
	private int createById;
	private int lastModifiedById;
	private String createdUserName;
	private String lastModifiedUserName;
	private String creationDate;
	private String lastModifiedDate;
	public documentDTO() {
		
	}
	
	public documentDTO(int id, String documentName, String major, String semester, String subject, int courseCredit,
			String nameTeacher, String typeData, String linkData, int views, int isShow, int createById,
			int lastModifiedById, String creationDate, String lastModifiedDate, String userName,String userName1) {
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
		this.views = views;
		this.isShow = isShow;
		this.createById = createById;
		this.lastModifiedById = lastModifiedById;
		this.createdUserName = userName;
		this.lastModifiedUserName = userName1;
		this.creationDate = creationDate;
		this.lastModifiedDate = lastModifiedDate;
	}

	public documentDTO(int id, String documentName, String major, String semester, String subject, int courseCredit,
			String nameTeacher, int isShow, int lastModifiedById) {
		super();
		this.id = id;
		this.documentName = documentName;
		this.major = major;
		this.semester = semester;
		this.subject = subject;
		this.courseCredit = courseCredit;
		this.nameTeacher = nameTeacher;
		this.isShow = isShow;
		this.lastModifiedById = lastModifiedById;
	}

	public documentDTO( String documentName, String major, String semester, String subject, int courseCredit,
			String nameTeacher,String typeData, String linkData, int isShow, int createById, int lastModifiedById) {
		super();
	
		this.documentName = documentName;
		this.major = major;
		this.semester = semester;
		this.subject = subject;
		this.courseCredit = courseCredit;
		this.nameTeacher = nameTeacher;
		this.typeData = typeData;
		this.linkData = linkData;
		this.isShow = isShow;
		this.createById = createById;
		this.lastModifiedById = lastModifiedById;
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
			String nameTeacher, String typeData, String linkData, int views, int isShow, int createById,
			int lastModifiedById,String creationDate, String lastModifiedDate,String userName) {
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
		this.views = views;
		this.isShow = isShow;
		this.createById = createById;
		this.lastModifiedById = lastModifiedById;
		this.createdUserName = userName;
	
		this.creationDate = creationDate;
		this.lastModifiedDate = lastModifiedDate;
	}

	public documentDTO(int id, String documentName, String major, String semester, String subject, int courseCredit,
			String nameTeacher, String typeData, String linkData, int views, int isShow, int createById,
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
		this.views = views;
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
	
	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
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

	

	public String getCreatedUserName() {
		return createdUserName;
	}

	public void setCreatedUserName(String createdUserName) {
		this.createdUserName = createdUserName;
	}

	public String getLastModifiedUserName() {
		return lastModifiedUserName;
	}

	public void setLastModifiedUserName(String lastModifiedUserName) {
		this.lastModifiedUserName = lastModifiedUserName;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
}
