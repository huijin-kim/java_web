package test.com.country;

import java.io.Serializable;
import java.util.Objects;

//Serializable - 직렬화.
public class CountryjoinRegionVO implements Serializable{
	
	private String country_id;
	private String country_name;
	private int region_id;
	private String region_name;
	
	public CountryjoinRegionVO() {
		// TODO Auto-generated constructor stub
	}

	public CountryjoinRegionVO(String country_id, String country_name, int region_id, String region_name) {
		super();
		this.country_id = country_id;
		this.country_name = country_name;
		this.region_id = region_id;
		this.region_name = region_name;
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

	public String getRegion_name() {
		return region_name;
	}

	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}

	@Override
	public String toString() {
		return "CountryjoinRegionVO [country_id=" + country_id + ", country_name=" + country_name + ", region_id="
				+ region_id + ", region_name=" + region_name + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(country_id, country_name, region_id, region_name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CountryjoinRegionVO other = (CountryjoinRegionVO) obj;
		return Objects.equals(country_id, other.country_id) && Objects.equals(country_name, other.country_name)
				&& region_id == other.region_id && Objects.equals(region_name, other.region_name);
	}
	
	


}
