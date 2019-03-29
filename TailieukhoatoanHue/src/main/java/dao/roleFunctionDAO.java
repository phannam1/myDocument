package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.roleFunctionDTO;
import utils.DBConnector;
import utils.HashUtils;

public class roleFunctionDAO {
	final String READALLROLEFUNCTION = "SELECT DISTINCT ROLEFUNCTION.* , ROLE.ROLENAME, function.functionName\r\n" + 
			"FROM rolefunction\r\n" + 
			"left JOIN ROLE ON ROLE.ROLEID = ROLEFUNCTION.ROLEID\r\n" + 
			"left JOIN mydocument.function ON  ROLEFUNCTION.functionId = function.functionId;\r\n" + 
			"";
	final String REGISTERROLEFUNCTION = "INSERT INTO ROLEFUNCTION(ROLEID,FUNCTIONID,DESCRIPTION,CREATEBYID,LASTMODIFIEDBYID) VALUES(?,?,?,?,?)";
	final String UPDATEROLEFUNCTION = "UPDATE ROLEFUNCTION SET ROLEID = ?, FUNCTIONID = ?, DESCRIPTION = ?, lastModifiedById = ?  WHERE ROLEFUNCTIONID = ?";
	final String DELETEROLEFUNCTION = "DELETE FROM ROLEFUNCTION WHERE ROLEFUNCTIONID = ?";
	final String SEARCHROLEFUNCTION = "SELECT ROLEFUNCTION.* , ROLE.ROLENAME, function.functionName FROM ((rolefunction left JOIN ROLE ON ROLE.ROLEID = ROLEFUNCTION.ROLEID )left JOIN mydocument.function ON  ROLEFUNCTION.functionId = function.functionId) where ROLE.ROLENAME like ? or function.functionName like ? or ROLEFUNCTION.description like ?";
	Connection con = null;
	HashUtils hashUtil = null;
	public roleFunctionDAO() {
		con = new DBConnector().getCon();
		hashUtil = new HashUtils();
	}
	public List<roleFunctionDTO> readAllRoleFunction(){
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(READALLROLEFUNCTION);
			if(rs!=null) {
				List<roleFunctionDTO> list = new ArrayList<roleFunctionDTO>();
				while(rs.next()) {
					roleFunctionDTO roleFunction = new roleFunctionDTO(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
					list.add(roleFunction);
				}
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public roleFunctionDTO registerRoleFunction(roleFunctionDTO roleFunction) {
		try {
			PreparedStatement pr = con.prepareStatement(REGISTERROLEFUNCTION);
			pr.setInt(1, roleFunction.getRoleId());
			pr.setInt(2, roleFunction.getFunctionId());
			pr.setString(3, roleFunction.getDescription());
			pr.setInt(4, roleFunction.getCreateById());
			pr.setInt(5, roleFunction.getLastModifiedById());
			int  i = pr.executeUpdate();
			if(i!=0) {
				return roleFunction;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	public boolean updateRoleFunction(int roleId,int functionId,String des, int lastModifiedById,int roleFunctionId) {
		try {
			PreparedStatement pr = con.prepareStatement(UPDATEROLEFUNCTION);
			pr.setInt(1, roleId);
			pr.setInt(2, functionId);
			pr.setString(3, des);
			pr.setInt(4, lastModifiedById);
			pr.setInt(5, roleFunctionId);
			int i = pr.executeUpdate();
			if(i!=0) {
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}
	public boolean deleteRoleFunction(int id) {
		try {
			PreparedStatement pr = con.prepareStatement(DELETEROLEFUNCTION);
			pr.setInt(1, id);
			int i = pr.executeUpdate();
			if(i!=0) {
				return true;
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return false;
	}
	public List<roleFunctionDTO> searchRoleFunction(String value){
		try {
			PreparedStatement pr = con.prepareStatement(SEARCHROLEFUNCTION);
			pr.setString(1, '%'+value+'%');
			pr.setString(2, '%'+value+'%');
			pr.setString(3, '%'+value+'%');
			ResultSet rs = pr.executeQuery();
			if(rs!=null) {
				List<roleFunctionDTO> list =  new ArrayList<roleFunctionDTO>();
				while(rs.next()) {
					roleFunctionDTO roleFunction = new roleFunctionDTO(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
					list.add(roleFunction);
				}
				return list;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return null;
	}
 }
