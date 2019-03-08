package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import dto.roleDTO;
import utils.DBConnector;
import utils.HashUtils;

public class roleDAO {
	final String READALLROLE = "SELECT ROLE.*,ACCOUNT.USERNAME FROM ACCOUNT LEFT JOIN ROLE ON ACCOUNT.ROLEID = ROLE.ROLEID";
	final String REGISTERROLE = "UPDATE ACCOUNT LEFT JOIN ROLE ON ACCOUNT.ROLEID = ROLE.ROLEID SET ACCOUNT.ROLEID = ?,ACCOUNT.lastModifiedById = ?  WHERE ACCOUNT.USERNAME = ? ";
	final String DELETEROLE = "UPDATE ACCOUNT LEFT JOIN ROLE ON ACCOUNT.ROLEID = ROLE.ROLEID SET ACCOUNT.ROLEID = NULL  WHERE ACCOUNT.USERNAME = ? "; 
	final String GETROLEBYUSERNAME = "SELECT ROLE.*,ACCOUNT.USERNAME FROM ACCOUNT LEFT JOIN ROLE ON ACCOUNT.ROLEID = ROLE.ROLEID WHERE USERNAME = ?";
	final String SEARCHLIKE = "SELECT ROLE.*,ACCOUNT.USERNAME FROM ACCOUNT LEFT JOIN ROLE ON ACCOUNT.ROLEID = ROLE.ROLEID WHERE account.USERNAME LIKE ?" ;
	Connection con = null;
	HashUtils hashUtil = null;

	public roleDAO() {
		con = new DBConnector().getCon();
		hashUtil = new HashUtils();
	}

	public List<roleDTO> readAllRole() {
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(READALLROLE);
			if (rs != null) {
				List<roleDTO> list = new ArrayList<roleDTO>();
				while (rs.next()) {
					roleDTO role = new roleDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
							rs.getInt(5), rs.getString(6));
					list.add(role);
				}
				return list;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	public boolean updateRole(int roleId,String userName,int lastModifiedById) {
		try {
			PreparedStatement pr = con.prepareStatement(REGISTERROLE);
			pr.setInt(1, roleId);
			pr.setInt(2, lastModifiedById);
			pr.setString(3, userName);
			
			int i  = pr.executeUpdate();
			if(i!=0) {
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}
	public boolean deleteRole(String userName) {
		try {
			PreparedStatement pr = con.prepareStatement(DELETEROLE);
			if(userName.equals("")) {
				return false;
			}
			pr.setString(1, userName);
			int i  = pr.executeUpdate();
			if(i!=0) {
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}
	public roleDTO getRoleByUserName(String userName) {
		try {
			PreparedStatement pr = con.prepareStatement(GETROLEBYUSERNAME);
			pr.setString(1, userName);
			ResultSet rs = pr.executeQuery();
			if (rs != null) {				
				if (rs.next()) {
					roleDTO role = new roleDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
							rs.getInt(5), rs.getString(6));
					return role;
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	public List<roleDTO> searchLike(String value) {
		try {
			PreparedStatement pr = con.prepareStatement(SEARCHLIKE);
			pr.setString(1,'%' + value + '%');
			ResultSet rs = pr.executeQuery();
			if (rs != null) {	
				List<roleDTO> list = new ArrayList<roleDTO>();
				while (rs.next()) {
					roleDTO role = new roleDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
							rs.getInt(5), rs.getString(6));
					list.add(role);
				}
				return list;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
