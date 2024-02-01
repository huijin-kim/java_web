package test.com.job;

import java.util.Objects;

public class JOBVO {
	
	private String job_id;
	private String job_title;
	private int min_salary;
	private int max_salary;
	
	public JOBVO() {
		// TODO Auto-generated constructor stub
	}

	public JOBVO(String job_id, String job_title, int min_salary, int max_salary) {
		super();
		this.job_id = job_id;
		this.job_title = job_title;
		this.min_salary = min_salary;
		this.max_salary = max_salary;
	}

	public String getJob_id() {
		return job_id;
	}

	public void setJob_id(String job_id) {
		this.job_id = job_id;
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
		return "JOBVO [job_id=" + job_id + ", job_title=" + job_title + ", min_salary=" + min_salary + ", max_salary="
				+ max_salary + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(job_id, job_title, max_salary, min_salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JOBVO other = (JOBVO) obj;
		return Objects.equals(job_id, other.job_id) && Objects.equals(job_title, other.job_title)
				&& max_salary == other.max_salary && min_salary == other.min_salary;
	}
	
	

}
