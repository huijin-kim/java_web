package test.com.dept;

import java.util.List;

public interface DepartmentDAO {
	
	List<DepartmentVO> selectAll();
	
	List<DepartmentVO> selectAllDepartmentJoinLocation();

	List<DepartmentVO> selectAll(int cpage, int pageBlock);

	int getTotalRows();

	List<DepartmentVO> searchList(String searchKey, String searchWord, int cpage, int pageBlock);

	int getSearchTotalRows(String searchKey, String searchWord);

	int insert(DepartmentVO vo);

}
