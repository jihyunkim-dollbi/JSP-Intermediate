<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%
    
    	//배열, 리스트 
    	String[] subjects={"java","oracle","jsp","spring","kotlin"};
    	
    	request.setAttribute("subjects1", subjects);
    	request.setAttribute("subjects2", subjects);
    	request.setAttribute("subjects3", subjects);
    	request.setAttribute("subjects4", subjects);
    	request.setAttribute("subjects5", subjects);
    	request.setAttribute("subjects6", subjects);
    	// 한번에 묶어서 여러개 보낼 수 있다. (보내기!)
    	
    	// = 
    	// 개수에 한계가 없다. 
    	// ${} 받기 => request.getAttribute()
    	
    	
    	// 배열 vs 리스트! => 리스트는 가변형!
    	
    	
    	
    	
    %>
<c:set var="subjects" value="<%= subjects %>"/> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>자바 코딩 </h2>
	 <ul>
	 	<%
	 			int i=1;
	 		for(String sub:subjects){
	 			
	 		 	%>
	 		 			<li><%=i%>.<%= sub %></li>
	 		 	<%		
	 		 			i++;
	 		 		}
	 		 	
	 		 	
	 	%>
	 </ul>
	 
	<h2>JSTL 코딩</h2>
		<ul>
			<c:forEach var="sub" items="${subjects1}" varStatus="s"> <%--반드시 request에서 보낸 키를 넣어야한다.  varStatus=>첨자! 0번부터 시작!--%>
				<li>${s.index+1}.${sub}</li>			
			</c:forEach>
		</ul>	
</body>
</html>