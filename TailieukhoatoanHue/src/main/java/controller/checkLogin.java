package controller;


import dto.accountDTO;

public class checkLogin {
	public boolean checkSession(accountDTO Usersession) {
		if(Usersession != null) {
			return true;
		}
		return false;
	}
	public boolean checkRetryPassword(String password,String retryPassword) {
		if(password.equals(retryPassword)) {
			return true;
		}
		return false;
	}
}
