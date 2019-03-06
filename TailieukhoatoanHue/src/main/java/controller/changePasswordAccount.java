package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.constants;
import dao.accountDAO;
import dto.accountDTO;

/**
 * Servlet implementation class changePasswordAccount
 */
public class changePasswordAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	checkLogin check = null;
	accountDAO dao = null;
    public changePasswordAccount() {
        check = new checkLogin();
        dao = new accountDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		accountDTO Usersession = (accountDTO)session.getAttribute(constants.USER_SESSION);
		String userName = Usersession.getUserName();
		String password = request.getParameter("password");
		String newPassword = request.getParameter("newPassword");
		String retryPassword = request.getParameter("confirmPassword");
		if(check.checkRetryPassword(newPassword, retryPassword)==false) {
			response.sendRedirect(request.getContextPath()+"/changePassword.jsp");
		}
		if(dao.updatePasswordAdmin(userName, password, newPassword)) {				
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			HttpSession session1 = request.getSession(false);	
			session1.invalidate();
		}
		else {
			response.sendRedirect(request.getContextPath()+"/changePassword.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
