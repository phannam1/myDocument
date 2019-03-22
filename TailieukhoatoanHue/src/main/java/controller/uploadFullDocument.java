package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.constants;
import dto.accountDTO;

/**
 * Servlet implementation class uploadFullDocument
 */
public class uploadFullDocument extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public uploadFullDocument() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
		accountDTO Usersession = (accountDTO)session.getAttribute(constants.USER_SESSION);	
		String nameDocument = request.getParameter("nameDocument");
		String major = request.getParameter("major");
		String semester = request.getParameter("semester");
		String subject = request.getParameter("subject");
		String courseCredit = request.getParameter("courseCredit");
		String typeData = request.getParameter("typeData");
		String nameTeacher = request.getParameter("nameTeacher");
		System.out.println(nameDocument);
		System.out.println(major);
		System.out.println(semester);
		System.out.println(subject);
		System.out.println(courseCredit);
		System.out.println(typeData);
		System.out.println(nameTeacher);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
