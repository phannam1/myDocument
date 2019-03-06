package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.constants;
import dao.accountDAO;
import dto.accountDTO;

/**
 * Servlet implementation class updateForgotPassword
 */
public class updateForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	checkLogin check = null;
	accountDAO dao = null;
    public updateForgotPassword() {
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
		String password = request.getParameter("newpassword");
		String retryPassword = request.getParameter("confirmpassword");
		if(check.checkRetryPassword(password, retryPassword)==false) {
			response.sendRedirect(request.getContextPath()+"/changeForgotPassword.jsp");	
		}
		if(check.checkSession(Usersession) && dao.changeForgotPassword(userName, password)) {
			HttpSession Session = request.getSession(false);	
			Session.invalidate();
			response.sendRedirect(request.getContextPath()+"/index.jsp");			
		}else {
			response.sendRedirect(request.getContextPath()+"/changeForgotPassword.jsp");
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
