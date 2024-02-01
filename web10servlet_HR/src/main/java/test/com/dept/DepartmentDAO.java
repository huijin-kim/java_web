package test.com.dept;

import java.util.List;

public interface DepartmentDAO {
	
	List<DepartmentVO> selectAll();
	
	List<DepartmentVO> selectAllDepartmentJoinLocation();

}
