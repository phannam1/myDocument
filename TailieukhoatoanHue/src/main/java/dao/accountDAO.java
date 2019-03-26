package dao;

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
	final String SQLREADALLACCOUNT = "SELECT * FROM ACCOUNT WHERE ISDELETE = 0";
	final String SQLLOGIN = "SELECT * FROM ACCOUNT WHERE USERNAME = ? AND PASSWORD = ? AND ISACTIVE = 1 AND ISDELETE = 0";
	final String SQLLOGINNOACTIVE = "SELECT * FROM ACCOUNT WHERE USERNAME = ? AND PASSWORD = ? AND ISACTIVE = 0 AND ISDELETE = 0";
	
	final String SQLREGISTER = "INSERT INTO ACCOUNT(NAME,USERNAME,PASSWORD,EMAIL,ROLEID) VALUES(?,?,?,?,?)";
	final String SQLUPDATEACTIVEDELETE = "UPDATE ACCOUNT SET ISACTIVE = ?,ISDELETE = ?,lastModifiedById = ? WHERE USERNAME = ? ";
	final String SQLUPDATEACCOUNT = "UPDATE ACCOUNT set passWordLevel2 = ? ,questionSecurity = ? ,answerSecurity = ? ,address = ? ,phone = ? ,email = ?,lastModifiedById = ?, avatar = ?  where accountId = ? ";
	final String SQLUPDATEACCOUNT2 = "UPDATE ACCOUNT set questionSecurity = ? ,answerSecurity = ? ,address = ? ,phone = ? ,email = ?,lastModifiedById = ?, avatar = ?  where accountId = ? ";
	final String SQLUPDATEACCOUNT3 = "UPDATE ACCOUNT set  passWordLevel2 = ? ,address = ? ,phone = ? ,email = ?,lastModifiedById = ?, avatar = ?  where accountId = ? ";
	final String SQLUPDATEACCOUNT1 = "UPDATE ACCOUNT set address = ? ,phone = ? ,email = ?,lastModifiedById = ?,avatar = ?  where accountId = ? ";
	final String SQLGETACCOUNT = "SELECT * FROM ACCOUNT WHERE USERNAME = ?";
	final String SQLCHANGEPASSWORDADMIN = "UPDATE ACCOUNT SET PASSWORD = ? ,lastModifiedById = ? WHERE USERNAME = ? AND PASSWORD =? ";
	final String SQLUPDATEADMIN = "UPDATE ACCOUNT SET NAME = ? , ADDRESS = ? , EMAIL = ? , PHONE = ? WHERE USERNAME = ?";
	final String SQLFORGOTPASSWORD = "SELECT * FROM ACCOUNT WHERE USERNAME = ? AND PASSWORDLEVEL2 = ? OR QUESTIONSECURITY = ? OR ANSWERSECURITY = ? ";
	final String SQLCHANGEFORGOTPASSWORD = "UPDATE ACCOUNT SET PASSWORD = ? ,lastModifiedById = ? WHERE USERNAME = ?";
	final String SQLSEARCHLIKE = "SELECT * FROM ACCOUNT WHERE  USERNAME LIKE ? AND  ISDELETE = 0 OR NAME LIKE ? AND  ISDELETE = 0 OR PHONE LIKE ? AND  ISDELETE = 0 OR ADDRESS LIKE ? AND  ISDELETE = 0 OR EMAIL LIKE ? AND  ISDELETE = 0  ";
	final String SQLDELETEACCOUNT = "UPDATE ACCOUNT SET ISDELETE = 1,lastModifiedById = ? WHERE USERNAME = ?";
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

	public List<accountDTO> readAllAccount() {
		try {
			Statement sttm = con.createStatement();
			ResultSet rs = sttm.executeQuery(SQLREADALLACCOUNT);
			if (rs != null) {
				List<accountDTO> list = new ArrayList<accountDTO>();
				while (rs.next()) {
					accountDTO account = new accountDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10), rs.getString(11), rs.getInt(12), rs.getInt(13), rs.getInt(14),
							rs.getInt(15));
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
			pr.setInt(5, account.getRoleId());
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

	public boolean checkLoginNoActive(String userName, String password) {
		try {
			PreparedStatement pr = con.prepareStatement(SQLLOGINNOACTIVE);
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
							rs.getString(10), rs.getString(11), rs.getInt(12), rs.getInt(13), rs.getInt(14),
							rs.getInt(15));
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
			PreparedStatement pr = con.prepareStatement(SQLGETACCOUNT);
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
			PreparedStatement pr = con.prepareStatement(SQLUPDATEACCOUNT);
			if (account.getPasswordLevel2().equals("")) {
				pr.setString(1, null);
			} else {
				pr.setString(1, hashUtil.hashmd5(account.getPasswordLevel2()));
			}

			if (account.getQuestionSecurity().equals("")) {
				pr.setString(2, null);
			} else {
				pr.setString(2, account.getQuestionSecurity());
			}
			if (account.getAnswerSecurity().equals("")) {
				pr.setString(3, null);
			} else {
				pr.setString(3, account.getAnswerSecurity());
			}
			if (account.getAddress().equals("")) {
				pr.setString(4, null);
			} else {
				pr.setString(4, account.getAddress());
			}

			if (account.getPhone().equals("")) {
				pr.setString(5, null);
			} else {
				pr.setString(5, account.getPhone());
			}
			if (account.getEmail().equals("")) {
				pr.setString(6, null);
			} else {
				pr.setString(6, account.getEmail());
			}
			pr.setInt(7, account.getAccountId());
			pr.setString(8, account.getAvatar());
			pr.setInt(9, account.getAccountId());
			int i = pr.executeUpdate();
			if (i != 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean updateAccount3(accountDTO account) {
		try {
			PreparedStatement pr = con.prepareStatement(SQLUPDATEACCOUNT3);
			if (account.getPasswordLevel2().equals("")) {
				pr.setString(1, null);
			} else {
				pr.setString(1, hashUtil.hashmd5(account.getPasswordLevel2()));
			}

			
			if (account.getAddress().equals("")) {
				pr.setString(2, null);
			} else {
				pr.setString(2, account.getAddress());
			}

			if (account.getPhone().equals("")) {
				pr.setString(3, null);
			} else {
				pr.setString(3, account.getPhone());
			}
			if (account.getEmail().equals("")) {
				pr.setString(4, null);
			} else {
				pr.setString(4, account.getEmail());
			}
			pr.setInt(5, account.getAccountId());
			pr.setString(6, account.getAvatar());
			pr.setInt(7, account.getAccountId());
			int i = pr.executeUpdate();
			if (i != 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean updateAccount2(accountDTO account) {
		try {
			PreparedStatement pr = con.prepareStatement(SQLUPDATEACCOUNT2);
			
			if (account.getQuestionSecurity().equals("")) {
				pr.setString(1, null);
			} else {
				pr.setString(1, account.getQuestionSecurity());
			}
			if (account.getAnswerSecurity().equals("")) {
				pr.setString(2, null);
			} else {
				pr.setString(2, account.getAnswerSecurity());
			}
			if (account.getAddress().equals("")) {
				pr.setString(3, null);
			} else {
				pr.setString(3, account.getAddress());
			}

			if (account.getPhone().equals("")) {
				pr.setString(4, null);
			} else {
				pr.setString(4, account.getPhone());
			}
			if (account.getEmail().equals("")) {
				pr.setString(5, null);
			} else {
				pr.setString(5, account.getEmail());
			}
			pr.setInt(6, account.getAccountId());
			pr.setString(7, account.getAvatar());
			pr.setInt(8, account.getAccountId());
			int i = pr.executeUpdate();
			if (i != 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean updateAccount1(accountDTO account) {
		try {
			PreparedStatement pr = con.prepareStatement(SQLUPDATEACCOUNT1);
			

			
			
			if (account.getAddress().equals("")) {
				pr.setString(1, null);
			} else {
				pr.setString(1, account.getAddress());
			}

			if (account.getPhone().equals("")) {
				pr.setString(2, null);
			} else {
				pr.setString(2, account.getPhone());
			}
			if (account.getEmail().equals("")) {
				pr.setString(3, null);
			} else {
				pr.setString(3, account.getEmail());
			}
			pr.setInt(4, account.getAccountId());
			pr.setString(5, account.getAvatar());
			pr.setInt(6, account.getAccountId());
			int i = pr.executeUpdate();
			if (i != 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public accountDTO getAccountAdmin(String userName) {
		try {
			PreparedStatement pr = con.prepareStatement(SQLGETACCOUNT);
			pr.setString(1, userName);
			ResultSet rs = pr.executeQuery();
			if (rs != null) {
				if (rs.next()) {
					accountDTO account = new accountDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10), rs.getString(11), rs.getInt(12), rs.getInt(13), rs.getInt(14),
							rs.getInt(15));
					return account;
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

	public boolean updateAdmin(accountDTO account) {
		try {
			PreparedStatement pr = con.prepareStatement(SQLUPDATEADMIN);
			pr.setString(1, account.getName());
			pr.setString(2, account.getAddress());
			pr.setString(3, account.getEmail());
			pr.setString(4, account.getPhone());
			pr.setString(5, account.getUserName());
			int i = pr.executeUpdate();
			if (i != 0) {
				return true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return false;
	}

	public boolean updatePasswordAdmin(String Admin, String oldPassword, String newPassword,int lastModifiedById) {
		try {
			PreparedStatement pr = con.prepareStatement(SQLCHANGEPASSWORDADMIN);
			pr.setString(1, hashUtil.hashmd5(newPassword));
			pr.setInt(2, lastModifiedById);
			pr.setString(3, Admin);
			pr.setString(4, hashUtil.hashmd5(oldPassword));
			int i = pr.executeUpdate();
			if (i != 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public boolean updateActiveDelete(int isActive, int isDelete,int lastModifiedById, String userName) {
		try {
			PreparedStatement pr = con.prepareStatement(SQLUPDATEACTIVEDELETE);
			pr.setInt(1, isActive);
			pr.setInt(2, isDelete);
			pr.setInt(3, lastModifiedById);
			pr.setString(4, userName);
			int i = pr.executeUpdate();
			if (i != 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean forgotPassword(accountDTO account) {
		try {
			PreparedStatement pr = con.prepareStatement(SQLFORGOTPASSWORD);
			pr.setString(1, account.getUserName());
			pr.setString(2, hashUtil.hashmd5(account.getPasswordLevel2()));
			if (account.getQuestionSecurity().equals("")) {
				pr.setString(3, null);
			} else {
				pr.setString(3, account.getQuestionSecurity());
			}
			if (account.getAnswerSecurity().equals("")) {
				pr.setString(4, null);
			} else {
				pr.setString(4, account.getAnswerSecurity());
			}

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

	public boolean changeForgotPassword(String userName, String password,int lastModifiedById) {
		try {
			PreparedStatement pr = con.prepareStatement(SQLCHANGEFORGOTPASSWORD);
			
			pr.setString(1, hashUtil.hashmd5(password));
			pr.setInt(2, lastModifiedById);
			pr.setString(3, userName);
			int i = pr.executeUpdate();
			if (i != 0) {
				return true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}
	public List<accountDTO> searchLike(String valueInput){
		try {
			PreparedStatement pr = con.prepareStatement(SQLSEARCHLIKE);
			pr.setString(1, '%'+valueInput +'%');
			pr.setString(2, '%'+valueInput +'%');
			pr.setString(3, '%'+valueInput +'%');
			pr.setString(4, '%'+valueInput +'%');
			pr.setString(5, '%'+valueInput +'%');
			ResultSet rs = pr.executeQuery();
			if(rs!=null) {
				List<accountDTO > list = new ArrayList<accountDTO>();
				while(rs.next()){
					accountDTO account = new accountDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10), rs.getString(11), rs.getInt(12), rs.getInt(13), rs.getInt(14),
							rs.getInt(15));
					list.add(account);
					
				}
				return list;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	public boolean deleteAccount(String userName,int lastModifiedById) {
		try {
			PreparedStatement pr = con.prepareStatement(SQLDELETEACCOUNT);
			pr.setInt(1, lastModifiedById);
			pr.setString(2, userName);			
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
