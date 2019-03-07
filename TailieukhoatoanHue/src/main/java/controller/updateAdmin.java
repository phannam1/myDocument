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
 * Servlet implementation class updateAdmin
 */
public class updateAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	accountDAO dao = null;
    public updateAdmin() {
      dao = new accountDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("userName");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		accountDTO account = new accountDTO(userName,name,address,email,phone);
		if(dao.updateAdmin(account)) {
			HttpSession usSession = request.getSession();	
			usSession.setAttribute(constants.USER_SESSION, account);		
			System.out.println("update success");
			response.sendRedirect(request.getContextPath()+"/indexAdmin");
		}
		else {
			System.out.println("update fail");
			response.sendRedirect(request.getContextPath()+"/indexAdmin");
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
