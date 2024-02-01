package test.com.emp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet({"/index.do", "/empAll.do"})
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDAO dao = new EmployeeDAOimpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());  //주석 처리 안하면 클릭 시 한글 깨짐.
		
		String sPath = request.getServletPath();
		
		if(sPath.equals("/index.do")) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else if(sPath.equals("/empAll.do")) {
			
			int cpage= Integer.parseInt(request.getParameter("cpage")== null? "1" : request.getParameter("cage"));
			int pageBlock = 5;
			
			List<EmployeeVO> vos = dao.selectAll(cpage, pageBlock);
			for(EmployeeVO x : vos) {
				System.out.println(x);
			}
			System.out.println("=============");
			
			request.setAttribute("vos", vos);
			
			int total_rows = dao.getTotalRows();
			System.out.println("total_rows : " + total_rows);
			
			int totalPageCount = 1;
			if(total_rows/pageBlock == 0) {
				totalPageCount = 1;
			}else if (total_rows%pageBlock == 0) {
				totalPageCount = total_rows/pageBlock;
			}else if (total_rows/pageBlock != 0) {
				totalPageCount = total_rows/pageBlock + 1;
			}
			
			request.setAttribute("totalPageCount", totalPageCount);
			
			request.getRequestDispatcher("emp/selectAll.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");// post요청시 한글처리
		doGet(request, response);
	}

}
