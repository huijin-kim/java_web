package test.com.comments;

import java.util.List;

public class Mission03Main {

	public static void main(String[] args) {
		
		CommentsDAO dao = new CommentsDAOimpl();
		System.out.println("============");
		//2.insert
//		CommentsVO vo = new CommentsVO();
//		vo.setContent("comments 4");
//		vo.setWriter("tester8");
//		vo.setBnum(78);
//		
//		int result = dao.insert(vo);
//		System.out.println("result:"+result);
//		
//		System.out.println("============");
		
//		//3.update
//		CommentsVO vo = new CommentsVO();
//		vo.setNum(5);
//		vo.setContent("Hello 1");
//		
//		int result = dao.update(vo);
//		System.out.println("result:"+result);
//		
//		System.out.println("============");
		
//		//4.delete
//		CommentsVO vo = new CommentsVO();
//		vo.setNum(2);
//		
//		int result = dao.delete(vo);
//		System.out.println("result:"+result);
//		
//		System.out.println("============");
		
//		//5.selectOne
//		CommentsVO vo = new CommentsVO();
//		vo.setNum(5);
//		
//		CommentsVO vo2 = dao.selectOne(vo);
//		System.out.println("vo2:"+vo2);
//		
//		System.out.println("============");
		
		//1.selectAll
		CommentsVO vo = new CommentsVO();
		vo.setBnum(84);
		List<CommentsVO> vos = dao.selectAll(vo);
		for (CommentsVO x : vos) {
			System.out.println(x);
		}
		System.out.println("============");
		
		//6.searchList
//		List<CommentsVO> vos = dao.searchList("content", "He");
////		List<CommentsVO> vos = dao.searchList("writer", "ad");
//		for (CommentsVO x : vos) {
//			System.out.println(x);
//		}
//		System.out.println("============");
		
	}//end main

}//end class
