package com.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDao2;

/**
 * Servlet implementation class BoardLIstController2
 */
@WebServlet("/boardList2")
public class BoardLIstController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
		BoardDao2 dao = new BoardDao2();
		
		request.setAttribute("list", dao.getList());
		
		dao.close();
		
		request.getRequestDispatcher("/board/boardList.jsp")
		                  .forward(request, response);

   }
}
