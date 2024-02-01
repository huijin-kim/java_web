package test.com.location;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.com.db.DBinfo;

public class LocationDAOimpl implements LocationDAO {
	
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	
	public LocationDAOimpl() {
		System.out.println("CountriesDAOimple()");
		
		try {
			Class.forName(DBinfo.DRIVER_NAME);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	@Override
	public List<LocationVO> selectALL() {
		List<LocationVO> vos = new ArrayList<LocationVO>();
		
		
		try {
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			System.out.println("conn successed....");
			
			pstmt = conn.prepareStatement(LocationSQL.SELECT_ALL);
			System.out.println(pstmt);

			rs = pstmt.executeQuery();
			System.out.println(rs);
			while(rs.next()) {
				LocationVO vo = new LocationVO();
				
				//java.sql.SQLException: 부적합한 열 이름 : 위에 from 테이블명이 달랐다.
				vo.setLocation_id(rs.getInt("location_id"));
				vo.setStreet_address(rs.getString("street_address"));
				vo.setPostal_code(rs.getString("postal_code"));
				vo.setCity(rs.getString("city"));
				vo.setState_province(rs.getString("state_province"));
				vo.setCountry_id(rs.getString("country_id"));
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



	//ORA-00960: ambiguous column naming in select list 
	// 다른 테이블에 동일한 컬럼 명. 컬럼에서  철자 하나 빠짐.
	@Override
	public List<LocationjoinCountryVO> selectLocationjoinCountryVO() {
		
	System.out.println("LocationjoinCountryVO");
		
		List<LocationjoinCountryVO> vos2 = new ArrayList<LocationjoinCountryVO>();
	
		
		// ORA-00923: FROM keyword not found where expected
		// 밑에서 질의어 사이에 공백이 없어서 남.
		
		
		try {
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			System.out.println("conn successed....");
			
			pstmt = conn.prepareStatement(LocationSQL.SELECT_ALLJOINCOUNTRY);
			System.out.println(pstmt);

			rs = pstmt.executeQuery();
			System.out.println(rs);
			while(rs.next()) {
				LocationjoinCountryVO vo = new LocationjoinCountryVO();
				
				vo.setLocation_id(rs.getInt("location_id"));
				vo.setStreet_address(rs.getString("street_address"));
				vo.setPostal_code(rs.getString("postal_code"));
				vo.setCity(rs.getString("city"));
				vo.setState_province(rs.getString("state_province"));
				vo.setCountry_id(rs.getString("country_id"));
				vo.setCountry_name(rs.getString("country_name"));
				
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
