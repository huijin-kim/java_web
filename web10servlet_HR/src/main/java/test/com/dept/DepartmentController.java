package test.com.dept;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class DepartmentController
 */
@WebServlet({ "/deptAll.do", "/deptSearch.do", "/deptInsert.do", "/deptInsertOK.do" })
public class DepartmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DepartmentDAO dao = new DepartmentDAOimpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sPath = request.getServletPath();
		
		if(sPath.equals("/deptAll.do")) {
			
			int cpage= Integer.parseInt(request.getParameter("cpage")== null? "1" : request.getParameter("cpage"));
			
			System.out.println("request에서 cpage 값: " + request.getParameter("cpage"));

			int pageBlock = 10;
			
			List<DepartmentVO> vos = dao.selectAll(cpage, pageBlock);
			for(DepartmentVO x : vos) {
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
			
			request.getRequestDispatcher("dept/selectAll.jsp").forward(request, response);
			
		}else if(sPath.equals("/deptSearch.do")) {
			
			int cpage= Integer.parseInt(request.getParameter("cpage")== null? "1" : request.getParameter("cpage"));
			int pageBlock = 10;
			
			System.out.println("request에서 cpage 값: " + request.getParameter("cpage"));

			String searchKey = request.getParameter("searchKey");
			String searchWord = request.getParameter("searchWord");
			
			List<DepartmentVO> vos = dao.searchList(searchKey, searchWord, cpage, pageBlock);
			for(DepartmentVO x : vos) {
				System.out.println(x);
			}
			System.out.println("=============");
			
			request.setAttribute("vos", vos);
			
			int total_rows = dao.getSearchTotalRows(searchKey, searchWord);
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
			
			request.getRequestDispatcher("dept/selectAll.jsp").forward(request, response);
			
		}else if(sPath.equals("/deptInsert.do")) {
			request.getRequestDispatcher("dept/insert.jsp").forward(request, response);
			
		}else if(sPath.equals("/deptInsertOK.do")) {
			
			String department_id = request.getParameter("department_id");
			String department_name = request.getParameter("department_name");
			String manager_id = request.getParameter("manager_id");
			String location_id = request.getParameter("location_id");
			
			
			DepartmentVO vo = new DepartmentVO();
			vo.setDepartment_id(Integer.parseInt(department_id));
			vo.setDepartment_name(department_name);
			vo.setManager_id(Integer.parseInt(manager_id));
			vo.setLocation_id(Integer.parseInt(location_id));
			
			int result = dao.insert(vo);
			System.out.println("result:"+result);
			
			if(result == 1) {
				response.sendRedirect("deptAll.do");
			}else {
				response.sendRedirect("deptInsert.do");
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
