package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.newsDTO;
import utils.DBConnector;
import utils.HashUtils;

public class newsDAO {
	final String READALLNEWS = "SELECT * FROM NEWS";
	Connection con = null;
	HashUtils hashUltils = null;
	public newsDAO() {
		con = new DBConnector().getCon();
		hashUltils = new HashUtils();
	}
	public List<newsDTO> readAll(){
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(READALLNEWS);
			if(rs!=null) {
				List<newsDTO> list = new ArrayList<newsDTO>();
				while(rs.next()) {
					newsDTO news = new newsDTO(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7));
					list.add(news);
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
