package controller;

import java.io.IOException;

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
 * Servlet implementation class detailDocument
 */
public class detailDocument extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	checkLogin check = null;
	documentDAO dao = null;
    public detailDocument() {
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
		String id = request.getParameter("id");
		int documentId = Integer.parseInt(id);
		System.out.println(id);
		if(check.checkSession(Usersession)) {	
			documentDTO document = new documentDTO();
			document = dao.getDocumentById(documentId);
			request.setAttribute("document", document);
			request.setAttribute("account", Usersession);
			RequestDispatcher rd = request.getRequestDispatcher("detailDocument.jsp");
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
