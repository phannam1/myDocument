package dao;

import java.io.Console;
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
	final String CREATEDOCUMENTADMIN = "INSERT INTO DOCUMENT(documentName,major,semester,subject,courseCredit,nameTeacher,typeData,linkData,isShow,createById,lastModifiedById) VALUES(?,?,?,?,?,?,?,?,?,?,?) ";
	final String READALLDOCUMENT = "SELECT DOCUMENT.*,a1.USERNAME AS 'createUSer',a2.USERNAME AS 'lastmodifiedUser' FROM DOCUMENT JOIN ACCOUNT a1 ON DOCUMENT.createbyid = a1.ACCOUNTID JOIN ACCOUNT a2 ON DOCUMENT.lastModifiedById = a2.ACCOUNTID  order by lastModifiedDate desc ";
	final String READLASBYID = "SELECT ACCOUNT.USERNAME  FROM DOCUMENT INNER JOIN ACCOUNT ON DOCUMENT.lastModifiedById = ACCOUNT.ACCOUNTID where createbyid = ?  order by lastModifiedDate desc";
	final String UPDATEDOCUMENT = "UPDATE DOCUMENT SET documentName = ?,major = ?,semester= ?,subject = ?,courseCredit = ?,nameTeacher=?, ISSHOW = ?, lastModifiedById = ? WHERE DOCUMENTID = ? ";
	final String SEARCHBYVALUEINPUT = "SELECT DOCUMENT.*,ACCOUNT.USERNAME FROM DOCUMENT INNER JOIN ACCOUNT ON DOCUMENT.CREATEBYID = ACCOUNT.ACCOUNTID  WHERE documentName LIKE ?  OR major LIKE ?  OR semester LIKE ?  OR subject LIKE ?  OR courseCredit LIKE ?  OR nameTeacher LIKE ? ";
	private String SEARCHDOCUMENT = "SELECT * FROM DOCUMENT WHERE ";
	final String READALLDOCUMENTSHOW = "SELECT * FROM DOCUMENT WHERE ISSHOW = 1 order by lastModifiedDate desc ";
	final String GETDOCUMENTBYID = "SELECT * FROM DOCUMENT WHERE DOCUMENTID = ?";
	final String READLIMITDOWNLOADS = "SELECT * FROM DOCUMENT WHERE ISSHOW = 1 ORDER BY views DESC LIMIT 5";
	final String GETVIEWS = "SELECT VIEWS FROM DOCUMENT WHERE DOCUMENTID = ? AND ISSHOW = 1";
	final String UPDATEVIEWS = "UPDATE DOCUMENT SET VIEWS = ? WHERE VIEWS = ? AND DOCUMENTID = ? ";
	final String READDOCUMENTBYID = "SELECT DOCUMENT.*,a1.USERNAME AS 'createUSer',a2.USERNAME AS 'lastmodifiedUser'  FROM DOCUMENT JOIN ACCOUNT a1 ON DOCUMENT.createbyid = a1.ACCOUNTID JOIN ACCOUNT a2 ON DOCUMENT.lastModifiedById = a2.ACCOUNTID where createbyid = ? order by lastModifiedDate desc ";
	final String DELETEDOCUMENT = "DELETE FROM DOCUMENT WHERE DOCUMENTID = ? ";

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
			if (i != 0) {
				return true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}
	public boolean registerDocumentAdmin(documentDTO document) {
		try {
			PreparedStatement pr = con.prepareStatement(CREATEDOCUMENTADMIN);
			pr.setString(1, document.getDocumentName());
			pr.setString(2, document.getMajor());
			pr.setString(3, document.getSemester());
			pr.setString(4, document.getSubject());
			pr.setInt(5, document.getCourseCredit());
			pr.setString(6, document.getNameTeacher());
			pr.setString(7, document.getTypeData());
			pr.setString(8, document.getLinkData());
			pr.setInt(9, document.getIsShow());
			pr.setInt(10, document.getCreateById());
			pr.setInt(11, document.getLastModifiedById());
			int i = pr.executeUpdate();
			if (i != 0) {
				return true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

	public List<documentDTO> readAllDocument() {
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(READALLDOCUMENT);
			if (rs != null) {
				List<documentDTO> list = new ArrayList<>();
				while (rs.next()) {
					documentDTO document = new documentDTO(rs.getInt(1), rs.getString(2), rs.getString(3),
							rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8),
							rs.getString(9), rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(13),rs.getString(14),rs.getString(15),rs.getString(16),rs.getString(17));
					list.add(document);
				}
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	public List<documentDTO> readDocumentById(int id) {
		try {
			PreparedStatement pr = con.prepareStatement(READDOCUMENTBYID);
			pr.setInt(1, id);
			ResultSet rs = pr.executeQuery();
			if (rs != null) {
				List<documentDTO> list = new ArrayList<>();
				while (rs.next()) {
					documentDTO document = new documentDTO(rs.getInt(1), rs.getString(2), rs.getString(3),
							rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8),
							rs.getString(9), rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(13),rs.getString(14),rs.getString(15),rs.getString(16),rs.getString(17));
					list.add(document);
				}
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	public List<String> readLasId(int id) {
		try {
			PreparedStatement pr = con.prepareStatement(READLASBYID);
			pr.setInt(1, id);
			ResultSet rs = pr.executeQuery();
			if(rs!=null) {
				List<String> list = new ArrayList<>();
				while(rs.next()) {
					list.add(rs.getString(1));
				}
				return list;
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return null;
	}


	public boolean updateDocument(documentDTO document) {
		try {
			PreparedStatement pr = con.prepareStatement(UPDATEDOCUMENT);
			pr.setString(1, document.getDocumentName());
			pr.setString(2, document.getMajor());
			pr.setString(3, document.getSemester());
			pr.setString(4, document.getSubject());
			pr.setInt(5, document.getCourseCredit());
			pr.setString(6, document.getNameTeacher());
			pr.setInt(7, document.getIsShow());
			pr.setInt(8, document.getLastModifiedById());
			pr.setInt(9, document.getId());
			int i = pr.executeUpdate();
			if (i != 0) {
				return true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

	public List<documentDTO> searchValueInput(String input) {
		try {
			PreparedStatement pr = con.prepareStatement(SEARCHBYVALUEINPUT);
			pr.setString(1, '%' + input + '%');
			pr.setString(2, '%' + input + '%');
			pr.setString(3, '%' + input + '%');
			pr.setString(4, '%' + input + '%');
			pr.setString(5, '%' + input + '%');
			pr.setString(6, '%' + input + '%');
			ResultSet rs = pr.executeQuery();
			if (rs != null) {
				List<documentDTO> list = new ArrayList<>();
				while (rs.next()) {
					documentDTO document = new documentDTO(rs.getInt(1), rs.getString(2), rs.getString(3),
							rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8),
							rs.getString(9), rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(13),rs.getString(14),rs.getString(15),rs.getString(16),rs.getString(17));
					list.add(document);
				}
				return list;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

	public List<documentDTO> readAllDocumentShow() {
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(READALLDOCUMENTSHOW);
			if (rs != null) {
				List<documentDTO> list = new ArrayList<>();
				while (rs.next()) {
					documentDTO document = new documentDTO(rs.getInt(1), rs.getString(2), rs.getString(3),
							rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8),
							rs.getString(9), rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(13));
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
			if (rs != null) {
				if (rs.next()) {
					documentDTO document = new documentDTO(rs.getInt(1), rs.getString(2), rs.getString(3),
							rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8),
							rs.getString(9), rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(13));
					return document;
				}

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}
	public String getSql(String nameDocument, String major, String semester, String subject, int courseCredit,
			String nameTeacher) {

		String SEARCHDOCUMENT1 =  " documentName like ? ";
		if (!major.equals("")) {
			SEARCHDOCUMENT1 = SEARCHDOCUMENT1 + " and major = ? ";
		}
		if (!semester.equals("")) {
			SEARCHDOCUMENT1 = SEARCHDOCUMENT1 + " and semester = ? ";
		}
		if (!subject.equals("")) {
			SEARCHDOCUMENT1 = SEARCHDOCUMENT1 + " and subject = ? ";
		}
		if (courseCredit != 0) {
			SEARCHDOCUMENT1 = SEARCHDOCUMENT1 + " and courseCredit = ? ";
		}

		SEARCHDOCUMENT1 = SEARCHDOCUMENT1 + " and nameTeacher like ? AND isShow = 1 ;";

		return SEARCHDOCUMENT1;
	}
	public List<documentDTO> searchDetailDocument(documentDTO document) {
		try {
			PreparedStatement pr = con
					.prepareStatement(SEARCHDOCUMENT + getSql(document.getDocumentName(), document.getMajor(), document.getSemester(), document.getSubject(), document.getCourseCredit(), document.getNameTeacher()) );
			
			pr.setString(1, '%' + document.getDocumentName() + '%');
			if (!document.getMajor().equals("")) {
				pr.setString(2, document.getMajor());
				if (!document.getSemester().equals("")) {
					pr.setString(3, document.getSemester());
					if (!document.getSubject().equals("")) {
						pr.setString(4, document.getSubject());
						if (document.getCourseCredit() != 0) {
							pr.setInt(5, document.getCourseCredit());
							pr.setString(6, '%' + document.getNameTeacher() + '%');
						} else {
							pr.setString(5, '%' + document.getNameTeacher() + '%');

						}
					} else {
						if (document.getCourseCredit() != 0) {
							pr.setInt(4, document.getCourseCredit());
						} else {
							pr.setString(4, '%' + document.getNameTeacher() + '%');

						}
					}
				} else {
					if (!document.getSubject().equals("")) {
						pr.setString(3, document.getSubject());
					} else {
						if (document.getCourseCredit() != 0) {
							pr.setInt(3, document.getCourseCredit());
						} else {
							pr.setString(3, '%' + document.getNameTeacher() + '%');

						}
					}
				}
			} else {
				if (!document.getSemester().equals("")) {
					pr.setString(2, document.getSemester());
				} else {
					if (!document.getSubject().equals("")) {
						pr.setString(2, document.getSubject());
					} else {
						if (document.getCourseCredit() != 0) {
							pr.setInt(2, document.getCourseCredit());
						} else {
							pr.setString(2, '%' + document.getNameTeacher() + '%');

						}
					}
				}
			}
			ResultSet rs = pr.executeQuery();
			if (rs != null) {
				List<documentDTO> list = new ArrayList<>();
				while (rs.next()) {
					documentDTO document1 = new documentDTO(rs.getInt(1), rs.getString(2), rs.getString(3),
							rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8),
							rs.getString(9), rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(13));
					list.add(document1);
				}
				return list;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	public List<documentDTO> searchDownloads() {
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(READLIMITDOWNLOADS);
			if (rs != null) {
				List<documentDTO> list = new ArrayList<>();
				while (rs.next()) {
					documentDTO document = new documentDTO(rs.getInt(1), rs.getString(2), rs.getString(3),
							rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8),
							rs.getString(9), rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(13));
					list.add(document);
				}
				return list;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

	public int getViews(int id) {
		try {
			PreparedStatement pr = con.prepareStatement(GETVIEWS);
			pr.setInt(1, id);
			ResultSet rs = pr.executeQuery();
			if (rs != null) {
				if (rs.next()) {
					return rs.getInt(1);
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 0;
	}

	public boolean updateViews(int newViews, int oldViews, int id) {
		try {
			PreparedStatement pr = con.prepareStatement(UPDATEVIEWS);
			pr.setInt(1, newViews);
			pr.setInt(2, oldViews);
			pr.setInt(3, id);
			int i = pr.executeUpdate();
			if (i != 0) {
				return true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return false;
	}
	public boolean deleteDocument(int id) {
		try {
			PreparedStatement pr = con.prepareStatement(DELETEDOCUMENT);
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

	
}
