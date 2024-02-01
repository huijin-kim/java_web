package test.com.location;

import java.util.List;

public class LocationMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//1. connect
		LocationDAO dao = new LocationDAOimpl();
		
		
		//2.
		List<LocationVO> vos = dao.selectALL();
		for(LocationVO x : vos) {
			System.out.println(x);
		}
		
		System.out.println("--------------");
		//3. selectAllcluntryJoinRegion
		List<LocationjoinCountryVO> vos2 = dao.selectLocationjoinCountryVO();
		for(LocationjoinCountryVO x : vos2) {
			System.out.println(x);
		}

	}

}
