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
import dao.functionDAO;
import dao.roleFunctionDAO;
import dto.accountDTO;
import dto.functionDTO;
import dto.roleFunctionDTO;

/**
 * Servlet implementation class searchInputRoleFunction
 */
public class searchInputRoleFunction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	roleFunctionDAO dao = null;
	functionDAO functiondao = null;
    public searchInputRoleFunction() {
       dao = new roleFunctionDAO();
       functiondao = new functionDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		accountDTO Usersession = (accountDTO)session.getAttribute(constants.USER_SESSION);
		String valueInput = request.getParameter("valueInputSearch");
		if(dao.searchRoleFunction(valueInput)!=null) {
			List<functionDTO> listFunction = new ArrayList<functionDTO>();
			listFunction = functiondao.readAllFuction();
			request.setAttribute("list", listFunction);
			List<roleFunctionDTO> list = new ArrayList<roleFunctionDTO>();
			list =dao.searchRoleFunction(valueInput);
			request.setAttribute("listRoleFunction", list);
			request.setAttribute("account", Usersession);
			RequestDispatcher rd = request.getRequestDispatcher("roleFunctionAdmin.jsp");
			  rd.forward(request, response);;
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
