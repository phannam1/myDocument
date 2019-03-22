package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	final String REGISTERNEWS = "INSERT INTO NEWS(TITLE,PICTURELINK,CONTENT,CREATEBYID,LASTMODIFIEDBYID) VALUES (?,?,?,?,?)";
	final String UPDATENEWS = "UPDATE NEWS SET TITLE = ?, PICTURELINK = ?, CONTENT = ?, LASTMODIFIEDBYID = ? WHERE NEWSID = ?";
	final String DELETENEWS = "DELETE FROM NEWS WHERE NEWSID = ?";
	final String SEARCHNEWS = "SELECT * FROM NEWS WHERE TITLE LIKE ? OR PICTURELINK LIKE ? OR CONTENT LIKE ? OR DATETIME LIKE ? ";
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
	public boolean registerNews(newsDTO news) {
		try {
			PreparedStatement pr = con.prepareStatement(REGISTERNEWS);
			pr.setString(1, news.getTitle());
			pr.setString(2, news.getPictureLink());
			pr.setString(3, news.getContent());
			pr.setInt(4, news.getCreateById());
			pr.setInt(5, news.getLastModifiedById());
			int i = pr.executeUpdate();
			if(i!=0) {
				return true;
			}
		} catch (SQLException e) {
						e.printStackTrace();
		}
		return false;
	}
	public boolean updateNews(newsDTO news) {
		try {
			PreparedStatement pr = con.prepareStatement(UPDATENEWS);
			pr.setString(1, news.getTitle());
			pr.setString(2, news.getPictureLink());
			pr.setString(3, news.getContent());
			pr.setInt(4, news.getLastModifiedById());
			pr.setInt(5, news.getNewsId());
			int i = pr.executeUpdate();
			if(i!= 0 ) {
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}
	public boolean deleteNews(int Id) {
		try {
			PreparedStatement pr = con.prepareStatement(DELETENEWS);
			pr.setInt(1, Id);
			int  i = pr.executeUpdate();
			if(i!=0) {
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}
	public List<newsDTO> searchNews(String value){
		try {
			PreparedStatement pr = con.prepareStatement(SEARCHNEWS);
			pr.setString(1, '%'+value+'%');
			pr.setString(2, '%'+value+'%');
			pr.setString(3, '%'+value+'%');
			pr.setString(4, '%'+value+'%');
			ResultSet rs = pr.executeQuery();
			if(rs!=null) {
				List<newsDTO> list = new  ArrayList<newsDTO>();
				while(rs.next()) {
					newsDTO news = new newsDTO(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7));
					list.add(news);
				}
				return list;	
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
}
