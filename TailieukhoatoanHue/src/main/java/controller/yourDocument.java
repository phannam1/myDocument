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
import dao.documentDAO;
import dto.accountDTO;
import dto.documentDTO;

/**
 * Servlet implementation class yourDocument
 */
public class yourDocument extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	checkLogin check = null;
	documentDAO dao =null;
    public yourDocument() {
       check = new checkLogin();
       dao = new documentDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		accountDTO Usersession = (accountDTO)session.getAttribute(constants.USER_SESSION);	
		
		if(check.checkSession(Usersession)) {
		
			List<documentDTO> list = new ArrayList<documentDTO>();
			
			list = dao.readDocumentById(Usersession.getAccountId());
			request.setAttribute("listDocument", list);
			request.setAttribute("account", Usersession);
		
			RequestDispatcher rd = request.getRequestDispatcher("yourDocument.jsp");
			  rd.forward(request, response);
			  
		}
		else {
			response.sendRedirect(request.getContextPath()+"/signin.jsp");
		
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
