package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import controller.document;
import dto.documentDTO;
import utils.DBConnector;
import utils.HashUtils;

public class documentDAO {
	final String REGISTERDOCUMENT = "INSERT INTO DOCUMENT(documentName,major,semester,subject,courseCredit,nameTeacher,typeData,linkData,createById,lastModifiedById) VALUES(?,?,?,?,?,?,?,?,?,?) ";
	final String READALLDOCUMENT = "SELECT * FROM DOCUMENT WHERE ISSHOW = 0 order by lastModifiedDate desc ";
	final String UPDATEDOCUMENT = "UPDATE DOCUMENT SET ISSHOW = 1, lastModifiedById = ? WHERE DOCUMENTID = ? ";
	final String SEARCHBYVALUEINPUT = "SELECT * FROM DOCUMENT WHERE documentName LIKE ? AND isShow = 0 OR major LIKE ? AND isShow = 0 OR semester LIKE ? AND isShow = 0 OR subject LIKE ? AND isShow = 0 OR courseCredit LIKE ? AND isShow = 0 OR nameTeacher LIKE ? AND isShow = 0";
	final String READALLDOCUMENTSHOW = "SELECT * FROM DOCUMENT WHERE ISSHOW = 1 order by lastModifiedDate desc ";
	final String GETDOCUMENTBYID = "SELECT * FROM DOCUMENT WHERE DOCUMENTID = ?";
	final String SEARCHDETAILDOCUMENT = "SELECT * FROM DOCUMENT WHERE documentName like ? AND isShow = 1 AND major = ? AND isShow = 1 AND semester = ? AND isShow = 1  AND subject = ? AND isShow = 1  AND courseCredit = ? AND isShow = 1 OR nameTeacher  like ?  AND isShow = 1  ";
	final String READLIMITDOWNLOADS = "SELECT * FROM DOCUMENT WHERE ISSHOW = 1 ORDER BY downloads DESC LIMIT 5";
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
	public List<documentDTO> readAllDocumentShow(){
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(READALLDOCUMENTSHOW);
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
	public documentDTO getDocumentById(int id) {
		try {
			PreparedStatement pr = con.prepareStatement(GETDOCUMENTBYID);
			pr.setInt(1, id);
			ResultSet rs = pr.executeQuery();
			if(rs!=null) {
				if(rs.next()) {
					documentDTO document = new documentDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10),rs.getInt(11),rs.getInt(12),rs.getInt(13));
					return document;
				}
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	public List<documentDTO> searchDetailDocument(documentDTO document){
		try {
			PreparedStatement pr = con.prepareStatement(SEARCHDETAILDOCUMENT);
			pr.setString(1, '%'+document.getDocumentName()+'%');
			pr.setString(2, document.getMajor());
			pr.setString(3, document.getSemester());
			pr.setString(4, document.getSubject());
			pr.setInt(5, document.getCourseCredit());
			pr.setString(6, '%'+document.getNameTeacher()+'%');
			ResultSet rs = pr.executeQuery();
			if(rs!=null) {
				List<documentDTO> list = new ArrayList<>();
				while(rs.next()) {
					documentDTO document1 = new documentDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10),rs.getInt(11),rs.getInt(12),rs.getInt(13));
					list.add(document1);
				}
				return list;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	public List<documentDTO> searchDownloads(){
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(READLIMITDOWNLOADS);
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
