package edu.kh.post.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.model.dto.member.Member;
import edu.kh.model.dto.post.Post;
import edu.kh.service.postService.PostService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/deleteList")
public class Delete extends HttpServlet{
 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String postNo = req.getParameter("postNo");
		
		PostService service = new PostService();
		
		int result = service.delete(postNo);
		
		HttpSession session = req.getSession();
		
		
		
		
		
		Member member = (Member)session.getAttribute("loginMember");
		
		
		if(result > 0) {
			List<Post> list = service.search(member.getMemberNo());
			
			session.setAttribute("postList", list);
			
			session.setAttribute("message", "삭제성공");
			
			resp.sendRedirect("/");
		}else {
			session.setAttribute("message", "삭제실패");
			
			String referer = req.getHeader("referer");
			resp.sendRedirect(referer);
		}
	} 
	 
	 
	
}
