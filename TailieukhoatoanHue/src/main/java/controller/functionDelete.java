package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.constants;
import dao.functionDAO;
import dto.accountDTO;

/**
 * Servlet implementation class functionDelete
 */
public class functionDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	functionDAO dao = null;

	public functionDelete() {
		dao = new functionDAO();
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
		String id = request.getParameter("functionId");
		if (id.equals("")) {
			response.sendRedirect(request.getContextPath() + "/functionAdmin");
		} else {
			int functionId = Integer.valueOf(id);
			if (dao.deleteFunction(functionId)) {
				response.sendRedirect(request.getContextPath() + "/functionAdmin");

			} else {
				response.sendRedirect(request.getContextPath() + "/functionAdmin");
			}
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
