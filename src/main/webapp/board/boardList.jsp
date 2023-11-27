<%@page import="com.board.dto.BoardDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
  List<BoardDto> list = (List<BoardDto>)request.getAttribute("list");
%>
</form>
<h2>목록 조회</h2>
<table border="1">
  <tr>  
    <th width="50%">제목</th>    
    <th>작성자</th>
    <th>등록일</th>    
  </tr>
 <% 
   // 조회결과가 존재한다면
  if(list != null && list.size()>0) {
	  // 반복문을 돌면서 리스트 출력
	  for(BoardDto dto :list) {
 %>
       <tr>
           <td><%= dto.getTitle()%></td>
           <td><%= dto.getId()%></td>
           <td><%= dto.getPostdate()%></td>
           <td><%= dto.getName()%></td>
       </tr>
  <% } 
	  }  else {
	     out.print("<tr><td colspan='3'>조회결과가 없습니다. </td></tr>");
   }
  %>
</table>
</body>
</html>