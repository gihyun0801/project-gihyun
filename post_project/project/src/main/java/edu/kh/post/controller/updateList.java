package edu.kh.post.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.model.dto.member.Member;
import edu.kh.model.dto.post.Post;
import edu.kh.service.postService.PostService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/updateList")
public class updateList extends HttpServlet{
	
	 PostService service = new PostService();
  @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  
	  //postNo=${st.postNo }
	  HttpSession session = req.getSession();
	 
	  
	  Member member = (Member)session.getAttribute("loginMember");
	 
	  
	  int memberNo = member.getMemberNo(); //맴버번호
	   
	  String postNo = req.getParameter("postNo"); //게시판 번호
	  
	  
	  Post post = service.update(memberNo, postNo); // 현재 게시판 정보
	  
	  req.setAttribute("postList", post);
	  
	  String postTitle = post.getPostTitle();
	  String postContent = post.getPostContent();
	  
	  req.setAttribute("postTitle", postTitle);
	  req.setAttribute("postContent", postContent);
	  
	  
	  RequestDispatcher dis = req.getRequestDispatcher("/WEB-INF/views/update.jsp");
	  dis.forward(req, resp);
	  
	  
	  
}
  
  @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  
	   HttpSession session = req.getSession();
	   
	   Member member = (Member)session.getAttribute("loginMember");
	  
	  
	  
	  
	  
	  String postNo = req.getParameter("hiddenPost"); //게시판번호
	  String postTitle = req.getParameter("postTitle"); // 제목
	  String postContent = req.getParameter("postContent"); //내용
	  
	  int result = service.updatePost(postNo, postTitle, postContent);
	  
	  if(result > 0) {
		  
		  session.setAttribute("message", "수정되었습니다");
		  
		  
		  List<Post> postList = service.search(member.getMemberNo());
		  
		  session.setAttribute("postList", postList);
		  
		  
		  resp.sendRedirect("/");
		  
		  
	  }else {
		  session.setAttribute("message", "수정실패");
		  
		  String referer = req.getHeader("referer");
		  
		  resp.sendRedirect(referer);
	  }
	  
	  
	}
}
