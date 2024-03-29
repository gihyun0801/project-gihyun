package edu.kh.member.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import edu.kh.common.JDBC_TEMPLATE;
import edu.kh.model.dto.member.Member;

import static edu.kh.common.JDBC_TEMPLATE.*;

public class DAO {
  
	private Statement stmt;
	private ResultSet rs;
	private PreparedStatement pstmt;
	private Properties prop;
	
	public DAO() {
		
		try {
			
			prop = new Properties();
			
			String filePath = DAO.class.getResource("/edu/kh/xmlFile/member.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public Member login(Connection conn, String id, String pw) {
		
		Member m = null;
		try {
			
			String sql = prop.getProperty("login");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int no = rs.getInt("MEMBER_NO");
				String mid = rs.getString("MEMBER_ID");
				String mna = rs.getString("MEMBER_NICKNAME");
				String enroll = rs.getString("ENROLL_DATE");
				
				
				m = new Member();
				
				m.setMemberNo(no);
				m.setMemberId(mid);
				m.setMemberName(mna);
				m.setEnrollDate(enroll);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		
		return m;
	}

	public int signUp(Connection conn, String inputId, String inputPw, String inputName) {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("signUp");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inputId);
			pstmt.setString(2, inputPw);
			pstmt.setString(3, inputName);
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBC_TEMPLATE.close(pstmt);
		}
		
		return result;
	}
	 
	
}
