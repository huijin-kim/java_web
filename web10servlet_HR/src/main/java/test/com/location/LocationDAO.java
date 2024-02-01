package test.com.location;

import java.util.List;

public interface LocationDAO {

	public List<LocationVO> selectALL();
	
	public List<LocationjoinCountryVO> selectLocationjoinCountryVO();
}
