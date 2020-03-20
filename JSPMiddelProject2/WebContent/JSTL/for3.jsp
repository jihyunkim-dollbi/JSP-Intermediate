<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>자바코딩</h2>
		<% 
			for(int i=1; i<=10; i++)
			{
				
				if(i%2==0)
				{
		%>
				 <%=i %>&nbsp;
		<%			
					
				}
				
				
			}
		
		
		%>
	
	<h2>JSTL코딩</h2>
		<c:forEach var="i" begin="1" end="10">
			<c:if test="${i%2==0 }">
				${i }&nbsp;
			</c:if>
		</c:forEach>
</body>
</html>