package test.com.dept;

import java.util.List;

import test.com.emp.EmployeeVO;
import test.com.location.LocationVO;

public interface DepartmentDAO {
	
	List<DepartmentVO> selectAll();
	
	List<DepartmentVO> selectAllDepartmentJoinLocation();

	List<DepartmentVO> selectAll(int cpage, int pageBlock);

	int getTotalRows();

	List<DepartmentVO> searchList(String searchKey, String searchWord, int cpage, int pageBlock);

	int getSearchTotalRows(String searchKey, String searchWord);

	int insert(DepartmentVO vo);


	public List<EmployeeVO> getEmployeeIds();

	public List<LocationVO> getLocation_ids();

	public DepartmentVO selectOne(DepartmentVO vo);

	int delete(EmployeeVO vo);


}
