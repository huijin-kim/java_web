package test.com.comments;

public interface CommentsSQL {
	String INSERT = "insert into comments(num,content,writer,bnum) values(seq_comments.nextval,?,?,?)";

	String UPDATE = "update comments set content=? where num=?";

	String DELETE = "delete from comments  where num=?";

	String SELECT_ONE = "select * from comments where num=?";

	String SELECT_ALL = "select * from comments where bnum=? order by num desc";

	String SEARCHLIST_CONTENT = "select * from comments where content like ? order by num desc";

	String SEARCHLIST_WRITER = "select * from comments where writer like ? order by num desc";

}
