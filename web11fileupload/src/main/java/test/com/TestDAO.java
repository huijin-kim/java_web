package test.com;

import java.util.List;

public interface TestDAO {

	public int insert(TestVO vo);

	public List<TestVO> selectAll();
}
