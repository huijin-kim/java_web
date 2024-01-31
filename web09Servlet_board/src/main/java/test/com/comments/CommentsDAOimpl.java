package test.com.comments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.com.db.DBinfo;

public class CommentsDAOimpl implements CommentsDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	

	public CommentsDAOimpl() {
		System.out.println("CommentsDAOimpl()....");

		try {
			Class.forName(DBinfo.DRIVER_NAME);
			System.out.println("driver successed...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(CommentsVO vo) {
		System.out.println("comments insert()....");
		System.out.println(vo);
		int flag = 0;

		
		try {
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			System.out.println("conn successed...");

			pstmt = conn.prepareStatement(CommentsSQL.INSERT);
			pstmt.setString(1, vo.getContent());
			pstmt.setString(2, vo.getWriter());
			pstmt.setInt(3, vo.getBnum());

			flag = pstmt.executeUpdate();

			System.out.println("flag:" + flag);

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
	public int update(CommentsVO vo) {
		System.out.println("comments update()....");
		System.out.println(vo);
		int flag = 0;

		
		try {
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			System.out.println("conn successed...");

			pstmt = conn.prepareStatement(CommentsSQL.UPDATE);
			pstmt.setString(1, vo.getContent());
			pstmt.setInt(2, vo.getNum());

			flag = pstmt.executeUpdate();

			System.out.println("flag:" + flag);

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
	public int delete(CommentsVO vo) {
		System.out.println("comments delete()....");
		System.out.println(vo);
		int flag = 0;

		
		try {
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			System.out.println("conn successed...");

			pstmt = conn.prepareStatement(CommentsSQL.DELETE);
			pstmt.setInt(1, vo.getNum());

			flag = pstmt.executeUpdate();

			System.out.println("flag:" + flag);

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
	public CommentsVO selectOne(CommentsVO vo) {
		System.out.println("comments selectOne()....");
		System.out.println(vo);
		

		CommentsVO vo2 = new CommentsVO();
		try {
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			System.out.println("conn successed...");

			pstmt = conn.prepareStatement(CommentsSQL.SELECT_ONE);
			pstmt.setInt(1, vo.getNum());
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo2.setNum(rs.getInt("num"));
				vo2.setContent(rs.getString("content"));
				vo2.setWriter(rs.getString("writer"));
				vo2.setWdate(rs.getTimestamp("wdate"));
				vo2.setBnum(rs.getInt("bnum"));
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
	public List<CommentsVO> selectAll(CommentsVO vo) {
		System.out.println("comments selectAll()....");
		System.out.println(vo);

		List<CommentsVO> vos = new ArrayList<CommentsVO>();


		try {
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			System.out.println("conn successed...");

			pstmt = conn.prepareStatement(CommentsSQL.SELECT_ALL);
			pstmt.setInt(1, vo.getBnum());
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				CommentsVO vo2 = new CommentsVO();
				vo2.setNum(rs.getInt("num"));
				vo2.setContent(rs.getString("content"));
				vo2.setWriter(rs.getString("writer"));
//				vo2.setWdate(new Timestamp(rs.getDate("wdate").getTime()));
				vo2.setWdate(rs.getTimestamp("wdate"));
				vo2.setBnum(rs.getInt("bnum"));
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
	public List<CommentsVO> searchList(String searchKey, String searchWord) {
		System.out.println("comments searchList()....");
		System.out.println(searchKey);
		System.out.println(searchWord);
		
		String sql = "";
		if(searchKey.equals("content")) {
			sql = CommentsSQL.SEARCHLIST_CONTENT;
		}else if(searchKey.equals("writer")){
			sql = CommentsSQL.SEARCHLIST_WRITER;
		}

		List<CommentsVO> vos = new ArrayList<CommentsVO>();


		try {
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			System.out.println("conn successed...");

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+searchWord+"%");

			rs = pstmt.executeQuery();

			while (rs.next()) {
				CommentsVO vo = new CommentsVO();
				vo.setNum(rs.getInt("num"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setWdate(rs.getTimestamp("wdate"));
				vo.setBnum(rs.getInt("bnum"));
				vos.add(vo);
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

}
