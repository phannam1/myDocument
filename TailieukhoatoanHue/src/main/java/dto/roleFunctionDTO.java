package dto;

import java.io.Serializable;

public class roleFunctionDTO implements Serializable  {
	private int roleFunctionId;
	private int roleId;
	private int functionId;
	private String description;
	private int createById;
	private int lastModifiedById;
	private String roleName;
	private String functionName;
	public roleFunctionDTO() {
		
	}
	public roleFunctionDTO(int roleFunctionId, int roleId, int functionId, String description, int createById,
			int lastModifiedById, String roleName, String functionName) {
		super();
		this.roleFunctionId = roleFunctionId;
		this.roleId = roleId;
		this.functionId = functionId;
		this.description = description;
		this.createById = createById;
		this.lastModifiedById = lastModifiedById;
		this.roleName = roleName;
		this.functionName = functionName;
	}
	
	public roleFunctionDTO(int roleId, int functionId, String description, int createById, int lastModifiedById
			) {
		super();
		this.roleId = roleId;
		this.functionId = functionId;
		this.description = description;
		this.createById = createById;
		this.lastModifiedById = lastModifiedById;
		
	}
	public int getRoleFunctionId() {
		return roleFunctionId;
	}
	public void setRoleFunctionId(int roleFunctionId) {
		this.roleFunctionId = roleFunctionId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getFunctionId() {
		return functionId;
	}
	public void setFunctionId(int functionId) {
		this.functionId = functionId;
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
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getFunctionName() {
		return functionName;
	}
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	
}
