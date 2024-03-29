package edu.kh.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.member.service.Service;
import edu.kh.model.dto.member.Member;
import edu.kh.model.dto.post.Post;
import edu.kh.service.postService.PostService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@WebServlet("/login")
public class loginController extends HttpServlet{
 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		Service servi = new Service();
		
		String id = req.getParameter("inputId");
		String pw = req.getParameter("inputPw");
		
		Member member = servi.login(id,pw);
		
		
		 
	      
	      if(member == null) {
	    	  
	    	  session.setAttribute("message", "아이디 또는 비밀번호 불일치");
	    	  
	    	  //이전 페이지
	    	  
	    	  String referer = req.getHeader("referer");
	    	  
	    	  resp.sendRedirect(referer);
	    	  
	    	  
	    	  
	      }else {
	    	  
	    	  //로그인 성공시
	    	  session.setAttribute("loginMember", member);
	    	  
	    	  
	    	  PostService postService = new PostService();
	    	  
	    	  List<Post> list = postService.search(member.getMemberNo());
	    	  
	    	  session.setAttribute("postList", list);
	    	  
	    	
	    	 
	    	  
	    	  resp.sendRedirect("/");
	    	  
	      }
		
	}
	
}
