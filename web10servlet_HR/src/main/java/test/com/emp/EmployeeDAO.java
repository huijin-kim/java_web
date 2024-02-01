package test.com.emp;

import java.util.List;

public interface EmployeeDAO {

	public List<EmployeeVO> selectAll();
	public List<EmployeeVO> selectAll(int cpage, int pageBlock);
	public int getTotalRows();
	
	public List<EmployeeJoinDepartmentVO> selectAllEmployeeJoinDepartment();
	 
	
	//emp + job
	public List<EmpJoinJobVO> selectAllEmpJonJob();
	
	//emp + dept + job
	public List<EmpJoinDeptJoinJobVO> selectAllEmpJoinDeptJoinJob();
}
