package test.com.region;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.com.db.DBinfo;



public class RegionDAOimpl implements RegionDAO {
	
	
	private List<RegionVO> vos;
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public RegionDAOimpl() {
		System.out.println("RegionDAOimple().... ");
		
		try {
			Class.forName(DBinfo.DRIVER_NAME);
			System.out.println("driver successed...");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<RegionVO> selectAll() {
		List<RegionVO> vos = new ArrayList<RegionVO>();
		
		
		//final  함부로 수정할 수 없다. 
	
		
		//싱글톤 객체로 되어있다. 
		try {
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			System.out.println("conn successed...");
			//1.커넥션(접속)
			
			//2. SQL(질의문) 세팅
			//select * from member;
			pstmt = conn.prepareStatement(RegionSQL.SELECT_ALL);
			System.err.println(pstmt);
			
			//3. 결과 반환
			rs = pstmt.executeQuery();
			System.out.println(rs);
			while(rs.next()) {
				RegionVO vo = new RegionVO();
				
				vo.setRegion_id(rs.getInt("region_id"));
				vo.setRegion_name(rs.getString("region_name"));
				vos.add(vo);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}//end finally
		return vos;
		
	}

}
