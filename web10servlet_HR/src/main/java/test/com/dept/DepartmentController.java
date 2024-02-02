package test.com.dept;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.emp.EmployeeVO;
import test.com.location.LocationVO;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet({ "/deptAll.do","/deptSearch.do","/deptInsert.do","/deptInsertOK.do",
	"/deptOne.do","/deptUpdate.do","/deptUpdateOK.do","/deptDelete.do","/deptDeleteOK.do"})
public class DepartmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DepartmentDAO dao = new DepartmentDAOimpl();
       
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
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String sPath = request.getServletPath();
		
		if(sPath.equals("/deptAll.do")) {
			int cpage = Integer.parseInt(request.getParameter("cpage") == null ? "1" : request.getParameter("cpage"));
			int pageBlock = 10;
			
			List<DepartmentVO> vos = dao.selectAll(cpage, pageBlock);
//			for (DepartmentVO x : vos) {
//				System.out.println(x);
//			}
			System.out.println("vos.size():"+vos.size());
			System.out.println("=================");
			
			request.setAttribute("vos", vos);
			
			
			int total_rows = dao.getTotalRows();
			System.out.println("total_rows:" + total_rows);

			int totalPageCount = 1;
			if (total_rows / pageBlock == 0) {
				totalPageCount = 1;
			} else if (total_rows % pageBlock == 0) {
				totalPageCount = total_rows / pageBlock;
			} else {
				totalPageCount = total_rows / pageBlock + 1;
			}
			// 페이지 링크 몇개?
			request.setAttribute("totalPageCount", totalPageCount);

			
			request.getRequestDispatcher("dept/selectAll.jsp").forward(request, response);
		
		
		
		}else if(sPath.equals("/deptSearch.do")) {
			int cpage = Integer.parseInt(request.getParameter("cpage") == null ? "1" : request.getParameter("cpage"));
			int pageBlock = 10;
			
			String searchKey = request.getParameter("searchKey");
			String searchWord = request.getParameter("searchWord");
			
			List<DepartmentVO> vos = dao.searchList(searchKey,searchWord,cpage, pageBlock);
//			for (DepartmentVO x : vos) {
//				System.out.println(x);
//			}
			System.out.println("vos.size():"+vos.size());
			System.out.println("=================");
			
			request.setAttribute("vos", vos);
			
			
			int total_rows = dao.getSearchTotalRows(searchKey,searchWord);
			System.out.println("total_rows:" + total_rows);

			int totalPageCount = 1;
			if (total_rows / pageBlock == 0) {
				totalPageCount = 1;
			} else if (total_rows % pageBlock == 0) {
				totalPageCount = total_rows / pageBlock;
			} else {
				totalPageCount = total_rows / pageBlock + 1;
			}
			// 페이지 링크 몇개?
			request.setAttribute("totalPageCount", totalPageCount);

			
			request.getRequestDispatcher("dept/selectAll.jsp").forward(request, response);
		}else if(sPath.equals("/deptInsert.do")) {
			
			List<EmployeeVO> employeeIds = dao.getEmployeeIds();
			for (EmployeeVO x : employeeIds) {
				System.out.println(x.getEmployee_id());
			}
			
			request.setAttribute("employeeIds", employeeIds);
			
			List<LocationVO> location_ids = dao.getLocation_ids();
			for (LocationVO x : location_ids) {
				System.out.println(x.getLocation_id());
			}
			
			request.setAttribute("location_ids", location_ids);
			
			request.getRequestDispatcher("dept/insert.jsp").forward(request, response);
		}else if(sPath.equals("/deptInsertOK.do")) {
			String department_id = request.getParameter("department_id");
			String department_name = request.getParameter("department_name");
			String manager_id = request.getParameter("manager_id");
			String location_id = request.getParameter("location_id");
			
			System.out.println("department_id:"+department_name);
			System.out.println("manager_id:"+manager_id);
			System.out.println("location_id:"+location_id);
			
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
		}else if(sPath.equals("/deptOne.do")) {
			
			String department_id = request.getParameter("department_id")==null?"0":request.getParameter("department_id");
			System.out.println("department_id:"+department_id);
			
			DepartmentVO vo = new DepartmentVO();
			vo.setDepartment_id(Integer.parseInt(department_id));
			
			DepartmentVO vo2 = dao.selectOne(vo);
			System.out.println(vo2);
			System.out.println("==============");
			
			request.setAttribute("vo2", vo2);
			
			request.getRequestDispatcher("dept/selectOne.jsp").forward(request, response);

		}else if(sPath.equals("/deptDelete.do")) {
			
			
			request.getRequestDispatcher("dept/delete.jsp").forward(request, response);
			
		}else if(sPath.equals("/deptDeleteOK.do")) {
			String department_id = request.getParameter("department_id");
			
			System.out.println("department_id:"+department_id);
			
			EmployeeVO vo = new EmployeeVO();
			vo.setDepartment_id(Integer.parseInt(department_id));
			
			int result = dao.delete(vo);
			System.out.println("result:"+result);
			
			if(result == 1) {
				response.sendRedirect("deptAll.do");
			}else {
				response.sendRedirect("deptDelete.do?department_id="+department_id);
			}
		}
		
		
	}//end doGet...

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
