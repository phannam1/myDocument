package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.accountDTO;
import dto.functionDTO;
import utils.DBConnector;
import utils.HashUtils;

public class functionDAO {
	final String READALLFUNCTION = "SELECT * FROM MYDOCUMENT.FUNCTION ";
	final String REGISTERFUNCTION = "INSERT INTO MYDOCUMENT.FUNCTION(functionName,description,createById,lastModifiedById) VALUES(?,?,?,?)";
	final String UPDATEFUNCTION = "UPDATE FUNCTION SET FUNCTIONNAME = ? , DESCRIPTION = ? ,lastModifiedById = ? WHERE FUNCTIONID = ?";
	Connection con = null;
	HashUtils hashUtil = null;

	public functionDAO() {
		con = new DBConnector().getCon();
		hashUtil = new HashUtils();
	}
	public List<functionDTO> readAllFuction(){
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(READALLFUNCTION);
			if(rs!=null) {
				 List<functionDTO> list = new ArrayList<functionDTO>();
				while(rs.next()) {
					functionDTO function = new functionDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
					list.add(function);
				}
				return list;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
	public functionDTO registerFunction(functionDTO function) {
		try {
			PreparedStatement pr = con.prepareStatement(REGISTERFUNCTION);
			pr.setString(1, function.getFunctionName());
			pr.setString(2, function.getDescription());
			pr.setInt(3, function.getCreateById());
			pr.setInt(4, function.getLastModifiedById());
			int i = pr.executeUpdate();
			if(i!=0) {
				return function;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	public boolean updateFunction(int id,String functionName,String description,int lastModifiedById) {
		try {
			PreparedStatement pr = con.prepareStatement(UPDATEFUNCTION);
			pr.setString(1, functionName);
			pr.setString(2, description);
			pr.setInt(3, lastModifiedById);
			pr.setInt(4, id);
			int i = pr.executeUpdate();
			if(i!=0) {
				return true;
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return false;
		
	}
}
