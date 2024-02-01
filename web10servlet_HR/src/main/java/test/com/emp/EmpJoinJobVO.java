package test.com.emp;

import java.util.Objects;

public class EmpJoinJobVO {
	
	private int employee_id;
	private String first_name;
	private String last_name;
	private String email;
	private String phone_number;
	private String hire_date;
	private String job_id;
	private int salary;
	private double commission_pct;
	private int manager_id;
	private int department_id;
	private String job_title;
	private int min_salary;
	private int max_salary;
	
	
	public EmpJoinJobVO() {
		// TODO Auto-generated constructor stub
	}


	public EmpJoinJobVO(int employee_id, String first_name, String last_name, String email, String phone_number,
			String hire_date, String job_id, int salary, double commission_pct, int manager_id, int department_id,
			String job_title, int min_salary, int max_salary) {
		super();
		this.employee_id = employee_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone_number = phone_number;
		this.hire_date = hire_date;
		this.job_id = job_id;
		this.salary = salary;
		this.commission_pct = commission_pct;
		this.manager_id = manager_id;
		this.department_id = department_id;
		this.job_title = job_title;
		this.min_salary = min_salary;
		this.max_salary = max_salary;
	}


	public int getEmployee_id() {
		return employee_id;
	}


	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone_number() {
		return phone_number;
	}


	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}


	public String getHire_date() {
		return hire_date;
	}


	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}


	public String getJob_id() {
		return job_id;
	}


	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public double getCommission_pct() {
		return commission_pct;
	}


	public void setCommission_pct(double commission_pct) {
		this.commission_pct = commission_pct;
	}


	public int getManager_id() {
		return manager_id;
	}


	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}


	public int getDepartment_id() {
		return department_id;
	}


	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}


	public String getJob_title() {
		return job_title;
	}


	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}


	public int getMin_salary() {
		return min_salary;
	}


	public void setMin_salary(int min_salary) {
		this.min_salary = min_salary;
	}


	public int getMax_salary() {
		return max_salary;
	}


	public void setMax_salary(int max_salary) {
		this.max_salary = max_salary;
	}


	@Override
	public String toString() {
		return "EmpJonJobVO [employee_id=" + employee_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", email=" + email + ", phone_number=" + phone_number + ", hire_date=" + hire_date + ", job_id="
				+ job_id + ", salary=" + salary + ", commission_pct=" + commission_pct + ", manager_id=" + manager_id
				+ ", department_id=" + department_id + ", job_title=" + job_title + ", min_salary=" + min_salary
				+ ", max_salary=" + max_salary + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(commission_pct, department_id, email, employee_id, first_name, hire_date, job_id, job_title,
				last_name, manager_id, max_salary, min_salary, phone_number, salary);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpJoinJobVO other = (EmpJoinJobVO) obj;
		return Double.doubleToLongBits(commission_pct) == Double.doubleToLongBits(other.commission_pct)
				&& department_id == other.department_id && Objects.equals(email, other.email)
				&& employee_id == other.employee_id && Objects.equals(first_name, other.first_name)
				&& Objects.equals(hire_date, other.hire_date) && Objects.equals(job_id, other.job_id)
				&& Objects.equals(job_title, other.job_title) && Objects.equals(last_name, other.last_name)
				&& manager_id == other.manager_id && max_salary == other.max_salary && min_salary == other.min_salary
				&& Objects.equals(phone_number, other.phone_number) && salary == other.salary;
	}
	
	
	
	
	

}
