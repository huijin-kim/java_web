package test.com.emp;

import java.util.List;

import test.com.job.JOBDAO;
import test.com.job.JOBVO;
import test.com.job.JobDAOimpl;

public class EmployeeMain {

	public static void main(String[] args) {
	
		EmployeeDAO dao = new EmployeeDAOimpl();
	
		List<EmployeeVO> vos = dao.selectAll();
		for (EmployeeVO x : vos) {
			System.out.println(x);
		}
		System.out.println("=================");
		
		List<EmployeeJoinDepartmentVO> vos2 = dao.selectAllEmployeeJoinDepartment();
		for (EmployeeJoinDepartmentVO x : vos2) {
			System.out.println(x);
		}
		
		System.out.println("\n ================== \n");
		//job
		JOBDAO dao2 = new JobDAOimpl();
		
		List<JOBVO> vos1 = dao2.selectAll();
		for(JOBVO x : vos1) {
			System.out.println(x);
		}
		
		System.out.println("\n ================== \n");
		//emp+job
		List<EmpJoinJobVO> vos3 = dao.selectAllEmpJonJob();
		for(EmpJoinJobVO x :vos3) {
			System.out.println(x);
		}
		
		System.out.println("\n ================== \n");
		//emp+dept+job
		List<EmpJoinDeptJoinJobVO> vos4 = dao.selectAllEmpJoinDeptJoinJob();
		for(EmpJoinDeptJoinJobVO x : vos4) {
			System.out.println(x);
		}
		
	}//end main

}//end class
