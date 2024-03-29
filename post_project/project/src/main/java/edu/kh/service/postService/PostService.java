package edu.kh.service.postService;

import java.sql.Connection;
import java.util.List;

import edu.kh.common.JDBC_TEMPLATE;
import edu.kh.model.dto.post.Post;
import edu.kh.post.dao.DAO;

public class  PostService{

	private DAO todoDao = new DAO(); 
	
	public List<Post> search(int memberNo) {
		
		Connection conn = JDBC_TEMPLATE.getConnection();
		
		List<Post> list = todoDao.search(conn, memberNo);
		
		JDBC_TEMPLATE.close(conn);
		
		
		return list;
	}

	/** 게시글추가하기
	 * @param title
	 * @param content
	 * @param memberNo
	 * @return
	 */
	public int insert(String title, String content, int memberNo) {
		
		Connection conn = JDBC_TEMPLATE.getConnection();
		
		int result = todoDao.insert(conn, title, content, memberNo);
		
		if(result > 0) JDBC_TEMPLATE.commit(conn);
		else           JDBC_TEMPLATE.rollback(conn);
		               JDBC_TEMPLATE.close(conn);
		
		return result;
	}

	public Post update(int memberNo, String postNo) {
		
		Connection conn = JDBC_TEMPLATE.getConnection();
		
		Post post = todoDao.update(memberNo, postNo, conn);
		
		JDBC_TEMPLATE.close(conn);
		
		return post;
	}

	public int updatePost(String postNo, String postTitle, String postContent) {
		
		Connection conn = JDBC_TEMPLATE.getConnection();
		
		int result = todoDao.updatePost(postNo, postTitle, postContent, conn);
		
		if(result > 0) JDBC_TEMPLATE.commit(conn);
		else           JDBC_TEMPLATE.rollback(conn);
		JDBC_TEMPLATE.close(conn);
		
		return result;
	}

	public int delete(String todoNo) {
		
		Connection conn = JDBC_TEMPLATE.getConnection();
		
		int result = todoDao.delete(conn, todoNo);
		
		if(result > 0) JDBC_TEMPLATE.commit(conn);
		else           JDBC_TEMPLATE.rollback(conn);
		JDBC_TEMPLATE.close(conn);
		
		return result;
	}

}
