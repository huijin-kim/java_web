package test.com.comments;

import java.util.List;

public interface CommentsDAO {

	public int insert(CommentsVO vo);

	public int update(CommentsVO vo);

	public int delete(CommentsVO vo);

	public CommentsVO selectOne(CommentsVO vo);

	public List<CommentsVO> selectAll(CommentsVO vo);

	public List<CommentsVO> searchList(String searchKey, String searchWord);

}
