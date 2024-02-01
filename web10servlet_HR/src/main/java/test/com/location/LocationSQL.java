package test.com.location;

public interface LocationSQL {
	
	String SELECT_ALL = "select * from LOCATIONS";
	
	
	String SELECT_ALLJOINCOUNTRY = "select location_id,street_address,postal_code, \n"
			+ "city,state_province,country_id,country_name "
			+ "from locations join countries \n"
			+ "using(country_id) \n"
			+ "order by location_id";

}
