package test.com.job;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.com.db.DBinfo;

public class JobDAOimpl implements JOBDAO{
	
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public JobDAOimpl() {
		System.out.println("JobDAOimpl()");
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public List<JOBVO> selectAll() {
		
		List<JOBVO> vos = new ArrayList<JOBVO>();
		
		try {
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			System.out.println("conn successed....");
			
			pstmt = conn.prepareStatement(JobSQL.SELECT_ALL);
			System.out.println(pstmt);

			rs = pstmt.executeQuery();
			System.out.println(rs);
			while(rs.next()) {
				JOBVO vo = new JOBVO();
				
				//java.sql.SQLException: 부적합한 열 이름 : 위에 from 테이블명이 달랐다.
				vo.setJob_id(rs.getString("job_id"));
				vo.setJob_title(rs.getString("job_title"));
				vo.setMin_salary(rs.getInt("min_salary"));
				vo.setMax_salary(rs.getInt("max_salary"));
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

}
