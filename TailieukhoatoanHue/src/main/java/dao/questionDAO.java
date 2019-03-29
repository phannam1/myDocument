package dao;

import java.sql.Connection;

import utils.DBConnector;
import utils.HashUtils;

public class questionDAO {
	Connection con = null;
	HashUtils hashUltils = null;
	public questionDAO() {
		con = new DBConnector().getCon();
		hashUltils = new HashUtils();
	}
}
