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
import dao.newsDAO;
import dto.accountDTO;
import dto.newsDTO;

/**
 * Servlet implementation class registerNews
 */
public class registerNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	newsDAO dao = null;
    public registerNews() {
        dao = new newsDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Hashtable params = new Hashtable<>();
			ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
			List<FileItem> multifiles = sf.parseRequest(request);
			String linkData = "";
			for (FileItem item : multifiles) {
				if(item.isFormField()) {
					params.put(item.getFieldName(), item.getString());
				}else {
					item.write(new File("C:\\Users\\Phan Thanh Nam\\Desktop\\myDocument\\TailieukhoatoanHue\\src\\main\\webapp\\img\\news\\"+item.getName()));					
					linkData = "img/news/"+item.getName();
					
				}
					
				}
			HttpSession session = request.getSession();
			accountDTO Usersession = (accountDTO)session.getAttribute(constants.USER_SESSION);	
			String titleNews = (String ) params.get("titleNews");
			byte[] bytes = titleNews.getBytes(StandardCharsets.ISO_8859_1);
			titleNews = new String(bytes, StandardCharsets.UTF_8);
			String contentNews =(String ) params.get("contentNews");
			byte[] bytes1 = contentNews.getBytes(StandardCharsets.ISO_8859_1);
			contentNews = new String(bytes1, StandardCharsets.UTF_8);
			int createById = Usersession.getAccountId();
			int lastModifiedById = Usersession.getAccountId();
			newsDTO news = new newsDTO( titleNews, linkData, contentNews, createById, lastModifiedById);
			if(dao.registerNews(news)) {
				response.sendRedirect(request.getContextPath()+"/newsAdmin");
			}
			else {
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
