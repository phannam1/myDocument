package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.questionDTO;
import utils.DBConnector;
import utils.HashUtils;

public class questionDAO {
	final String READALLQUESTION = "SELECT * FROM QUESTION ORDER BY dateTime desc";
	Connection con = null;
	HashUtils hashUltils = null;
	public questionDAO() {
		con = new DBConnector().getCon();
		hashUltils = new HashUtils();
	}
	public List<questionDTO> readAllQuestion(){
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(READALLQUESTION);
			if(rs!=null) {
				List<questionDTO> list = new ArrayList<>();
				while(rs.next()) {
					questionDTO question = new questionDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6));
					list.add(question);
				}
				return list;	
			}
		} catch (SQLException e) {
						e.printStackTrace();
		}
		
		return null;
	}
}
