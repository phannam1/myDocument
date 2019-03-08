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
import dao.roleDAO;
import dto.accountDTO;
import dto.roleDTO;

/**
 * Servlet implementation class searchInputRole
 */
public class searchInputRole extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	roleDAO dao = null;
    public searchInputRole() {
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
		String value = request.getParameter("valueInputSearch");
		if(dao.searchLike(value)!=null) {	
			List<roleDTO> listRole = new ArrayList<roleDTO>();
			listRole = dao.searchLike(value);			
			request.setAttribute("account", Usersession);
			request.setAttribute("listRole", listRole);	
			RequestDispatcher rd = request.getRequestDispatcher("roleAdmin.jsp");
			  rd.forward(request, response);;
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
