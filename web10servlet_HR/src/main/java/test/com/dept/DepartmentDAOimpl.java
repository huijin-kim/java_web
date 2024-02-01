package test.com.dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

}
