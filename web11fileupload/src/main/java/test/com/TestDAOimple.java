package test.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.com.db.DBinfo;

public class TestDAOimple implements TestDAO {
	
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	public TestDAOimple() {
		System.out.println("TestDAOimple()...");
		try {
			Class.forName(DBinfo.DRIVER_NAME);
			System.out.println("drivet successed...");
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(TestVO vo) {
		System.out.println("insert()...");
		
		//test라는 테이블 생성 (시퀀스 없이, name, age, save_name 칼럼 생성)
		//insert 쿼리 전
		
		
		int flag=0;
		
		try {
			// 1.커넥션(계정접속)
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			System.out.println("conn successed...");

			// 2.SQL(질의문) 세팅
			pstmt = conn.prepareStatement(TestSQL.INSERT);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getAge());
			pstmt.setString(3, vo.getSave_name());
		

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
	public List<TestVO> selectAll() {
		System.out.println("insert()...");
		
		List<TestVO> vos = new ArrayList<TestVO>();

		try {
			// 1.커넥션(계정접속)
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			System.out.println("conn successed...");

			// 2.SQL(질의문) 세팅
			pstmt = conn.prepareStatement("select * from test");
			
		

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				TestVO vo = new TestVO();
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setSave_name(rs.getString("save_name"));
				vos.add(vo);
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
		
		return vos;
	}

}
