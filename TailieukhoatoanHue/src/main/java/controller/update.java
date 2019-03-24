


package controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Hashtable;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

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
		
		try {
			Hashtable params = new Hashtable<>();
			ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
			List<FileItem> multifiles = sf.parseRequest(request);
			String linkData = "";
			for (FileItem item : multifiles) {
				if(item.isFormField()) {
					params.put(item.getFieldName(), item.getString());
				}else {
					item.write(new File("C:\\Users\\Phan Thanh Nam\\Desktop\\myDocument\\TailieukhoatoanHue\\src\\main\\webapp\\img\\avatar\\"+item.getName()));					
					linkData = "img/avatar/"+item.getName();
					
				}
					
				}	
			
			HttpSession session = request.getSession();
			accountDTO Usersession = (accountDTO) session.getAttribute(constants.USER_SESSION);
			int id = Usersession.getAccountId();
			String passwordLevel2 = (String ) params.get("passwordLevel2");
			String confirmPassword = (String ) params.get("confirmpassword");
			if(check.checkRetryPassword(passwordLevel2, confirmPassword)==false) {
				response.sendRedirect(request.getContextPath()+"/Infor");
			}else {
				String question = (String ) params.get("Question");
				byte[] bytes = question.getBytes(StandardCharsets.ISO_8859_1);
				question = new String(bytes, StandardCharsets.UTF_8);
				String answer = (String ) params.get("answer");
				byte[] bytes1 = answer.getBytes(StandardCharsets.ISO_8859_1);
				answer = new String(bytes1, StandardCharsets.UTF_8);
				if (!question.equals("") && answer.equals("")) {
					String message = "Bạn phải nhập câu trả lời bảo mật";
					request.setAttribute("error", message);
					request.getRequestDispatcher("/Infor").forward(request, response);
				} else {
					String address = (String ) params.get("address");
					byte[] bytes2 = address.getBytes(StandardCharsets.ISO_8859_1);
					address = new String(bytes2, StandardCharsets.UTF_8);
					String phone = (String ) params.get("phone");
					String email = (String ) params.get("email");
					accountDTO account = new accountDTO(id,linkData, address, phone, email, passwordLevel2, question, answer,Usersession.getAccountId());
					if (dao.updateAccount(account)) {		
						account = dao.getAccount(Usersession.getUserName(), Usersession.getPassword())	;
						HttpSession usSession = request.getSession();
						usSession.setAttribute(constants.USER_SESSION, account);		
						System.out.println("update success");
						
					} else {
						
					}
				}
			}
			
		}
		
			catch (Exception e) {
				e.printStackTrace();
				
			}
	
		
		response.sendRedirect(request.getContextPath()+"/index");
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
