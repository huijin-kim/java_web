package test.com.dept;

import java.util.List;

public class DepartmentMain {

	public static void main(String[] args) {
		

		DepartmentDAO dao = new DepartmentDAOimpl();
		
		List<DepartmentVO> vos = dao.selectAll();
		for(DepartmentVO x : vos) {
			System.out.println(x);
		}

	}

}
