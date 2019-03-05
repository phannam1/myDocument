package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.accountDTO;
import utils.DBConnector;
import utils.HashUtils;

public class accountDAO {
	final String SQLREADALLACCOUNT = "SELECT USERNAME, NAME,PHONE,ADDRESS,EMAIL,ISACTIVE,ISDELETE FROM ACCOUNT WHERE ISDELETE = 0";
	final String SQLLOGIN = "SELECT * FROM ACCOUNT WHERE USERNAME = ? AND PASSWORD = ? AND ISACTIVE = 1";
	final String SQLREGISTER ="INSERT INTO ACCOUNT(NAME,USERNAME,PASSWORD,EMAIL,CREATEBYID,LASTMODIFIEDBYID) VALUES(?,?,?,?,?,?)";
	final String SQLCHECKUSERNAME="SELECT * FROM ACCOUNT WHERE USERNAME = ?";
	final String SQLUPDATEACCOUNT="UPDATE ACCOUNT set passWordLevel2 = ? ,questionSecurity = ? ,answerSecurity = ? ,address = ? ,phone = ? ,email = ? where accountId = ? ";
	Connection con = null;
	HashUtils hashUtil = null;

	public accountDAO() {
		con = new DBConnector().getCon();
		hashUtil = new HashUtils();
	}

//	public String getId() {
//		int dem = 0;
//		try {
//			CallableStatement csmt = con.prepareCall("{call readAllAccount()}");
//			boolean hadResults = csmt.execute();
//			if (hadResults) {
//				ResultSet rs = csmt.getResultSet();
//				if (rs != null) {
//					while (rs.next()) {
//						dem = rs.getInt(1) + 1;
//					}
//					String typeId = "account " + String.valueOf(dem);
//					return typeId;
//				}
//			}
//		} catch (SQLException ex) {
//			Logger.getLogger(accountDAO.class.getName()).log(Level.SEVERE, null, ex);
//		}
//		return null;
//	}
//
//	public boolean updateCount() {
//		int dem = 0;
//		try {
//
//			CallableStatement csmt = con.prepareCall("{call readAllAccount()}");
//			boolean hadResults = csmt.execute();
//			if (hadResults) {
//				ResultSet rs = csmt.getResultSet();
//				if (rs != null) {
//					while (rs.next()) {
//						dem = rs.getInt(1);
//					}
//				}
//
//				CallableStatement csmtc = con.prepareCall("{call readAllAccount()}");
//				csmtc.setInt(1, dem + 1);
//				csmtc.setInt(2, dem);
//				boolean hadResultss = csmtc.execute();
//				if (hadResultss) {
//					return true;
//				}
//			}
//		} catch (SQLException ex) {
//			Logger.getLogger(accountDAO.class.getName()).log(Level.SEVERE, null, ex);
//		}
//		return false;
//	}

	
	public List<accountDTO> readAllAccount(){
		try {
			Statement sttm = con.createStatement();
			ResultSet rs = sttm.executeQuery(SQLREADALLACCOUNT);
			if(rs!=null) {
				List<accountDTO> list = new ArrayList<accountDTO>();
				while(rs.next()) {
					accountDTO account = new accountDTO( rs.getString(1), rs.getString(2), rs.getString(3),
							rs.getString(4),rs.getString(5), rs.getInt(6), rs.getInt(7));
					list.add(account);
				}
				return list;
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return null;
	}
	public accountDTO create(accountDTO account) {
		try {
			PreparedStatement pr = con.prepareStatement(SQLREGISTER);
			pr.setString(1, account.getName());
			pr.setString(2, account.getUserName());
			pr.setString(3, hashUtil.hashmd5(account.getPassword()));
			pr.setString(4, account.getEmail());
			pr.setInt(5, account.getAccountId());
			pr.setInt(6, account.getAccountId());
			int i = pr.executeUpdate();
			if (i != 0) {
				return account;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

	public boolean checkLogin(String userName, String password) {
		try {
			PreparedStatement pr = con.prepareStatement(SQLLOGIN);
			pr.setString(1, userName);
			pr.setString(2, password);
			ResultSet rs = pr.executeQuery();
			if (rs != null) {
				if (rs.next()) {
					return true;
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

	public accountDTO getAccount(String userName, String password) {
		try {
			PreparedStatement pr = con.prepareStatement(SQLLOGIN);
			pr.setString(1, userName);
			pr.setString(2, password);
			ResultSet rs = pr.executeQuery();
			if (rs != null) {
				if (rs.next()) {
					accountDTO account = new accountDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10), rs.getString(11), rs.getInt(12), rs.getString(13), rs.getString(14),
							rs.getString(15));
					return account;
				}
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	public boolean checkUserName(String userName) {
		try {
			PreparedStatement pr =con.prepareStatement(SQLCHECKUSERNAME);
			pr.setString(1, userName);
				ResultSet rs = pr.executeQuery();
				if (rs != null) {
					if (rs.next()) {
						return true;
					}
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateAccount(accountDTO account) {
		try {
			CallableStatement csmt = con.prepareCall("{call updateAccount(?,?,?,?,?,?,?)}");
			csmt.setInt(1, account.getAccountId());
			csmt.setString(3, hashUtil.hashmd5(account.getPasswordLevel2()));
			if (!account.getQuestionSecurity().equals("")) {
				csmt.setString(3, account.getQuestionSecurity());
			} else {
				csmt.setString(3, null);
			}
			if (!account.getAnswerSecurity().equals("")) {
				csmt.setString(4, account.getAnswerSecurity());
			} else {
				csmt.setString(4, null);
			}
			csmt.setString(5, account.getAddress());
			if (!account.getAnswerSecurity().equals("")) {
				csmt.setString(6, account.getPhone());
			} else {
				csmt.setString(6, null);
			}
			csmt.setString(7, account.getEmail());
			boolean hadResults = csmt.execute();
			if (hadResults) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
