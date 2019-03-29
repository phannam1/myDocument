package controller;

import java.io.IOException;
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
 * Servlet implementation class updateIsShowDocument
 */
public class updateIsShowDocument extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	documentDAO dao = null;
	checkLogin check = null;
    public updateIsShowDocument() {
       dao = new documentDAO();
       check = new checkLogin();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		accountDTO Usersession = (accountDTO)session.getAttribute(constants.USER_SESSION);
		String id = request.getParameter("documentId");
		int documentId = Integer.parseInt(id);
		String nameDocument  = request.getParameter("nameDocument");
		String major = request.getParameter("major");
		String semester = request.getParameter("semester");
		String subject = request.getParameter("subject");
		String nameTeacher = request.getParameter("nameTeacher");
		String isActive = request.getParameter("isActive");
		int IsActive = Integer.parseInt(isActive);
		String courseCredit = request.getParameter("courseCredit");
		int CourseCredit = Integer.parseInt(courseCredit);
		System.out.println(CourseCredit);
		documentDTO document = new documentDTO(documentId, nameDocument, major, semester, subject, CourseCredit, nameTeacher, IsActive, Usersession.getAccountId());
		if(check.checkSession(Usersession) && dao.updateDocument(document)) {
			System.out.println("update success");
			response.sendRedirect(request.getContextPath()+"/documentAdmin");
			
		}else {
			System.out.println("update fail");
			response.sendRedirect(request.getContextPath()+"/documentAdmin");
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
