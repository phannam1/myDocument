package controller;

import java.io.IOException;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.constants;

import dao.accountDAO;
import dto.accountDTO;

import utils.HashUtils;

/**
 * Servlet implementation class login
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/login" })
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	accountDAO dao = null;
	checkLogin check = null;
	HashUtils hashUtil = null;
    public login() {
        dao =new accountDAO();
        check = new checkLogin();
        hashUtil = new HashUtils();
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
		String userName = (String) request.getParameter("userName");
		String password = (String) request.getParameter("password");		
		if(dao.checkLogin(userName,hashUtil.hashmd5(password)) ) {
			HttpSession session = request.getSession();
			accountDTO account = new accountDTO();
			account=dao.getAccount(userName,hashUtil.hashmd5(password));		
			session.setAttribute(constants.USER_SESSION, account);			
			response.sendRedirect(request.getContextPath()+"/CheckAccountLogin");	
			
		}else {	
			
			if(dao.checkLoginNoActive(userName, hashUtil.hashmd5(password))) {
				String message = "Tài khoản của bạn chưa được hoạt động , Vui lòng đợi quản trị viên phê duyệt Tài khoản và quay lại sau ";
				request.setAttribute("isActive", message);
				request.getRequestDispatcher("/signin.jsp").forward(request, response);
			}else {
				String message = "Tài khoản hoặc mật khẩu không đúng";
				request.setAttribute("error", message);
				request.getRequestDispatcher("/signin.jsp").forward(request, response);
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
