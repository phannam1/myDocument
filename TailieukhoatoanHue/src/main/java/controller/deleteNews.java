package controller;

import java.io.File;
import java.io.IOException;
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
import dao.newsDAO;
import dto.accountDTO;

/**
 * Servlet implementation class deleteNews
 */
public class deleteNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	newsDAO dao = null;
    public deleteNews() {
      dao = new newsDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
		accountDTO Usersession = (accountDTO)session.getAttribute(constants.USER_SESSION);
		try {
			Hashtable params = new Hashtable<>();
			ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
			List<FileItem> multifiles = sf.parseRequest(request);
			String linkData = "";
			for (FileItem item : multifiles) {
				if(item.isFormField()) {
					params.put(item.getFieldName(), item.getString());
				}
					
				}
			String idNews = (String ) params.get("idNews");
			int newsId = Integer.parseInt(idNews);
			if(dao.deleteNews(newsId)) {
				response.sendRedirect(request.getContextPath()+"/newsAdmin");
			}else {
				response.sendRedirect(request.getContextPath()+"/newsAdmin");
			}	
			
		}catch (Exception e) {
			e.printStackTrace();
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
