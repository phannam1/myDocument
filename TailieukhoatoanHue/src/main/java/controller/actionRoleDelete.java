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
 * Servlet implementation class actionRoleDelete
 */
public class actionRoleDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	roleDAO dao = null;
    public actionRoleDelete() {
       dao = new roleDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		accountDTO Usersession = (accountDTO)session.getAttribute(constants.USER_SESSION);
		String userName = request.getParameter("chooseUserName");
		if(userName.equals("")) {
			String message = "Bạn phải nhập vào trường này";
			request.setAttribute("error", message);
			request.getRequestDispatcher("/roleAdmin").forward(request, response);
			
		}else if(dao.deleteRole(userName)==false) {
			response.sendRedirect(request.getContextPath()+"/roleAdmin");
		}
		else {
			response.sendRedirect(request.getContextPath()+"/roleAdmin");
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
