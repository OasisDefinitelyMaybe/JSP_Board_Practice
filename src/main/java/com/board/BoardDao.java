package com.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.board.dto.BoardDto;

public class BoardDao extends DBConnPool{
	/**
	 *  DB로부터 게시글 1건에 대한 상세 정보를 조회 후 반환
	 */
	public BoardDto getOne(String num) {
		BoardDto dto = new BoardDto();
		String sql = "select * from board where num=?";
		// ?를 이용한 인파라미터를 사용할 수 있다!
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setNum(rs.getString("num"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setId(rs.getString("id"));
				dto.setPostdate(rs.getString("postdate"));
				dto.setVisitcount(rs.getString("visitcount"));
			}
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		return dto;
			
	}
	/**
	 *  DB로 부터 리스트를 조회후 반환 
	 */
	public List<BoardDto> getList() {
    List<BoardDto> list = new ArrayList<>();
    // 쿼리 정의 
    String sql = "select * from board";
		 // 인파라미터를 설정할 수 있으므로 쿼리 실행 전 sql문장을 세팅합니다.
		 try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			// 다음 행이 있는지 확인 
		    while(rs.next()) {
		    	BoardDto dto = new BoardDto();
		    	dto.setNum(rs.getString("num"));
		    	dto.setTitle(rs.getString("title"));
		    	dto.setContent(rs.getString("content"));
		    	dto.setId(rs.getString("id"));
		    	dto.setPostdate(rs.getString("postdate"));
		    	dto.setVisitcount(rs.getString("visitcount"));
		    	
		    	list.add(dto);
		    }
		} catch (SQLException e) {
			System.out.println("리스트 조회 중 오류가 발생하였습니다.");
			e.printStackTrace();
		}
		 return list;
	 }
}
