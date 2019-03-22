package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.constants;
import dao.documentDAO;
import dto.accountDTO;
import dto.documentDTO;
import dto.functionDTO;

/**
 * Servlet implementation class documentAdmin
 */
public class documentAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	documentDAO dao = null;
	checkLogin check = null;
    public documentAdmin() {
       dao = new documentDAO();
       check = new checkLogin();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		accountDTO Usersession = (accountDTO)session.getAttribute(constants.USER_SESSION);	
		if(check.checkSession(Usersession)) {
			List<documentDTO> list = new ArrayList<documentDTO>();
			list = dao.readAllDocument();
			request.setAttribute("listDocument", list);
			request.setAttribute("account", Usersession);
		
			RequestDispatcher rd = request.getRequestDispatcher("documentAdmin.jsp");
			  rd.forward(request, response);;
			  
		}
		else {
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		
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
