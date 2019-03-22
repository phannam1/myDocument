


package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.constants;
import dao.accountDAO;
import dto.accountDTO;

/**
 * Servlet implementation class update
 */
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	checkLogin check = null;
	accountDAO dao = null;

	public update() {
		dao = new accountDAO();
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
		int id = Usersession.getAccountId();
		String passwordLevel2 = request.getParameter("passwordLevel2");
		String confirmPassword = request.getParameter("confirmpassword");
		if (check.checkRetryPassword(passwordLevel2, confirmPassword) == false) {
			response.sendRedirect(request.getContextPath() + "/Infor");
		} else {
			String question = request.getParameter("Question");
			String answer = request.getParameter("answer");
			if (!question.equals("") && answer.equals("")) {
				String message = "Bạn phải nhập câu trả lời bảo mật";
				request.setAttribute("error", message);
				request.getRequestDispatcher("/Infor").forward(request, response);
			} else {
				String address = request.getParameter("address");
				String phone = request.getParameter("phone");
				String email = request.getParameter("email");
				accountDTO account = new accountDTO(id, address, phone, email, passwordLevel2, question, answer,Usersession.getAccountId());
				if (dao.updateAccount(account)) {		
					account = dao.getAccount(Usersession.getUserName(), Usersession.getPassword())	;
					HttpSession usSession = request.getSession();
					usSession.setAttribute(constants.USER_SESSION, account);		
					System.out.println("update success");
					response.sendRedirect(request.getContextPath()+"/Infor");
				} else {
					response.sendRedirect(request.getContextPath() + "/inforAccount.jsp");
				}
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
