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
 * Servlet implementation class update
 */
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	accountDAO dao = null;
    public update() {
        dao = new accountDAO(); 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		accountDTO Usersession = (accountDTO)session.getAttribute(constants.USER_SESSION);	
		int id =  Usersession.getAccountId();
		String passwordLevel2 = request.getParameter("passwordLevel2") ;
		String question = request.getParameter("Question") ;
		String answer = request.getParameter("answer") ;
		String address = request.getParameter("address") ;
		String phone = request.getParameter("phone") ;
		String email = request.getParameter("email") ;
		System.out.println(question);
		accountDTO account = new accountDTO(id,address,phone,email,passwordLevel2,question,answer);
		if(dao.updateAccount(account)) {
			System.out.println("update success");
			response.sendRedirect(request.getContextPath()+"/index");
		}
		else {
			response.sendRedirect(request.getContextPath()+"/inforAccount.jsp");
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
