package test.com.emp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.dept.DepartmentVO;
import test.com.job.JOBVO;


/**
 * Servlet implementation class EmployeeController
 */
@WebServlet({"/empAll.do", "/empSearch.do", "/empInsert.do","/empInsertOK.do"})
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
		
		if(sPath.equals("/empAll.do")) {
			
			//에러 : Cannot parse null string  - cage  오타남. 
			int cpage= Integer.parseInt(request.getParameter("cpage")== null? "1" : request.getParameter("cpage"));
			int pageBlock = 10;
			
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
			}else if(total_rows%pageBlock == 0) {
				totalPageCount = total_rows/pageBlock;
			}else if(total_rows/pageBlock != 0) {
				totalPageCount = total_rows/pageBlock + 1;
			}
			
			request.setAttribute("totalPageCount", totalPageCount);
			
			request.getRequestDispatcher("emp/selectAll.jsp").forward(request, response);
		}else if(sPath.equals("/empSearch.do")) {
			
			int cpage= Integer.parseInt(request.getParameter("cpage")== null? "1" : request.getParameter("cpage"));
			int pageBlock = 10;
			
			String searchKey = request.getParameter("searchKey");
			String searchWord = request.getParameter("searchWord");
			
			List<EmployeeVO> vos = dao.searchList(searchKey, searchWord, cpage, pageBlock);
			for(EmployeeVO x : vos) {
				System.out.println(x);
			}
			System.out.println("=============");
			
			request.setAttribute("vos", vos);
			
			int total_rows = dao.getSearchTotalRows(searchKey, searchWord);
			System.out.println("total_rows : " + total_rows);
			
			int totalPageCount = 1;
			if(total_rows/pageBlock == 0) {
				totalPageCount = 1;
			}else if(total_rows%pageBlock == 0) {
				totalPageCount = total_rows/pageBlock;
			}else if(total_rows/pageBlock != 0) {
				totalPageCount = total_rows/pageBlock + 1;
			}
			
			request.setAttribute("totalPageCount", totalPageCount);
			
			request.getRequestDispatcher("emp/selectAll.jsp").forward(request, response);
			
		}else if(sPath.equals("/empInsert.do")) {
			List<JOBVO> job_ids = dao.getJob_ids();
			for(JOBVO x : job_ids) {
				System.out.println(x.getJob_id());
			}
			
			request.setAttribute("dob_ids", job_ids);
			
			request.getRequestDispatcher("emp/insert.jsp").forward(request, response);
		}else if(sPath.equals("/empInsertOK.do")) {
			
			String first_name = request.getParameter("first_name");
			String last_name = request.getParameter("last_name");
			String email = request.getParameter("email");
			String phone_number = request.getParameter("phone_number");
			String hire_date = request.getParameter("hire_date");
			String job_id = request.getParameter("job_id");
			String salary = request.getParameter("salary");
			String commission_pct = request.getParameter("commission_pct");
			String manager_id = request.getParameter("manager_id");
			String department_id = request.getParameter("department_id");
			
			System.out.println("first_name:"+first_name);
			System.out.println("last_name:"+last_name);
			System.out.println("email:"+email);
			System.out.println("phone_number:"+phone_number);
			System.out.println("hire_date:"+hire_date);
			System.out.println("job_id:"+job_id);
			System.out.println("salary:"+salary);
			System.out.println("commission_pct:"+commission_pct);
			System.out.println("manager_id:"+manager_id);
			System.out.println("department_id:"+department_id);
			
			EmployeeVO vo = new EmployeeVO();
			vo.setFirst_name(first_name);
			vo.setLast_name(last_name);
			vo.setEmail(email);
			vo.setPhone_number(phone_number);
			vo.setHire_date(hire_date);
			vo.setJob_id(job_id);
			vo.setSalary(Integer.parseInt(salary));
			vo.setCommission_pct(Double.parseDouble(commission_pct));
			vo.setManager_id(Integer.parseInt(manager_id));
			vo.setDepartment_id(Integer.parseInt(department_id));
			
			int result = dao.insert(vo);
			System.out.println("result:"+result);
			
			if(result == 1) {
				response.sendRedirect("empAll.do");
			}else {
				response.sendRedirect("empInsert.do");
			}
		}
	}//doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");// post요청시 한글처리
		doGet(request, response);
	}
}
