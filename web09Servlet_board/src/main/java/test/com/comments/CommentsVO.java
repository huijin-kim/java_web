package test.com.comments;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class CommentsVO implements Serializable {

	private int num;
	private String content;
	private String writer;
	private Timestamp wdate;
	private int bnum;

	public CommentsVO() {
		// TODO Auto-generated constructor stub
	}

	public CommentsVO(int num, String content, String writer, Timestamp wdate, int bnum) {
		super();
		this.num = num;
		this.content = content;
		this.writer = writer;
		this.wdate = wdate;
		this.bnum = bnum;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Timestamp getWdate() {
		return wdate;
	}

	public void setWdate(Timestamp wdate) {
		this.wdate = wdate;
	}

	public int getBnum() {
		return bnum;
	}

	public void setBnum(int bnum) {
		this.bnum = bnum;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bnum, content, num, wdate, writer);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommentsVO other = (CommentsVO) obj;
		return bnum == other.bnum && Objects.equals(content, other.content) && num == other.num
				&& Objects.equals(wdate, other.wdate) && Objects.equals(writer, other.writer);
	}

	@Override
	public String toString() {
		return "CommentsVO [num=" + num + ", content=" + content + ", writer=" + writer + ", wdate=" + wdate + ", bnum="
				+ bnum + "]";
	}

}
