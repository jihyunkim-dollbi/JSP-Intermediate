<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.model.*"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!--날짜 변환 하려고! 숫자=> $,원 표기할때, 100,000 표기할때 등등-->


<%

	BoardModel model = new BoardModel();
	model.boardDetailData(request); //request에 값이 실려있을 것임.
	
	//아래서 request값 출력 고고!

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
		<h2 class="text-center">내용보기</h2>
		<div class="row">
			<table class="table">
				<tr>
					<th class="text-center danger" width=20%>게시물번호</th>
					<td class="text-center" width=30%>${vo.no }</td>
					<th class="text-center danger" width=20%>작성일</th>
					<td class="text-center" width=30%>
					<fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd"/><!-- 변화해서 출력해줘 -->
					
					</td>
				</tr>
				<tr>
					<th class="text-center danger" width=20%>아름</th>
					<td class="text-center" width=30%>${vo.name }</td>
					<th class="text-center danger" width=20%>조회수</th>
					<td class="text-center" width=30%>${vo.hit }</td>
				</tr>
				<tr>
					<th class="text-center danger" width=20%>제목</th>
					<td class="text-letf" colspan="3">${vo.subject }</td>
				</tr>
				<tr>
					<td class="text-center" colspan="4" valign="top" height="200">${vo.content }</td>
				</tr>
				<tr>
					<td class="text-right" colspan="4">
						<a href="update.jsp?no=${vo.no }" class="btn btn-xs btn-success">수정</a>
						<a href="#" class="btn btn-xs btn-info">삭제</a>
						<a href="list.jsp" class="btn btn-xs btn-warning">목록</a>
					</td>
				</tr>
			</table>
			
		
		</div>
	</div>
</body>
</html>