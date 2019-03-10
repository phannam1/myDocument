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
import dto.accountDTO;
import dto.functionDTO;

/**
 * Servlet implementation class functionRegister
 */
public class functionRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	functionDAO dao = null;
    public functionRegister() {
       dao  = new functionDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
		accountDTO Usersession = (accountDTO)session.getAttribute(constants.USER_SESSION);	
		String functionName = request.getParameter("functionName");
		if(functionName.equals("")) {
			response.sendRedirect(request.getContextPath()+"/functionAdmin");
		}else {
			String descriptionFunction = request.getParameter("descriptionFunction");
			functionDTO function = new functionDTO(functionName,descriptionFunction,Usersession.getAccountId(),Usersession.getAccountId());
			if(dao.registerFunction(function)!=null) {
				List<functionDTO> list = new ArrayList<functionDTO>();
				list = dao.readAllFuction();
				request.setAttribute("list", list);
				request.setAttribute("account", Usersession);
				RequestDispatcher rd = request.getRequestDispatcher("functionAdmin.jsp");
				  rd.forward(request, response);;
			}
			else {
				response.sendRedirect(request.getContextPath()+"/functionAdmin.jsp");
			
			}
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
