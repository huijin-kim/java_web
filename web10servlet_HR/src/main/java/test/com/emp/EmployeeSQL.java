package test.com.emp;

public interface EmployeeSQL {
	
	String SELECT_ALL = "select * from employees order by employee_id";
	
	String SELECT_ALL_PAGE_BLOCK = "select rnum, employee_id,first_name,last_name,email,phone_number,hire_date,job_id,salary,commission_pct,manager_id,department_id\n"
			+ "from(select rownum rnum, employee_id,first_name,last_name,email,phone_number,hire_date,job_id,salary,commission_pct,manager_id,department_id from employees order by employee_id desc)\n"
			+ "WHERE rnum between ? and ?";
	
	String TOTAL_ROWS = "select count(*) total_rows from employees";
	
	String SELECT_ALLJOINDEPARTMENT = "select employee_id,first_name,last_name,email,"
			+ "phone_number,hire_date,job_id,salary,"
			+ "commission_pct,e.manager_id,"
			+ "e.department_id,department_name "
			+ "from employees e join departments d "
			+ "on e.department_id = d.department_id "
			+ "order by employee_id";
	
	
	String SELECT_ALLJOINJOB = "select employee_id,first_name,last_name,email,phone_number, \n"
			+ "hire_date,e.job_id,salary,commission_pct,e.manager_id, \n"
			+ "e.department_id,job_title \n"
			+ "from employees e join jobs j \n"
			+ "on e.job_id = j.job_id \n"
			+ "order by employee_id";
	
	String SELECT_ALLJOINEMPJOINDEPTJOINJOB = "select employee_id,first_name,last_name,email,phone_number,\n"
			+ "hire_date,e.job_id,salary,commission_pct,e.manager_id,\n"
			+ "e.department_id,department_name ,job_title \n"
			+ "from employees e join departments d \n"
			+ "on e.department_id = d.department_id \n"
			+ "join jobs j \n"
			+ "on e.job_id = j.job_id \n"
			+ "order by employee_id";

}
