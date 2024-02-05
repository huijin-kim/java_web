package test.com;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class HomeController
 */
@WebServlet({"/index.do", "/file_upload.do", "/file_uploadOK.do","/file_all.do"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String sPath = request.getServletPath();
		System.out.println(sPath);
		
		if(sPath.equals("/index.do")) {
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else if(sPath.equals("/file_upload.do")) {
			request.getRequestDispatcher("fileupload.jsp").forward(request, response);
		}else if(sPath.equals("/file_uploadOK.do")){
			

//			System.out.println(request.getParameter("name"));
//			System.out.println(request.getParameter("age"));
			
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			System.out.println("isMultipart:"+isMultipart);
			
			String name = "";
			String age = "";
			String save_name = "";
			
			if(isMultipart) {
				String realPath = request.getServletContext().getRealPath("uploadimg");
				System.out.println(realPath);
				File temporaryDir = new File(realPath);
				DiskFileItemFactory factory = new DiskFileItemFactory();
				int max = 1024 * 1024 * 10;//10MB
				factory.setSizeThreshold(max);
				factory.setRepository(temporaryDir);
				ServletFileUpload upload = new ServletFileUpload(factory);

				List<FileItem> items = null;
				
				try {
					items = upload.parseRequest(request);
					for (FileItem fi : items) {
//						System.out.println(fi.getFieldName());
//						System.out.println(fi.getString());
						if(fi.getFieldName().equals("name")) {
							name = fi.getString();
						}
						if(fi.getFieldName().equals("age")) {
							age = fi.getString();
						}
						if(fi.getFieldName().equals("file")) {
							save_name = fi.getName();
							
							if(save_name.length()==0) {
								save_name = "default.png";
							}
							
							File uploadFile = new File(realPath,save_name); //경로, 파일
							
							fi.write(uploadFile);
							
							
							
						}
					}//end for
					
					System.out.println("name:"+name);
					System.out.println("age:"+age);
					System.out.println("save_name:"+save_name);
				} catch (FileUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}//end if - isMultipart
			
			TestVO vo = new TestVO();
			vo.setName(name);
			vo.setAge(Integer.parseInt(age==null?"0":age));
			vo.setSave_name(save_name);
			
			TestDAO dao = new TestDAOimple();
			
			int result = dao.insert(vo);
			
			System.out.println(result);
			
			if(result ==1 ) {
				response.sendRedirect("file_all.do");
			}else {
				response.sendRedirect("file_insert.do");
			}
			
		
			
		}else if(sPath.equals("/file_all.do")) {
			
			TestDAO dao = new TestDAOimple();
			
			List<TestVO> vos = dao.selectAll();
			for(TestVO x: vos) {
				System.out.println(x);
			}
			
			request.setAttribute("vos", vos);
			
			request.getRequestDispatcher("file_all.jsp").forward(request, response);
			
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
