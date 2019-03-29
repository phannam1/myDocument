package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
 * Servlet implementation class searchDetailDocument
 */
public class searchDetailDocument extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	documentDAO dao = null;
	checkLogin check = null;

	public searchDetailDocument() {
		dao = new documentDAO();
		check = new checkLogin();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		accountDTO Usersession = (accountDTO) session.getAttribute(constants.USER_SESSION);
		String nameDocument = request.getParameter("nameDocument");
		
		String major = request.getParameter("major");
		String semester = request.getParameter("semester");
		String subject = request.getParameter("subject");
		String courseCredit = request.getParameter("courseCredit");
		int CourseCredit = Integer.parseInt(courseCredit);
		String nameTeacher = request.getParameter("nameTeacher");
	
		documentDTO document = new documentDTO(nameDocument, major, semester, subject, CourseCredit, nameTeacher);
		
		if (check.checkSession(Usersession) ) {
			List<documentDTO> list = new ArrayList<documentDTO>();		
			list = dao.searchDetailDocument(document);
			if(list.size()==0) {
				String message = "Không tồn tại dữ liệu tương ứng";
				request.setAttribute("error", message);
				request.getRequestDispatcher("/document.jsp").forward(request, response);
			}
			else {
				request.setAttribute("listDocument", list);
				request.setAttribute("account", Usersession);
				RequestDispatcher rd = request.getRequestDispatcher("document.jsp");
				rd.forward(request, response);
				System.out.println("search success");
			}
			
		} else {
			response.sendRedirect(request.getContextPath() + "/document.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
