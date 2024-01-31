package test.com.comments;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CommentsController
 */
@WebServlet({ "/c_insertOK.do", "/c_updateOK.do", "/c_deleteOK.do" })
public class CommentsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CommentsDAO dao = new CommentsDAOimpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()...");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String sPath = request.getServletPath();
		
		if(sPath.equals("/c_insertOK.do")) {
			String bnum = request.getParameter("bnum")==null?"0":request.getParameter("bnum");
			System.out.println(bnum);
			System.out.println(request.getParameter("content"));
			System.out.println(request.getParameter("writer"));
			
			
			System.out.println("============");
			
			CommentsVO vo = new CommentsVO();
			vo.setContent(request.getParameter("content"));
			vo.setWriter(request.getParameter("writer"));
			vo.setBnum(Integer.parseInt(bnum));
			
			int result = dao.insert(vo);
			System.out.println("result:"+result);
			System.out.println("============");
			
			if(result == 1) {
				response.sendRedirect("b_selectOne.do?num="+bnum);
			}else {
				response.sendRedirect("b_selectOne.do?num="+bnum+"&msg=fail");
			}
			
		}else if(sPath.equals("/c_deleteOK.do")) {
			
			String num = request.getParameter("num")==null?"0":request.getParameter("num");//PK
			String bnum = request.getParameter("bnum")==null?"0":request.getParameter("bnum");
			
			System.out.println("num:"+num);
			System.out.println("bnum:"+bnum);
			
			CommentsVO vo = new CommentsVO();
			vo.setNum(Integer.parseInt(num));
			
			int result = dao.delete(vo);
			System.out.println("result:"+result);
			
			System.out.println("============");
			
			if(result == 1) {
				response.sendRedirect("b_selectOne.do?num="+bnum);
			}else {
				response.sendRedirect("b_selectOne.do?num="+bnum+"&msg_del=fail");
			}
			
		}else if(sPath.equals("/c_updateOK.do")) {
			
			String num = request.getParameter("num")==null?"0":request.getParameter("num");//PK
			String bnum = request.getParameter("bnum")==null?"0":request.getParameter("bnum");
			
			System.out.println("num:"+num);
			System.out.println("bnum:"+bnum);
			System.out.println(request.getParameter("content"));
			
			CommentsVO vo = new CommentsVO();
			vo.setNum(Integer.parseInt(num));
			vo.setContent(request.getParameter("content"));
			
			int result = dao.update(vo);
			System.out.println("result:"+result);
			
			System.out.println("============");
			
			if(result == 1) {
				response.sendRedirect("b_selectOne.do?num="+bnum);
			}else {
				response.sendRedirect("b_selectOne.do?num="+bnum+"&msg_up=fail");
			}
			
		}
		
	}//end doGet()...

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()...");
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}//end doPost()...

}
