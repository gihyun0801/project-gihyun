package edu.kh.controller;

import java.io.IOException;

import edu.kh.member.service.Service;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/signup")
public class SignUpController extends HttpServlet{
 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dis = req.getRequestDispatcher("/WEB-INF/views/signup.jsp");
		dis.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String inputId = req.getParameter("inputId");
		String inputPw = req.getParameter("inputPw");
		String inputName = req.getParameter("inputName");
		
		Service service = new Service();
		
		HttpSession session = req.getSession();
		
		int result = service.signUp(inputId, inputPw, inputName);
		
		if(result > 0) {
			session.setAttribute("message", "회원가입성공");
			
			resp.sendRedirect("/");
			
		}else {
			session.setAttribute("message", "회원가입실패");
			
			String referer = req.getHeader("referer");
			
			resp.sendRedirect(referer);
		}
		
	}
	
}
