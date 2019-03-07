package dto;

public class roleDTO {
	private int roleId;
	private String roleName;
	private String description;
	private int createById;
	private int lastModifiedById;
	private String userName;
	public roleDTO() {
		
	}
	
	public roleDTO(int roleId, String roleName, String description, int createById, int lastModifiedById,String userName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.description = description;
		this.createById = createById;
		this.lastModifiedById = lastModifiedById;
		this.userName = userName;
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
	
}
