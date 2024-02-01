package test.com.country;

import java.util.List;

public class CountriesMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1. 연결 
		CountriesDAO dao = new CountriesDAOimple();
		
		//2. 
		List<CountriesVO> vos = dao.selectAll();
		for(CountriesVO x : vos) {
			System.out.println(x);
		}
		
		//3. selectAllCountryJoinRegion
		List<CountryjoinRegionVO> vos1 = dao.selectAllCountryJoinRegion();
		for(CountryjoinRegionVO x : vos1) {
			System.out.println(x);
		}
		
		

	}

}
