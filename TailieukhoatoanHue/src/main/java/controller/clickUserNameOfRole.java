package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.roleDAO;
import dto.roleDTO;

/**
 * Servlet implementation class clickUserNameOfRole
 */
public class clickUserNameOfRole extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	roleDAO dao =null;
    public clickUserNameOfRole() {
        dao = new roleDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("id");
		System.out.println(userName);
		roleDTO role = new roleDTO();
		if(dao.getRoleByUserName(userName)!=null) {
			System.out.println(123);
			role = dao.getRoleByUserName(userName);
			request.setAttribute("role", role);			
			RequestDispatcher rd = request.getRequestDispatcher("roleAdmin");
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
