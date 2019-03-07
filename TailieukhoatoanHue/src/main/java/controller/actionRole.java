package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.constants;
import dao.roleDAO;
import dto.accountDTO;

/**
 * Servlet implementation class actionRole
 */
public class actionRole extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	checkLogin check = null;
	roleDAO dao =null;
    public actionRole() {
        check = new checkLogin();
        dao =  new roleDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		accountDTO Usersession = (accountDTO)session.getAttribute(constants.USER_SESSION);
		String userName = request.getParameter("chooseUserName");
		String role = request.getParameter("chooseRole");
		int roleId = Integer.parseInt(role);
		if(check.checkSession(Usersession)) {	
			if(dao.updateRole(roleId, userName)) {
				response.sendRedirect(request.getContextPath()+"/roleAdmin");	
			}
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
