package com.board.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.board.DBConnPool;
import com.board.dto.BoardDto;

/**
 * DB에 접근해서 데이터에 대한 입력, 수정, 삭제, 조회
 */
public class BoardDao2 extends DBConnPool{
	
	public int deleteBoard(String num) {
		 int res = 0;
		 String sql ="delete from board where num=?";	 
		    try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, num);
				
				res = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    return res;
	 }
	
	  /**
	   * 게시글의 조회수를 1증가 시켜줍니다.
	   * insert, update, delete의 반환 타입은 int(몇견이 처리 되었는지 반환)
	   * 반환타입은 int로 설정 
	   */
	 public int visitcountUp(String num) {
		 
		 int res = 0;
		 String sql = "update board\r\n"
		 		+ "set visitcount = visitcount + 1\r\n"
		 		+ "where num = ? ";	 
		 try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num);
			
			res = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return res;
	 }
 /**
  * DB로부터 리스트를 조회 반환
  * void = 반환타입 없음
  */
     public List<BoardDto> getList() {
    	 List<BoardDto> list = new ArrayList<>();
    	 
    	 String sql = "select b.*, m.name\r\n"
    	 		      + "from board b, member m\r\n"
    	 		      + "where b.id = m.id";
    	 
     try {
			pstmt = con.prepareStatement(sql);			
			rs = pstmt.executeQuery();
			
		while(rs.next()) {
			BoardDto dto = new BoardDto();
			dto.setTitle(rs.getString("title"));
			dto.setId(rs.getString("id"));
			dto.setPostdate(rs.getString("postdate"));
			// join을 이용해서 다른 테이블의 데이터를 함께 조회해올 경우,
			// dto에 담기 위해 컬럼을 추가할 수 있다.
			dto.setName(rs.getString("name"));		
			list.add(dto);
		}
		} catch (SQLException e) {
			System.out.println("리스트 조회 중 오류가 발생하였습니다.");
			e.printStackTrace();
		}   
    	 return list;	 
     }
}
