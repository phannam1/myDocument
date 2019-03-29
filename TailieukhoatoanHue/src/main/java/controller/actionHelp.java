package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.constants;
import dao.accountDAO;
import dao.helpDAO;
import dto.accountDTO;
import dto.helpDTO;

/**
 * Servlet implementation class actionHelp
 */
public class actionHelp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	accountDAO dao  = null;
	helpDAO helpDao = null;
    public actionHelp() {
       dao = new accountDAO();
       helpDao = new helpDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		accountDTO Usersession = (accountDTO)session.getAttribute(constants.USER_SESSION);
		String userName = request.getParameter("userName");
		String name =  request.getParameter("ten");
		String comment =  request.getParameter("comment");
		
		if(dao.getAccountAdmin(userName)==null) {
			String message = "Tài khoản không tồn tại ";
			request.setAttribute("error", message);
			request.getRequestDispatcher("/help.jsp").forward(request, response);
		}else {
			int id =  dao.getAccountAdmin(userName).getAccountId();
			helpDTO help = new helpDTO(comment, id);
			if(helpDao.createHelp(help)) {
				response.sendRedirect(request.getContextPath()+"/index");
			}else {
				response.sendRedirect(request.getContextPath()+"/index");
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
