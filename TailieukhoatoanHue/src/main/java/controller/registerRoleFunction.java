package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.constants;
import dao.functionDAO;
import dao.roleFunctionDAO;
import dto.accountDTO;
import dto.roleFunctionDTO;

/**
 * Servlet implementation class registerRoleFunction
 */
public class registerRoleFunction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	roleFunctionDAO dao = null;
	functionDAO functionDao = null;
    public registerRoleFunction() {
       dao = new roleFunctionDAO();
       functionDao = new functionDAO(); 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		accountDTO Usersession = (accountDTO)session.getAttribute(constants.USER_SESSION);
		String chooseRoleFunction = request.getParameter("chooseRoleFunction");
		int roleId = Integer.parseInt(chooseRoleFunction);
		String functionName = request.getParameter("chooseFunction");
		int functionId = functionDao.getfunctionId(functionName);
		String description = request.getParameter("description");
		int createById = Usersession.getAccountId();
		int lastModifiedById = Usersession.getAccountId();
		roleFunctionDTO roleFunction = new roleFunctionDTO(roleId, functionId, description, createById, lastModifiedById);
		if(dao.registerRoleFunction(roleFunction)!=null) {
			response.sendRedirect(request.getContextPath()+"/roleFunctionAdmin");	
		}else {
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
