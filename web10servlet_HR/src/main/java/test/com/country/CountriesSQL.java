package test.com.country;

public interface CountriesSQL {
	
	String SELECT_ALL = "select * from COUNTRIES";
	
	String SELECT_ALLJOIN = "select country_id, country_name, region_id, region_name\n"
			+ "from countries join regions \n"
			+ "using(region_id)\n"
			+ "order by country_id";

}
