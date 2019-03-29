package dto;

import java.io.Serializable;

public class roleDTO implements Serializable  {
	private int roleId;
	private String roleName;
	private String description;
	private int createById;
	private int lastModifiedById;
	private String userName;
	private String creationDate;
	private String lastModifiedDate;
	public roleDTO() {
		
	}
	
	public roleDTO(int roleId, String roleName, String description, int createById, int lastModifiedById, String creationDate, String lastModifiedDate,String userName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.description = description;
		this.createById = createById;
		this.lastModifiedById = lastModifiedById;
		this.userName = userName;
		this.creationDate=creationDate;
		this.lastModifiedDate=lastModifiedDate;
	}

	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
