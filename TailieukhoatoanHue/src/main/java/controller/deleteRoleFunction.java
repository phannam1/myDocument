package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.constants;
import dao.roleFunctionDAO;
import dto.accountDTO;

/**
 * Servlet implementation class deleteRoleFunction
 */
public class deleteRoleFunction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	roleFunctionDAO dao = null;
    public deleteRoleFunction() {
        dao = new  roleFunctionDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		accountDTO Usersession = (accountDTO)session.getAttribute(constants.USER_SESSION);
		String roleFunctionId = request.getParameter("roleFunctionId");
		int RoleFunctionId = Integer.parseInt(roleFunctionId);
		if(dao.deleteRoleFunction(RoleFunctionId)) {
			response.sendRedirect(request.getContextPath()+"/roleFunctionAdmin");	
		}
		else {
			response.sendRedirect(request.getContextPath()+"/roleFunctionAdmin");	
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
