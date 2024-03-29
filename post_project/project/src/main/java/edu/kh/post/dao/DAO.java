package edu.kh.post.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.common.JDBC_TEMPLATE;
import edu.kh.model.dto.post.Post;

public class DAO {
 
	private Statement stmt;
	private ResultSet rs;
	private PreparedStatement pstmt;
	private  Properties prop;
	
 public DAO() {
	 
	 try {
		 
		prop = new Properties();
		 
		 String filePath = DAO.class.getResource("/edu/kh/xmlFile/post.xml").getPath();
		 
		 prop.loadFromXML(new FileInputStream(filePath));
		 
		 
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
 }


public List<Post> search(Connection conn, int memberNo) {
	
	List<Post> list = new ArrayList<Post>();
	
	try {
		
		String sql = prop.getProperty("search");
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, memberNo);
		
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			
			int no = rs.getInt("POST_NO");
			String title = rs.getString("POST_TITLE");
			String content = rs.getString("POST_CONTENT");
			String date = rs.getString("POST_DATE");
			Post t = new Post();
			
			t.setPostNo(no);
			t.setPostTitle(title);
			t.setPostContent(content);
			t.setPostDate(date);
			
			list.add(t);
			
		}
		
		
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		JDBC_TEMPLATE.close(rs);
		JDBC_TEMPLATE.close(pstmt);
	}
	
	
	return list;
}


public int insert(Connection conn, String title, String content, int memberNo) {
	
	int result = 0;
	
	try {
		
		String sql = prop.getProperty("insert");
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, title);
		pstmt.setString(2, content);
		pstmt.setInt(3, memberNo);
		
		result = pstmt.executeUpdate();
		
		
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		JDBC_TEMPLATE.close(pstmt);
	}
	
	return result;
}


public Post update(int memberNo, String postNo, Connection conn) {
	
	Post post = null;
	
	try {
		
		String sql = prop.getProperty("update");
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, memberNo);
		pstmt.setString(2, postNo);
		
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			
			int postNumber = rs.getInt(1);
			String postTitle = rs.getString(2);
			String postContent = rs.getString(3);
			String postDate = rs.getString(4);
			int postMemberNo = rs.getInt(5);
			
			post = new Post();
			
			post.setPostNo(postNumber);
			post.setPostTitle(postTitle);
			post.setPostContent(postContent);
			post.setPostDate(postDate);
			post.setMemberNo(postMemberNo);
			
			
		}
		
		
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		JDBC_TEMPLATE.close(rs);
		JDBC_TEMPLATE.close(pstmt);
	}
	
	
	return post;
}


public int updatePost(String postNo, String postTitle, String postContent, Connection conn) {
	
	int result = 0;
	
	try {
		
		String sql = prop.getProperty("updatePost");
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, postTitle);
		pstmt.setString(2, postContent);
		pstmt.setString(3, postNo);
		
		result = pstmt.executeUpdate();
		
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		JDBC_TEMPLATE.close(pstmt);
	}
	
	return result;
}


public int delete(Connection conn, String todoNo) {
	
	int result = 0;
	
	try {
		
		String sql = prop.getProperty("delete");
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, todoNo);
		
		result = pstmt.executeUpdate();
		
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		JDBC_TEMPLATE.close(pstmt);
	}
	
	return result;
}
	
}
