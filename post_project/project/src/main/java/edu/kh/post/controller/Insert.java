package edu.kh.post.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.model.dto.member.Member;
import edu.kh.model.dto.post.Post;
import edu.kh.service.postService.PostService;
import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/insert")
public class Insert extends HttpServlet{
 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dis = req.getRequestDispatcher("/WEB-INF/views/insert.jsp");
		dis.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		
       PostService service = new PostService();
		
		String title = req.getParameter("inputTitle");
		String content = req.getParameter("inputContent");
		
		
		
		Member member = (Member)session.getAttribute("loginMember");
		
	
		
		int result = service.insert(title,content, member.getMemberNo());
		
		
		if(result > 0 ) {
			session.setAttribute("message", "추가완료");
			
			List<Post> list = service.search(member.getMemberNo());
			
			session.setAttribute("postList", list);
			
			resp.sendRedirect("/");
		}else {
			session.setAttribute("message", "추가실패");
			
			resp.sendRedirect("/");		
		
	}
	}
	
}
