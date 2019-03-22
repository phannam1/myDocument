package controller;

import java.io.IOException;
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
 * Servlet implementation class updateNews
 */
public class updateNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	newsDAO dao = null;
    public updateNews() {
       dao = new newsDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
		accountDTO Usersession = (accountDTO)session.getAttribute(constants.USER_SESSION);
		String idNews = request.getParameter("idNews");
		int newsId = Integer.parseInt(idNews);
		String titleNews = request.getParameter("titleNews");
		String picture = request.getParameter("picture");
		String contentNews = request.getParameter("contentNews");
		newsDTO news = new newsDTO(newsId,titleNews,picture,contentNews,Usersession.getAccountId());
		if(dao.updateNews(news)) {
			response.sendRedirect(request.getContextPath()+"/newsAdmin");
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
