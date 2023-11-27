package com.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ojdbc를 이용하여 DB접근하고 커넥션을 얻어 옵니다.
 */
public class DBConnection {

	public static void main(String[] args) {
		// 데이터베이스 접속정보
		// jdbc:oracle:thin:@아이피:포트:SID
		 String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	     String id = "TESTUSER";
	     String pw = "1234";
		
		try {
			// 1. 드라이버 로딩 - ojdbc6 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. Connection 생성
			//  데이터베이스에 접근 후 인증과정을 거쳐 커넥션을 얻어옵니다.
			Connection con = DriverManager.getConnection(url, id, pw);
			
			// 쿼리를 질의하기 위해 필요한 객체를 생성
			Statement stmt = con.createStatement();
			
			// 쿼리실행
			// select - ResultSet
			// insert, delete, update - int
			ResultSet rs = stmt.executeQuery("select sysdate from dual");
			rs.next();
			System.out.println("현재 시간 : " + rs.getString(1));
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 로딩할 수 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Connection 생성 실패 - url, id, pw 정보를 확인해주세요");
			e.printStackTrace();
		}
	}
}
