package test.com.location;

public class LocationjoinCountryVO {
	
	private int location_id;
	private String street_address;
	private String postal_code;
	private String city;
	private String state_province;
	private String country_id;
	private String country_name;
	private int region_id;
	
	
	public LocationjoinCountryVO() {
		// TODO Auto-generated constructor stub
	}
	
	public LocationjoinCountryVO(int location_id, String street_address, String postal_code, String city,
			String state_province, String country_id, String country_name, int region_id) {
		super();
		this.location_id = location_id;
		this.street_address = street_address;
		this.postal_code = postal_code;
		this.city = city;
		this.state_province = state_province;
		this.country_id = country_id;
		this.country_name = country_name;
		this.region_id = region_id;
	}

	public int getLocation_id() {
		return location_id;
	}

	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}

	public String getStreet_address() {
		return street_address;
	}

	public void setStreet_address(String street_address) {
		this.street_address = street_address;
	}

	public String getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState_province() {
		return state_province;
	}

	public void setState_province(String state_province) {
		this.state_province = state_province;
	}

	public String getCountry_id() {
		return country_id;
	}

	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public int getRegion_id() {
		return region_id;
	}

	public void setRegion_id(int region_id) {
		this.region_id = region_id;
	}

	@Override
	public String toString() {
		return "LocationjoinCountryVO [location_id=" + location_id + ", street_address=" + street_address
				+ ", postal_code=" + postal_code + ", city=" + city + ", state_province=" + state_province
				+ ", country_id=" + country_id + ", country_name=" + country_name + ", region_id=" + region_id + "]";
	}
	
	
	
	
	

}
