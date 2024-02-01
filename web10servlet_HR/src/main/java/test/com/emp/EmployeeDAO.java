package test.com.emp;

import java.util.List;

import test.com.job.JOBVO;

public interface EmployeeDAO {

	public List<EmployeeVO> selectAll();
	public List<EmployeeVO> selectAll(int cpage, int pageBlock);
	public int getTotalRows();
	
	public List<EmployeeJoinDepartmentVO> selectAllEmployeeJoinDepartment();
	 
	
	//emp + job
	public List<EmpJoinJobVO> selectAllEmpJonJob();
	
	//emp + dept + job
	public List<EmpJoinDeptJoinJobVO> selectAllEmpJoinDeptJoinJob();
	public List<EmployeeVO> searchList(String searchKey, String searchWord, int cpage, int pageBlock);

	public int getSearchTotalRows(String searchKey, String searchWord);
	public int insert(EmployeeVO vo);
	public List<JOBVO> getJob_ids();

}
