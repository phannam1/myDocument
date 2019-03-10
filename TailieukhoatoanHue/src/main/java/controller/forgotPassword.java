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
 * Servlet implementation class forgotPassword
 */
public class forgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	accountDAO dao = null;
    public forgotPassword() {
      dao =new accountDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("userName");
		String passwordLevel2 = request.getParameter("passwordLevel2");		
		String selectValue = request.getParameter("question");
		String answer = request.getParameter("answer");
		accountDTO account = new accountDTO(userName,passwordLevel2,selectValue,answer);
		if(dao.forgotPassword(account)) {
			HttpSession session = request.getSession();
			accountDTO account1 = new accountDTO();
			account1 = dao.getAccountAdmin(userName);		
			session.setAttribute(constants.USER_SESSION, account1);	
			System.out.println(account1.getUserName());
			request.setAttribute("account", constants.USER_SESSION);
			RequestDispatcher rd = request.getRequestDispatcher("changeForgotPassword.jsp");
			  rd.forward(request, response);	
				
		}
		else {
			response.sendRedirect(request.getContextPath()+"/forgotPassword.jsp");	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
