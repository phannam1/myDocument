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
import dao.newsDAO;
import dto.accountDTO;
import dto.newsDTO;

/**
 * Servlet implementation class searchInputNews
 */
public class searchInputNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	newsDAO dao = null;
    public searchInputNews() {
        dao   = new  newsDAO();
        }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		accountDTO Usersession = (accountDTO)session.getAttribute(constants.USER_SESSION);	
		String valueInput = request.getParameter("valueInput");
		if(dao.searchNews(valueInput)!=null) {
			List<newsDTO> list = new ArrayList<newsDTO>();
			list = dao .searchNews(valueInput);
			request.setAttribute("listNews", list);
			request.setAttribute("account", Usersession);
			RequestDispatcher rd = request.getRequestDispatcher("newsAdmin.jsp");
			  rd.forward(request, response);;
		
		}else {
			response.sendRedirect(request.getContextPath()+"/newsAdmin");
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
