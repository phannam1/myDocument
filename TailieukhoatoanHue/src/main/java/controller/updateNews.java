package controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.TimeoutException;

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
 * Servlet implementation class updateNews
 */
public class updateNews extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	newsDAO dao = null;

	public updateNews() {
		dao = new newsDAO();
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
				if (item.isFormField()) {
					params.put(item.getFieldName(), item.getString());
					
				} else {
					if(item.getName().equals("")) {
						
						HttpSession session = request.getSession();
						accountDTO Usersession = (accountDTO) session.getAttribute(constants.USER_SESSION);
						String idNews = (String) params.get("idNews");
						int newsId = Integer.parseInt(idNews);
						String titleNews = (String) params.get("titleNews");
						byte[] bytes3 = titleNews.getBytes(StandardCharsets.ISO_8859_1);
						titleNews = new String(bytes3, StandardCharsets.UTF_8);
						
						String contentNews = (String) params.get("contentNews");
						byte[] bytes4 = contentNews.getBytes(StandardCharsets.ISO_8859_1);
						contentNews = new String(bytes4, StandardCharsets.UTF_8);
						
						System.out.println(contentNews);
						if (dao.updateNews1(titleNews, contentNews, Usersession.getAccountId(), newsId)) {
							System.out.println("update sussces");
							response.sendRedirect(request.getContextPath() + "/newsAdmin");
							return;
						} else {
							response.sendRedirect(request.getContextPath() + "/newsAdmin");
						}
					}
					else {
					
						item.write(new File(
								"C:\\Users\\Phan Thanh Nam\\Desktop\\myDocument\\TailieukhoatoanHue\\src\\main\\webapp\\img\\news\\"+ item.getName()));
						linkData = "img/news/" + item.getName();
					}
					

					}
					
				}

			
			HttpSession session = request.getSession();
			accountDTO Usersession = (accountDTO) session.getAttribute(constants.USER_SESSION);
			String idNews = (String) params.get("idNews");
			int newsId = Integer.parseInt(idNews);
			String titleNews = (String) params.get("titleNews");
			byte[] bytes = titleNews.getBytes(StandardCharsets.ISO_8859_1);
			titleNews = new String(bytes, StandardCharsets.UTF_8);
			String contentNews = (String) params.get("contentNews");
			byte[] bytes1 = contentNews.getBytes(StandardCharsets.ISO_8859_1);
			contentNews = new String(bytes1, StandardCharsets.UTF_8);	
			newsDTO news = new newsDTO(newsId, titleNews, linkData, contentNews, Usersession.getAccountId());
			if (dao.updateNews(news)) {
				response.sendRedirect(request.getContextPath() + "/newsAdmin");
			} else {
				response.sendRedirect(request.getContextPath() + "/newsAdmin");
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
