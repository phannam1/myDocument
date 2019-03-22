package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import dto.documentDTO;
import utils.DBConnector;
import utils.HashUtils;

public class documentDAO {
	final String REGISTERDOCUMENT = "INSERT INTO DOCUMENT(documentName,major,semester,subject,courseCredit,nameTeacher,typeData,linkData,createById,lastModifiedById) VALUES(?,?,?,?,?,?,?,?,?,?) ";
	final String READALLDOCUMENT = "SELECT * FROM DOCUMENT WHERE ISSHOW = 0 order by lastModifiedDate desc ";
	final String UPDATEDOCUMENT = "UPDATE DOCUMENT SET ISSHOW = 1, lastModifiedById = ? WHERE DOCUMENTID = ? ";
	final String SEARCHBYVALUEINPUT = "SELECT * FROM DOCUMENT WHERE documentName LIKE ? AND isShow = 0 OR major LIKE ? AND isShow = 0 OR semester LIKE ? AND isShow = 0 OR subject LIKE ? AND isShow = 0 OR courseCredit LIKE ? AND isShow = 0 OR nameTeacher LIKE ? AND isShow = 0";
	Connection con = null;
	HashUtils hashUtil = null;
	public documentDAO() {
		con = new DBConnector().getCon();
		hashUtil = new HashUtils();
	}
	public boolean registerDocument(documentDTO document) {
		try {
			PreparedStatement pr = con.prepareStatement(REGISTERDOCUMENT);
			pr.setString(1, document.getDocumentName());
			pr.setString(2, document.getMajor());
			pr.setString(3, document.getSemester());
			pr.setString(4, document.getSubject());
			pr.setInt(5, document.getCourseCredit());
			pr.setString(6, document.getNameTeacher());
			pr.setString(7, document.getTypeData());
			pr.setString(8, document.getLinkData());
			pr.setInt(9, document.getCreateById());
			pr.setInt(10, document.getLastModifiedById());
			int i = pr.executeUpdate();
			if(i!=0) {
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}
	public List<documentDTO> readAllDocument(){
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(READALLDOCUMENT);
			if(rs!=null) {
				List<documentDTO> list = new ArrayList<>();
				while(rs.next()) {
					documentDTO document = new documentDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10),rs.getInt(11),rs.getInt(12),rs.getInt(13));
					list.add(document);
				}
				return list;
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		return null;
	}
	public boolean updateDocument(int lasId, int documentId) {
		try {
			PreparedStatement pr = con.prepareStatement(UPDATEDOCUMENT);
			pr.setInt(1, lasId);
			pr.setInt(2, documentId);
			int i = pr.executeUpdate();
			if(i!=0) {
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}
	public List<documentDTO> searchValueInput(String input){
		try {
			PreparedStatement pr = con.prepareStatement(SEARCHBYVALUEINPUT);
			pr.setString(1, '%'+input+'%');
			pr.setString(2, '%'+input+'%');
			pr.setString(3, '%'+input+'%');
			pr.setString(4, '%'+input+'%');
			pr.setString(5, '%'+input+'%');
			pr.setString(6, '%'+input+'%');
			ResultSet rs = pr.executeQuery();
			if(rs!=null) {
				List<documentDTO> list = new ArrayList<>();
				while(rs.next()) {
					documentDTO document = new documentDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10),rs.getInt(11),rs.getInt(12),rs.getInt(13));
					list.add(document);
				}
				return list;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
}
