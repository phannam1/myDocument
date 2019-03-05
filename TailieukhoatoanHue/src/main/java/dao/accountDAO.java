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
	final String SQLREADALLACCOUNT = "SELECT * FROM ACCOUNT WHERE ISDELETE = 0";
	final String SQLLOGIN = "SELECT * FROM ACCOUNT WHERE USERNAME = ? AND PASSWORD = ? AND ISACTIVE = 1";
	final String SQLREGISTER ="INSERT INTO ACCOUNT(NAME,USERNAME,PASSWORD,EMAIL,CREATEBYID,LASTMODIFIEDBYID) VALUES(?,?,?,?,?,?)";
	
	final String SQLUPDATEACCOUNT="UPDATE ACCOUNT set passWordLevel2 = ? ,questionSecurity = ? ,answerSecurity = ? ,address = ? ,phone = ? ,email = ? where accountId = ? ";
	final String SQLGETACCOUNT = "SELECT * FROM ACCOUNT WHERE USERNAME = ?";
	final String SQLCHANGEPASSWORDADMIN = "UPDATE ACCOUNT SET PASSWORD = ? WHERE USERNAME = ? AND PASSWORD =? ";
	final String SQLUPDATEADMIN = "UPDATE ACCOUNT SET NAME = ? , ADDRESS = ? , EMAIL = ? , PHONE = ? WHERE USERNAME = ?"; 

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
					accountDTO account = new accountDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10), rs.getString(11), rs.getInt(12), rs.getString(13), rs.getString(14),
							rs.getString(15));				
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
			PreparedStatement pr =con.prepareStatement(SQLGETACCOUNT);
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
			pr.setString(1, hashUtil.hashmd5( account.getPasswordLevel2()));
			if (account.getQuestionSecurity()!=null) {
				pr.setString(2, account.getQuestionSecurity());
			}
			if (account.getAnswerSecurity()!=null) {
				pr.setString(3, account.getAnswerSecurity());
			}
			pr.setString(4, account.getAddress());
			if (account.getAnswerSecurity()!=null) {
				pr.setString(5, account.getPhone());
			} 
			pr.setString(6, account.getEmail());
			pr.setInt(7, account.getAccountId());
			int i = pr.executeUpdate();
			if (i!=0) {
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
			if(rs!=null) {
				if(rs.next()) {
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
	public boolean updateAdmin (accountDTO account) {
		try {
			PreparedStatement pr = con.prepareStatement(SQLUPDATEADMIN);
			pr.setString(1, account.getName());
			pr.setString(2, account.getAddress());
			pr.setString(3, account.getEmail());
			pr.setString(4, account.getPhone());
			pr.setString(5, account.getUserName());
			int i = pr.executeUpdate();
			if(i!=0) {
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}
	public boolean updatePasswordAdmin(String Admin,String oldPassword,String newPassword) {
		try {
			PreparedStatement pr = con .prepareStatement(SQLCHANGEPASSWORDADMIN);
			pr.setString(1, hashUtil.hashmd5(newPassword));
			pr.setString(2, Admin);
			pr.setString(3, hashUtil.hashmd5(oldPassword));
			int i = pr.executeUpdate();
			if(i!=0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
