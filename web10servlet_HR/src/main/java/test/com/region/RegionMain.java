package test.com.region;

import java.util.List;

public class RegionMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RegionDAO dao = new RegionDAOimpl();
		System.out.println("================");

		// selectAll
		List<RegionVO> vos = dao.selectAll();
		for (RegionVO x : vos) {
			System.out.println(x);
		}
		System.out.println("================");

	}

}
