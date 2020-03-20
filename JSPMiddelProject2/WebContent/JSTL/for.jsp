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
	<h2>자바로 코딩</h2>
	<%
		for(int i=1; i<10; i++)
		{
	%>
		<%= i%> &nbsp;
		
	<%		
			
		}
	
	%>
	<br>
	<%--
			${} => 일반 변수는 출력하지 않기때문에 request, session에 담아서 보내야한다. 
	
			
			c:forEach
				var ==> 변수(request.setAttribute("i", 1)) => ${}로 반드시 출력해야함 , i(request.getAttribute("i"))
				begin ==> 시작값
				end  ==> 끝값
				step ==> 증가값
				
				===============> step="1"일때 생략가능!
								 step은 음수값이 존재하지 않는다.
								 
								 
	 --%>
	<h2>JSTL로 코딩(JSP=>태그형 프로그램을 제작(view))</h2>
	<c:forEach var="i" begin="1" end="10" step="1">
		${i }&nbsp;
	</c:forEach>
</body>
</html>




