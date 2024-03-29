package edu.kh.member.service;

import java.sql.Connection;

import static edu.kh.common.JDBC_TEMPLATE.*;

import edu.kh.common.JDBC_TEMPLATE;
import edu.kh.member.dao.DAO;
import edu.kh.model.dto.member.Member;

public class Service {
  
	DAO dao = new DAO();

	public Member login(String id, String pw) {
		
		Connection conn = getConnection();
		
		Member m = dao.login(conn, id, pw);
		
		close(conn);
		
		
		return m;
	}

	/** 회원가입 변수들 
	 * @param inputId
	 * @param inputPw
	 * @param inputName
	 * @return
	 */
	public int signUp(String inputId, String inputPw, String inputName) {
		
		Connection conn = getConnection();
		
		int result = dao.signUp(conn, inputId, inputPw, inputName);
		
		if(result > 0) JDBC_TEMPLATE.commit(conn);
		else  JDBC_TEMPLATE.rollback(conn);
		
		return result;
	}
	
	
	
}
