package test.com.emp;

public interface EmployeeSQL {
	
	String SELECT_ALL = "select * from employees order by employee_id";
	
	String SELECT_ALL_PAGE_BLOCK = "select rnum, employee_id,first_name,last_name,email,phone_number,hire_date,job_id,salary,commission_pct,manager_id,department_id  "
			+ "from(select rownum rnum, employee_id,first_name,last_name,email,phone_number,hire_date,job_id,salary,commission_pct,manager_id,department_id from employees order by employee_id desc)  "
			+ "WHERE rnum between ? and ?";
	
	String TOTAL_ROWS = "select count(*) total_rows from employees";
	
	String SELECT_ALLJOINDEPARTMENT = "select employee_id,first_name,last_name,email,"
			+ "phone_number,hire_date,job_id,salary,"
			+ "commission_pct,e.manager_id,"
			+ "e.department_id,department_name "
			+ "from employees e join departments d "
			+ "on e.department_id = d.department_id "
			+ "order by employee_id";
	
	
	String SELECT_ALLJOINJOB = "select employee_id,first_name,last_name,email,phone_number,   "
			+ "hire_date,e.job_id,salary,commission_pct,e.manager_id,   "
			+ "e.department_id,job_title   "
			+ "from employees e join jobs j   "
			+ "on e.job_id = j.job_id   "
			+ "order by employee_id";
	
	String SELECT_ALLJOINEMPJOINDEPTJOINJOB = "select employee_id,first_name,last_name,email,phone_number,  "
			+ "hire_date,e.job_id,salary,commission_pct,e.manager_id,  "
			+ "e.department_id,department_name ,job_title   "
			+ "from employees e join departments d   "
			+ "on e.department_id = d.department_id   "
			+ "join jobs j   "
			+ "on e.job_id = j.job_id   "
			+ "order by employee_id";

	String SEARCHLIST_PAGE_BLOCK_NAME = "select rnum, employee_id,first_name,last_name,email,phone_number,hire_date,job_id,salary,commission_pct,manager_id,department_id "
			+ "from(select rownum rnum, employee_id,first_name,last_name,email,phone_number,hire_date,job_id,salary,commission_pct,manager_id,department_id  "
			+ "from employees where first_name||' '||last_name like ? order by employee_id desc) "
			+ "WHERE rnum between ? and ?";

	String SEARCHLIST_PAGE_BLOCK_JOBID = "select rnum, employee_id,first_name,last_name,email,phone_number,hire_date,job_id,salary,commission_pct,manager_id,department_id  "
			+ "from(select rownum rnum, employee_id,first_name,last_name,email,phone_number,hire_date,job_id,salary,commission_pct,manager_id,department_id   "
			+ "from employees where job_id like ? order by employee_id desc)  "
			+ "WHERE rnum between ? and ? ";

	
	String SEARCH_TOTAL_ROWS_NAME = "select count(*) total_rows from employees where first_name||' '||last_name like ?";
	String SEARCH_TOTAL_ROWS_JOBID = "select count(*) total_rows from employees where job_id like ?";

	String INSERT = "INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id) "
			+ "VALUES(EMPLOYEES_SEQ.NEXTVAL,?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


}
