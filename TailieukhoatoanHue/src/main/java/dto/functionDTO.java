package dto;

import java.io.Serializable;

public class functionDTO implements Serializable  {
	private int functionId;
	private String functionName;
	private String description;
	private int createById;
	private int lastModifiedById;
	private String creationDate;
	private String lastModifiedDate;
	public functionDTO() {
		
	}
	
	public functionDTO(int functionId, String functionName, String description, int createById,
			int lastModifiedById, String creationDate, String lastModifiedDate) {
		super();
		this.functionId = functionId;
		this.functionName = functionName;
		this.description = description;
		this.createById = createById;
		this.lastModifiedById = lastModifiedById;
		this.creationDate=creationDate;
		this.lastModifiedDate=lastModifiedDate;
	}
	

	public functionDTO(String functionName, String description, int createById, int lastModifiedById) {
		super();
		this.functionName = functionName;
		this.description = description;
		this.createById = createById;
		this.lastModifiedById = lastModifiedById;
	}

	public int getFunctionId() {
		return functionId;
	}
	public void setFunctionId(int functionId) {
		this.functionId = functionId;
	}
	public String getFunctionName() {
		return functionName;
	}
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
