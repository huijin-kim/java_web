package test.com.emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.com.db.DBinfo;
import test.com.dept.DepartmentVO;
import test.com.job.JOBVO;

public class EmployeeDAOimpl implements EmployeeDAO {

	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public EmployeeDAOimpl() {
		System.out.println("EmployeeDAOimpl()....");

		try {
			Class.forName(DBinfo.DRIVER_NAME);
			System.out.println("driver successed...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public List<EmployeeVO> selectAll() {
		System.out.println("selectAll()...");
		List<EmployeeVO> vos = new ArrayList<EmployeeVO>();
		
		try {
			// 1.커넥션(계정접속)
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			System.out.println("conn successed...");

			// 2.SQL(질의문) 세팅
			pstmt = conn.prepareStatement(EmployeeSQL.SELECT_ALL);
			System.out.println(pstmt);

			// 3.결과반환 rs >> vos
			rs = pstmt.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				EmployeeVO vo2 = new EmployeeVO();
				vo2.setEmployee_id(rs.getInt("employee_id"));
				vo2.setFirst_name(rs.getString("first_name"));
				vo2.setLast_name(rs.getString("last_name"));
				vo2.setEmail(rs.getString("email"));
				vo2.setPhone_number(rs.getString("phone_number"));
				vo2.setHire_date(rs.getString("hire_date"));
				vo2.setJob_id(rs.getString("job_id"));
				vo2.setSalary(rs.getInt("salary"));
				vo2.setCommission_pct(rs.getDouble("commission_pct"));
				vo2.setManager_id(rs.getInt("manager_id"));
				vo2.setDepartment_id(rs.getInt("department_id"));
				vos.add(vo2);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end finally

		

		return vos;
	}

	@Override
	public List<EmployeeJoinDepartmentVO> selectAllEmployeeJoinDepartment() {
		System.out.println("selectAllEmployeeJoinDepartment()...");
		List<EmployeeJoinDepartmentVO> vos = new ArrayList<EmployeeJoinDepartmentVO>();
		
		try {
			// 1.커넥션(계정접속)
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			System.out.println("conn successed...");

			// 2.SQL(질의문) 세팅
			pstmt = conn.prepareStatement(EmployeeSQL.SELECT_ALLJOINDEPARTMENT);
			System.out.println(pstmt);

			// 3.결과반환 rs >> vos
			rs = pstmt.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				EmployeeJoinDepartmentVO vo2 = new EmployeeJoinDepartmentVO();
				vo2.setEmployee_id(rs.getInt("employee_id"));
				vo2.setFirst_name(rs.getString("first_name"));
				vo2.setLast_name(rs.getString("last_name"));
				vo2.setEmail(rs.getString("email"));
				vo2.setPhone_number(rs.getString("phone_number"));
				vo2.setHire_date(rs.getString("hire_date"));
				vo2.setJob_id(rs.getString("job_id"));
				vo2.setSalary(rs.getInt("salary"));
				vo2.setCommission_pct(rs.getDouble("commission_pct"));
				vo2.setManager_id(rs.getInt("manager_id"));
				vo2.setDepartment_id(rs.getInt("department_id"));
				vo2.setDepartment_name(rs.getString("department_name"));
				vos.add(vo2);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end finally

		

		return vos;
	}


	@Override
	public List<EmpJoinJobVO> selectAllEmpJonJob() {
		System.out.println("selectAllEmpJonJob()...");
		List<EmpJoinJobVO> vos = new ArrayList<EmpJoinJobVO>();
		
		try {
			// 1.커넥션(계정접속)
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			System.out.println("conn successed...");

			// 2.SQL(질의문) 세팅
			pstmt = conn.prepareStatement(EmployeeSQL.SELECT_ALLJOINJOB);
			System.out.println(pstmt);

			// 3.결과반환 rs >> vos
			rs = pstmt.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				EmpJoinJobVO vo2 = new EmpJoinJobVO();
				vo2.setEmployee_id(rs.getInt("employee_id"));
				vo2.setFirst_name(rs.getString("first_name"));
				vo2.setLast_name(rs.getString("last_name"));
				vo2.setEmail(rs.getString("email"));
				vo2.setPhone_number(rs.getString("phone_number"));
				vo2.setHire_date(rs.getString("hire_date"));
				vo2.setJob_id(rs.getString("job_id"));
				vo2.setSalary(rs.getInt("salary"));
				vo2.setCommission_pct(rs.getDouble("commission_pct"));
				vo2.setManager_id(rs.getInt("manager_id"));
				vo2.setDepartment_id(rs.getInt("department_id"));
				vo2.setJob_title(rs.getString("job_title"));
				vos.add(vo2);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end finally

		

		return vos;
	}


	@Override
	public List<EmpJoinDeptJoinJobVO> selectAllEmpJoinDeptJoinJob() {
		System.out.println("selectAllEmpJoinDeptJoinJob()...");
		List<EmpJoinDeptJoinJobVO> vos = new ArrayList<EmpJoinDeptJoinJobVO>();
		
		try {
			// 1.커넥션(계정접속)
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			System.out.println("conn successed...");

			// 2.SQL(질의문) 세팅
			pstmt = conn.prepareStatement(EmployeeSQL.SELECT_ALLJOINEMPJOINDEPTJOINJOB);
			System.out.println(pstmt);

			// 3.결과반환 rs >> vos
			rs = pstmt.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				EmpJoinDeptJoinJobVO vo2 = new EmpJoinDeptJoinJobVO();
				vo2.setEmployee_id(rs.getInt("employee_id"));
				vo2.setFirst_name(rs.getString("first_name"));
				vo2.setLast_name(rs.getString("last_name"));
				vo2.setEmail(rs.getString("email"));
				vo2.setPhone_number(rs.getString("phone_number"));
				vo2.setHire_date(rs.getString("hire_date"));
				vo2.setJob_id(rs.getString("job_id"));
				vo2.setSalary(rs.getInt("salary"));
				vo2.setCommission_pct(rs.getDouble("commission_pct"));
				vo2.setManager_id(rs.getInt("manager_id"));
				vo2.setDepartment_id(rs.getInt("department_id"));
				vo2.setDepartment_name(rs.getString("department_name"));
				vo2.setJob_title(rs.getString("job_title"));
				vos.add(vo2);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end finally

		return vos;
		

	}


	@Override
	public List<EmployeeVO> selectAll(int cpage, int pageBlock) {
		System.out.println("selectAll()...");
		System.out.println("cpage: " + cpage);
		System.out.println("pageBlock : " + pageBlock);
		
		int startRow = (cpage -1 ) * pageBlock +1;
		int endRow = startRow + pageBlock -1;
		System.out.println(startRow + "," + endRow);
		
		List<EmployeeVO> vos = new ArrayList<EmployeeVO>();
		
		
		try {
			// 1.커넥션(계정접속)
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			System.out.println("conn successed...");

			// 2.SQL(질의문) 세팅
			pstmt = conn.prepareStatement(EmployeeSQL.SELECT_ALL_PAGE_BLOCK);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			System.out.println(pstmt);

			// 3.결과반환 rs >> vos
			rs = pstmt.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				EmployeeVO vo2 = new EmployeeVO();
				vo2.setEmployee_id(rs.getInt("employee_id"));
				vo2.setFirst_name(rs.getString("first_name"));
				vo2.setLast_name(rs.getString("last_name"));
				vo2.setEmail(rs.getString("email"));
				vo2.setPhone_number(rs.getString("phone_number"));
				vo2.setHire_date(rs.getString("hire_date"));
				vo2.setJob_id(rs.getString("job_id"));
				vo2.setSalary(rs.getInt("salary"));
				vo2.setCommission_pct(rs.getDouble("commission_pct"));
				vo2.setManager_id(rs.getInt("manager_id"));
				vo2.setDepartment_id(rs.getInt("department_id"));
				vos.add(vo2);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end finally

		return vos;
	}


	@Override
	public int getTotalRows() {
		System.out.println("getTotalRows()....");

		int total_rows = 0;

		try {
			// 1.커넥션(계정접속)
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			System.out.println("conn successed...");

			// 2.SQL(질의문) 세팅
			pstmt = conn.prepareStatement(EmployeeSQL.TOTAL_ROWS);
			System.out.println(pstmt);

			// 3.결과반환 rs >> vos
			rs = pstmt.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				total_rows = rs.getInt("total_rows");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end finally

		return total_rows;
	}


	@Override
	public List<EmployeeVO> searchList(String searchKey, String searchWord, int cpage, int pageBlock) {
		System.out.println("searchList()....");
		System.out.println(searchKey);
		System.out.println(searchWord);
		
		System.out.println("cpage:" + cpage);
		System.out.println("pageBlock:" + pageBlock);

		int startRow = (cpage - 1) * pageBlock + 1;
		int endRow = startRow + pageBlock - 1;
		System.out.println(startRow + "," + endRow);
		
		String sql = "";
		if (searchKey.equals("name")) {
			sql = EmployeeSQL.SEARCHLIST_PAGE_BLOCK_NAME;
		} else if (searchKey.equals("job_id")) {
			sql = EmployeeSQL.SEARCHLIST_PAGE_BLOCK_JOBID;
		}

		
		List<EmployeeVO> vos = new ArrayList<EmployeeVO>();

		try {
			// 1.커넥션(계정접속)
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			System.out.println("conn successed...");

			// 2.SQL(질의문) 세팅
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+searchWord+"%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			System.out.println(pstmt);

			// 3.결과반환 rs >> vos
			rs = pstmt.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				EmployeeVO vo2 = new EmployeeVO();
				vo2.setEmployee_id(rs.getInt("employee_id"));
				vo2.setFirst_name(rs.getString("first_name"));
				vo2.setLast_name(rs.getString("last_name"));
				vo2.setEmail(rs.getString("email"));
				vo2.setPhone_number(rs.getString("phone_number"));
				vo2.setHire_date(rs.getString("hire_date"));
				vo2.setJob_id(rs.getString("job_id"));
				vo2.setSalary(rs.getInt("salary"));
				vo2.setCommission_pct(rs.getDouble("commission_pct"));
				vo2.setManager_id(rs.getInt("manager_id"));
				vo2.setDepartment_id(rs.getInt("department_id"));
				vos.add(vo2);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end finally

		return vos;
		
		
	}


	@Override
	public int getSearchTotalRows(String searchKey, String searchWord) {
		System.out.println("getSearchTotalRows()....");
		System.out.println(searchKey);
		System.out.println(searchWord);
		
		String sql = "";
		if (searchKey.equals("name")) {
			sql = EmployeeSQL.SEARCH_TOTAL_ROWS_NAME;
		} else if (searchKey.equals("job_id")) {
			sql = EmployeeSQL.SEARCH_TOTAL_ROWS_JOBID;
		}
		
		int total_rows = 0;
		
		try {
			// 1.커넥션(계정접속)
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			System.out.println("conn successed...");

			// 2.SQL(질의문) 세팅
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + searchWord + "%");
			System.out.println(pstmt);

			// 3.결과반환 rs >> vos
			rs = pstmt.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				total_rows = rs.getInt("total_rows");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end finally

		return total_rows;
	}


	@Override
	public int insert(EmployeeVO vo) {
		System.out.println("insert()....");
		System.out.println(vo);
		
		int flag = 0;
		
		try {
			// 1.커넥션(계정접속)
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			System.out.println("conn successed...");

			// 2.SQL(질의문) 세팅
			pstmt = conn.prepareStatement(EmployeeSQL.INSERT);
			pstmt.setString(1, vo.getFirst_name());
			pstmt.setString(2, vo.getLast_name());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getPhone_number());
			pstmt.setString(5, vo.getHire_date());
			pstmt.setString(6, vo.getJob_id());
			pstmt.setInt(7, vo.getSalary());
			pstmt.setDouble(8, vo.getCommission_pct());
			pstmt.setInt(9, vo.getManager_id());
			pstmt.setInt(10, vo.getDepartment_id());

			flag = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end finally
		
		return flag;
	}


	@Override
	public List<JOBVO> getJob_ids() {
		System.out.println("getJob_ids()...");
		
		List<JOBVO> job_ids = new ArrayList<JOBVO>();
		
		try {
			// 1.커넥션(계정접속)
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			System.out.println("conn successed...");

			// 2.SQL(질의문) 세팅
			pstmt = conn.prepareStatement(EmployeeSQL.SELECT_JOB_ID);
			
			// 3.결과반환 rs >> vos
			rs = pstmt.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				JOBVO vo = new JOBVO();
				vo.setJob_id(rs.getString("job_id"));
				job_ids.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end finally
		
		return job_ids;
	}


	@Override
	public List<DepartmentVO> getmanager_ids() {
		System.out.println("getmanager_ids()...");
		
		List<DepartmentVO> manager_ids = new ArrayList<DepartmentVO>();
		
		try {
			// 1.커넥션(계정접속)
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			System.out.println("conn successed...");

			// 2.SQL(질의문) 세팅
			pstmt = conn.prepareStatement(EmployeeSQL.SELECT_MANAGER_ID);
			
			// 3.결과반환 rs >> vos
			rs = pstmt.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				DepartmentVO vo = new DepartmentVO();
				vo.setManager_id(rs.getInt("manager_id"));
				manager_ids.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end finally
		
		return manager_ids;
	}


	@Override
	public List<DepartmentVO> getdepartment_ids() {
		System.out.println("getdepartment_ids()...");
		
		List<DepartmentVO> department_ids = new ArrayList<DepartmentVO>();
		
		try {
			// 1.커넥션(계정접속)
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			System.out.println("conn successed...");

			// 2.SQL(질의문) 세팅
			pstmt = conn.prepareStatement(EmployeeSQL.SELECT_DEPARTMENT_ID);
			
			// 3.결과반환 rs >> vos
			rs = pstmt.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				DepartmentVO vo = new DepartmentVO();
				vo.setDepartment_id(rs.getInt("department_id"));
				department_ids.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end finally
		
		return department_ids;
	}


	@Override
	public EmployeeVO selectOne(EmployeeVO vo) {
		System.out.println("selectOne()....");
		System.out.println(vo);

		// select * from member where num=6

		EmployeeVO vo2 = new EmployeeVO();
		
		
		try {
			// 1.커넥션(계정접속)
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			System.out.println("conn successed...");

			// 2.SQL(질의문) 세팅
			// select * from member
			pstmt = conn.prepareStatement(EmployeeSQL.SELECT_ONE);
			pstmt.setInt(1, vo.getEmployee_id());
			System.out.println(pstmt);

			// 3.결과반환 rs >> vos
			rs = pstmt.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				vo2.setEmployee_id(rs.getInt("employee_id"));
				vo2.setFirst_name(rs.getString("first_name"));
				vo2.setLast_name(rs.getString("last_name"));
				vo2.setEmail(rs.getString("email"));
				vo2.setPhone_number(rs.getString("phone_number"));
				vo2.setHire_date(rs.getString("hire_date"));
				vo2.setJob_id(rs.getString("job_id"));
				vo2.setSalary(rs.getInt("salary"));
				vo2.setCommission_pct(rs.getDouble("commission_pct"));
				vo2.setManager_id(rs.getInt("manager_id"));
				vo2.setDepartment_id(rs.getInt("department_id"));
				
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end finally
		
		
		return vo2;
	}
	
	
	
	@Override
	public int update(EmployeeVO vo) {
		System.out.println("update()....");
		System.out.println(vo);

		int flag = 0;

		try {
			// 1.커넥션(계정접속)
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			System.out.println("conn successed...");

			// 2.SQL(질의문) 세팅
			pstmt = conn.prepareStatement(EmployeeSQL.UPDATE);
			pstmt.setString(1, vo.getFirst_name());
			pstmt.setString(2, vo.getLast_name());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getPhone_number());
			pstmt.setString(5, vo.getHire_date());
			pstmt.setString(6, vo.getJob_id());
			pstmt.setInt(7, vo.getSalary());
			pstmt.setDouble(8, vo.getCommission_pct());
			pstmt.setInt(9, vo.getManager_id());
			pstmt.setInt(10, vo.getDepartment_id());
			pstmt.setInt(11, vo.getEmployee_id());
			
			flag = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end finally

		return flag;
	}

	@Override
	public int delete(EmployeeVO vo) {
		System.out.println("delete()....");
		System.out.println(vo);

		int flag = 0;

		try {
			// 1.커넥션(계정접속)
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			System.out.println("conn successed...");

			// 2.SQL(질의문) 세팅
			pstmt = conn.prepareStatement(EmployeeSQL.DELETE);
			pstmt.setInt(1, vo.getEmployee_id());
			
			flag = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end finally

		return flag;
	}

}
