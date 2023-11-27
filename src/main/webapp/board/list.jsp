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
<h2>목록 조회</h2>
<p>jsp를 단독으로 실행할 경우, 
     request영역에 list를 저장하지 않으므로 null이 출력 됩니다.</p>
<p>Controller를 거쳐서 실행해보세요.
   <br>Controller에서 리스트를 조회 후 request 영역에 저장합니다.</p>

<% 
  List<BoardDto> list = (List<BoardDto>)request.getAttribute("list");
%>

<h2>게시판 목록</h2>
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
       <!-- 제목을 클릭하면 상세보기 화면으로 이동합니다.
            이동 시에 게시글번호를 가지고 갑니다.
        -->
           <td><a href="boardView?num=<%=dto.getNum()%>"><%=dto.getTitle()%></a></td>
           <td><%= dto.getId()%></td>
           <td><%= dto.getPostdate()%></td>
       </tr>
  <% } 
	  }  else {
	     out.print("<tr><td colspan='3'>조회결과가 없습니다. </td></tr>");
   }
 
   %>
</table>
</body>
</html>