package dto;

public class functionDTO {
	private int functionId;
	private String functionName;
	private String description;
	private String 	createById;
	private String lastModifiedById;
	public functionDTO() {
		
	}
	
	public functionDTO(int functionId, String functionName, String description, String createById,
			String lastModifiedById) {
		super();
		this.functionId = functionId;
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
	public String getCreateById() {
		return createById;
	}
	public void setCreateById(String createById) {
		this.createById = createById;
	}
	public String getLastModifiedById() {
		return lastModifiedById;
	}
	public void setLastModifiedById(String lastModifiedById) {
		this.lastModifiedById = lastModifiedById;
	}
	
}
