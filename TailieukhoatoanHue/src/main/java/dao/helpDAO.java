package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.helpDTO;
import dto.roleDTO;
import utils.DBConnector;
import utils.HashUtils;

public class helpDAO {
	final String CREATEHELP = "INSERT INTO HELP(CONTENT,CREATEBYID) VALUES(?,?) ";
	final String READALLHELP = "SELECT HELP.*,ACCOUNT.USERNAME FROM HELP INNER JOIN ACCOUNT ON ACCOUNT.ACCOUNTID = HELP.CREATEBYID order by time desc ";
	Connection con = null;
	HashUtils hashUtil = null;

	public helpDAO() {
		con = new DBConnector().getCon();
		hashUtil = new HashUtils();
	}
	public boolean createHelp(helpDTO help) {
		try {
			PreparedStatement pr = con.prepareStatement(CREATEHELP);
			pr.setString(1, help.getContent());
			pr.setInt(2, help.getCreateById());
			int i = pr.executeUpdate();
			if(i!=0) {
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}
	public List<helpDTO> readAll(){
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(READALLHELP);
			if(rs!=null) {
				List<helpDTO> list  = new ArrayList<helpDTO>();
				while(rs.next()) {
					helpDTO help = new helpDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),rs.getString(5));
					list.add(help);
				}
				return list;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
}
