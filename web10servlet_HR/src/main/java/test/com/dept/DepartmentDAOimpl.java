package test.com.dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.com.db.DBinfo;


public class DepartmentDAOimpl implements DepartmentDAO {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public DepartmentDAOimpl() {
		System.out.println("DepartmentDAOimpl()");
		
		try {
			Class.forName(DBinfo.DRIVER_NAME);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public List<DepartmentVO> selectAll() {
		
		List<DepartmentVO> vos = new ArrayList<DepartmentVO>();
		
		try {
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			System.out.println("conn successed....");
			
			pstmt = conn.prepareStatement(DepartmentSQL.SELECT_ALL);
			System.out.println(pstmt);

			rs = pstmt.executeQuery();
			System.out.println(rs);
			while(rs.next()) {
				DepartmentVO vo = new DepartmentVO();
				
				//java.sql.SQLException: 부적합한 열 이름 : 위에 from 테이블명이 달랐다.
				vo.setDepartment_id(rs.getInt("department_id"));
				vo.setDepartment_name(rs.getString("department_name"));
				vo.setManager_id(rs.getInt("manager_id"));
				vo.setLocation_id(rs.getInt("location_id"));
				vos.add(vo);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			if(rs!=null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		
		return vos;
	}


	@Override
	public List<DepartmentVO> selectAllDepartmentJoinLocation() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<DepartmentVO> selectAll(int cpage, int pageBlock) {
		// TODO Auto-generated method stub
		System.out.println("selectAll()...");
		System.out.println("cpage: " + cpage);
		System.out.println("pageBlock : " + pageBlock);
		
		int startRow = (cpage -1 ) * pageBlock +1;
		int endRow = startRow + pageBlock -1;
		System.out.println(startRow + "," + endRow);
		
		List<DepartmentVO> vos = new ArrayList<DepartmentVO>();
		
		
		try {
			// 1.커넥션(계정접속)
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			System.out.println("conn successed...");

			// 2.SQL(질의문) 세팅
			pstmt = conn.prepareStatement(DepartmentSQL.SELECT_ALL_PAGE_BLOCK);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			System.out.println(pstmt);

			// 3.결과반환 rs >> vos
			rs = pstmt.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				DepartmentVO vo2 = new DepartmentVO();
				vo2.setDepartment_id(rs.getInt("department_id"));
				vo2.setDepartment_name(rs.getString("department_name"));
				vo2.setManager_id(rs.getInt("manager_id"));
				vo2.setLocation_id(rs.getInt("location_id"));
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
			pstmt = conn.prepareStatement(DepartmentSQL.TOTAL_ROWS);
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
	public List<DepartmentVO> searchList(String searchKey, String searchWord, int cpage, int pageBlock) {
		System.out.println("searchList()....");
		System.out.println(searchKey);
		System.out.println(searchWord);
		
		System.out.println("cpage:" + cpage);
		System.out.println("pageBlock:" + pageBlock);

		int startRow = (cpage - 1) * pageBlock + 1;
		int endRow = startRow + pageBlock - 1;
		System.out.println(startRow + "," + endRow);
		
		String sql = "";
		if (searchKey.equals("department_name")) {
			sql = DepartmentSQL.SEARCHLIST_PAGE_BLOCK_DEPARTMENT_NAME;
		} else if (searchKey.equals("location_id")) {
			sql = DepartmentSQL.SEARCHLIST_PAGE_BLOCK_LOCATION_ID;
		}

		
		List<DepartmentVO> vos = new ArrayList<DepartmentVO>();

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
				DepartmentVO vo2 = new DepartmentVO();
				vo2.setDepartment_id(rs.getInt("department_id"));
				vo2.setDepartment_name(rs.getString("department_name"));
				vo2.setManager_id(rs.getInt("manager_id"));
				vo2.setLocation_id(rs.getInt("location_id"));
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
		if (searchKey.equals("department_name")) {
			sql = DepartmentSQL.SEARCH_TOTAL_ROWS_DEPARTMENT_NAME;
		} else if (searchKey.equals("location_id")) {
			sql = DepartmentSQL.SEARCH_TOTAL_ROWS_LOCATION_ID;
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
	public int insert(DepartmentVO vo) {
		System.out.println("insert()...");
		System.out.println(vo);
		
		int flag = 0; 
		
		try {
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			System.out.println("conn successed...");
			
			pstmt = conn.prepareStatement(DepartmentSQL.INSERT);
			pstmt.setInt(1, vo.getDepartment_id());
			pstmt.setString(2, vo.getDepartment_name());
			pstmt.setInt(3, vo.getManager_id());
			pstmt.setInt(4, vo.getLocation_id());
			
			
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
