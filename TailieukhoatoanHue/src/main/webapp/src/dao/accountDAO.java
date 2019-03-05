package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import dto.accountDTO;
import utils.DBConnector;
import utils.HashUtils;

public class accountDAO {
	Connection con = null;
	HashUtils hashUtil = null;
	public accountDAO() {
		con = new DBConnector().getCon();
		hashUtil =  new HashUtils();
	}
	public List<accountDTO> readAll() {
		try {
			CallableStatement csmt = con.prepareCall("{call readAllAccount()}");
			boolean hadResults = csmt.execute();
			if (hadResults) {
				ResultSet rs = csmt.getResultSet();
				if (rs != null) {
					List<accountDTO> list = new ArrayList<>();
					while (rs.next()) {
						accountDTO user = new accountDTO(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7), rs.getString(8), rs.getString(9),rs.getString(10), rs.getString(11), rs.getInt(12),rs.getString(13), rs.getString(14), rs.getString(15));
						list.add(user);
					}
					return list;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public accountDTO create(accountDTO account) {
		try {
			CallableStatement csmt = con.prepareCall("{call createUser(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			csmt.setString(1, account.getAccountId());
			csmt.setString(2, account.getUserName());
			csmt.setString(3, hashUtil.hashmd5(account.getPassword()));
			csmt.setString(4, account.getName());
			csmt.setString(5, account.getAvatar());
			csmt.setString(6, account.getAddress());
			csmt.setString(7, account.getPhone());
			csmt.setString(8, account.getEmail());
			csmt.setString(9, account.getPasswordLevel2());
			csmt.setString(10, account.getQuestionSecurity());
			csmt.setString(11, account.getAnswerSecurity());
			csmt.setInt(12, account.getIsActive());
			csmt.setString(13, account.getRoleId());
			csmt.setString(14, account.getCreateById());
			csmt.setString(15, account.getLasModifiedById());
			boolean hadResults = csmt.execute();
			if (hadResults) {
				return account;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	public boolean checkLogin(String userName, String password) {
		try {
			CallableStatement csmt = con.prepareCall("{call login(?,?)}");
			csmt.setString(1, userName);
			csmt.setString(2, password);
			boolean hadResults = csmt.execute();
			if (hadResults) {
				ResultSet rs = csmt.getResultSet();
				if (rs != null) {
					if (rs.next()) {
						return true;
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
