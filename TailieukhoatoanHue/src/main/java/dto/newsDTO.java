package dto;

import java.sql.Date;

public class newsDTO {
	private int newsId;
	private String title;
	private String dateTime;
	private String pictureLink;
	private String content;
	private int createById;
	private int lastModifiedById;
	public newsDTO() {
		
	}
	public newsDTO(int newsId, String title, String dateTime, String pictureLink, String content, int createById,
			int lastModifiedById) {
		super();
		this.newsId = newsId;
		this.title = title;
		this.dateTime = dateTime;
		this.pictureLink = pictureLink;
		this.content = content;
		this.createById = createById;
		this.lastModifiedById = lastModifiedById;
	}
	
	public newsDTO(String title, String pictureLink, String content, int createById, int lastModifiedById) {
		super();
		this.title = title;
		this.pictureLink = pictureLink;
		this.content = content;
		this.createById = createById;
		this.lastModifiedById = lastModifiedById;
	}
	
	public newsDTO(int newsId, String title, String pictureLink, String content, int lastModifiedById) {
		super();
		this.newsId = newsId;
		this.title = title;
		this.pictureLink = pictureLink;
		this.content = content;
		this.lastModifiedById = lastModifiedById;
	}
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getPictureLink() {
		return pictureLink;
	}
	public void setPictureLink(String pictureLink) {
		this.pictureLink = pictureLink;
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
	public int getLastModifiedById() {
		return lastModifiedById;
	}
	public void setLastModifiedById(int lastModifiedById) {
		this.lastModifiedById = lastModifiedById;
	}
	
}
