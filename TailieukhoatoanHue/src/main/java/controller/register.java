package controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.accountDAO;
import dto.accountDTO;
import utils.HashUtils;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	accountDAO dao = null;
	HashUtils hash = null;
	checkLogin check = null;
    public register() {
        dao = new accountDAO();
        hash = new HashUtils();
        check = new checkLogin();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
		String userName = (String) request.getParameter("userName");
		if(dao.checkUserName(userName)) {
			String message = "Tài khoản đã tồn tại";
			request.setAttribute("error", message);
			request.getRequestDispatcher("/register.jsp").forward(request, response);		
		}
		else {
			String name = (String) request.getParameter("name");
			if(name=="") {
				response.sendRedirect(request.getContextPath()+"/register.jsp");
			}
			String password = (String) request.getParameter("password");
			if(password=="") {
				response.sendRedirect(request.getContextPath()+"/register.jsp");
			}
			
			String retryPassword = (String) request.getParameter("confirmpassword");
			String email = (String) request.getParameter("email");	
			if(email=="") {
				response.sendRedirect(request.getContextPath()+"/register.jsp");
			}
			accountDTO account = new accountDTO(name,userName,password,email,2,1,1);
			if(dao.create(account)!=null && check.checkRetryPassword(password, retryPassword) ) {
				System.out.println("create success");
				response.sendRedirect(request.getContextPath()+"/signin.jsp");	
			}
			else {
				System.out.println("create fail");
				response.sendRedirect(request.getContextPath()+"/register.jsp");	
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
