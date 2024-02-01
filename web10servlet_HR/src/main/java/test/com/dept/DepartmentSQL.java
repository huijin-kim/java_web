package test.com.dept;

public interface DepartmentSQL {
	
	String SELECT_ALL = "select * from DEPARTMENTS";
	
	
	String SELECT_ALL_PAGE_BLOCK = "select rnum, department_id, department_name, manager_id, location_id "
			+ "from(select rownum rnum, department_id, department_name, manager_id, location_id from departments order by rnum desc) "
			+ "where rnum between ? and ? ";
	String TOTAL_ROWS = "select count(*) total_rows from departments";
	
	String SEARCHLIST_PAGE_BLOCK_DEPARTMENT_NAME = "select rnum, department_id, department_name, manager_id, location_id "
			+ "from(select rownum rnum, department_id, department_name, manager_id, location_id from departments  "
			+ "where department_name like ? order by rnum desc) "
			+ "where rnum between ? and ? ";
	String SEARCHLIST_PAGE_BLOCK_LOCATION_ID = "select rnum, department_id, department_name, manager_id, location_id "
			+ "from(select rownum rnum, department_id, department_name, manager_id, location_id from departments  "
			+ "where location_id like ? order by rnum desc) "
			+ "where rnum between ? and ?";
	
	String SEARCH_TOTAL_ROWS_DEPARTMENT_NAME = "select count(*) total_rows from departments where department_name like ?";
	String SEARCH_TOTAL_ROWS_LOCATION_ID = "select count(*) total_rows from departments where location_id like ?";


	String INSERT = "INSERT INTO DEPARTMENTS(department_id, department_name, manager_id, location_id) values(?,?,?,?)";

}
