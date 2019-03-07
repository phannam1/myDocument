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
 * Servlet implementation class updatePasswordAdmin
 */
public class updatePasswordAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	checkLogin check = null; 
	accountDAO dao = null;
    public updatePasswordAdmin() {
       check = new checkLogin();
       dao = new accountDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String newPassword = request.getParameter("newPassword");
		String retryPassword = request.getParameter("retryPassword");
		accountDTO account = new accountDTO(userName,newPassword);
		if(dao.updatePasswordAdmin(userName,password, newPassword) && check.checkRetryPassword(newPassword, retryPassword)) {
			HttpSession usSession = request.getSession();	
			usSession.setAttribute(constants.USER_SESSION, account);
			System.out.println("update success");
			response.sendRedirect(request.getContextPath()+"/Logout");
		}
		else {
			System.out.println("update fail");
			response.sendRedirect(request.getContextPath()+"/changePasswordAdmin");
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
