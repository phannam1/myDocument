package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.accountDAO;

/**
 * Servlet implementation class updateActiveDelete
 */
public class updateActiveDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	accountDAO dao = null;
	public updateActiveDelete() {
		dao = new accountDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			String userName = request.getParameter("userName");
			String checkBoxisActive = "";
			String checkBoxisDelete = "";
			int isActive = 0;
			int isDelete = 0;
			if (request.getParameter("isActive") != null && request.getParameter("isActive").trim().length() != 0) {
				checkBoxisActive = request.getParameter("isActive").trim();
				if (!checkBoxisActive.equals("")) {
					isActive = 1;
				}
				else {
					isActive = 0;
				}
			}
			if (request.getParameter("isDelete") != null && request.getParameter("isDelete").trim().length() != 0) {
				checkBoxisDelete = request.getParameter("isDelete").trim();
				if (!checkBoxisDelete.equals("")) {
					isDelete = 1;
				}
				else {
					isDelete = 0;
				}
			}
			if(dao.updateActiveDelete(isActive, isDelete, userName)) {
				
				response.sendRedirect(request.getContextPath()+"/accountAdmin");
			}
			else {
				
				response.sendRedirect(request.getContextPath()+"/accountAdmin");
			}
		} catch (Exception e) {
			e.printStackTrace();
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
