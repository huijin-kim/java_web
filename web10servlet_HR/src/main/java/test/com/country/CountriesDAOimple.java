package test.com.country;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.com.db.DBinfo;

public class CountriesDAOimple implements CountriesDAO {
	
	
	private List<CountriesVO> vos;
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// 1531로 잘못 적으니 
	// IO 오류: The Network Adapter could not establish the connection
	// Caused by: oracle.net.ns.NetException: The Network Adapter could not establish the connection
	// Caused by: java.net.ConnectException: Connection refused

	
	public CountriesDAOimple() {
		System.out.println("CountriesDAOimple()");
		
		try {
			Class.forName(DBinfo.DRIVER_NAME);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	



	@Override
	public List<CountriesVO> selectAll() {
		
		List<CountriesVO> vos = new ArrayList<CountriesVO>();
		
		
		try {
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			System.out.println("conn successed....");
			
			pstmt = conn.prepareStatement(CountriesSQL.SELECT_ALL);
			System.out.println(pstmt);

			rs = pstmt.executeQuery();
			System.out.println(rs);
			while(rs.next()) {
				CountriesVO vo = new CountriesVO();
				
				vo.setCountry_id(rs.getString("country_id"));
				vo.setCountry_name(rs.getString("country_name"));
				vo.setRegion_id(rs.getInt("region_id"));
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
	public List<CountryjoinRegionVO> selectAllCountryJoinRegion() {
		System.out.println("CountryjoinRegionVO");
		
		List<CountryjoinRegionVO> vos2 = new ArrayList<CountryjoinRegionVO>();
		
		
		try {
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			System.out.println("conn successed....");
			
			pstmt = conn.prepareStatement(CountriesSQL.SELECT_ALLJOIN);
			System.out.println(pstmt);

			rs = pstmt.executeQuery();
			System.out.println(rs);
			while(rs.next()) {
				CountryjoinRegionVO vo = new CountryjoinRegionVO();
				
				vo.setCountry_id(rs.getString("country_id"));
				vo.setCountry_name(rs.getString("country_name"));
				vo.setRegion_id(rs.getInt("region_id"));
				vo.setRegion_name(rs.getString("region_name"));
				vos2.add(vo);
				
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
		
		return vos2;
	}


}
