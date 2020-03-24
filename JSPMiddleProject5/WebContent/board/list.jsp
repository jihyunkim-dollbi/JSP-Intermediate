<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.model.*"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><!-- 날짜 숫자 변환할때 사용@ -->
  <%--
  	
  	fmt => format(number, date)
  
   --%>
  
  
<%
	// request값 받기!
	BoardModel model=new BoardModel(); // 1.
	model.boardListData(request); // 2. 나중에 컨트롤러가 할 작업(1~2)
	
	
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h2 class="text-center">게시판</h2>
		<div class="row">
			<table class="table">
				<tr>
					<td>
						<a href="insert.jsp" class="btn btn-sm btn-primary">새글</a>
					</td>
				</tr>
			
			</table>
			<table class="table table-hover">
				<tr class="danger">
					<td width=10% class="text-center">번호</td>
					<td width=45% class="text-center">제목</td>
					<td width=15% class="text-center">이름</td>
					<td width=20% class="text-center">작성일</td>
					<td width=10% class="text-center">조회수</td>
					
				</tr>
				<c:forEach var="vo" items="${list }">
					<tr>
					<td width=10% class="text-center">${vo.no }</td>
					<td width=45% class="text-left">
					<a href="detail.jsp?no=${vo.no }">${vo.subject }</a> <!-- 제목에서 링크를 건다! 제목을 누르면 상세보기 고고! -->
					</td>
					<td width=15% class="text-center">${vo.name }</td>
					<td width=20% class="text-center">
					<fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd"/>
					<%--
						core안에는 없다 fmt에 있음!
						그때그때 필요한 taglib가져오기!
						
						SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd")
					
					 --%>
					
					</td>
					<td width=10% class="text-center">${vo.hit }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>








