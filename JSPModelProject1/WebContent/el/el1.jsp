<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%--
    
    	EL : expression Language  화면에 출력하는 언어! /HTML안에서 자바와 분리위한 출력언어/  
    	p250
    	=> 사용법
    		${출력물} => {} 안에 일반 자바 변수(x)
    		
    		<%= 일반 자바 변수 %>
    		${} => 세가지 형태가 안에 들어갈 수 있다.
    				1)다른 파일jsp에서 넘어오는 값을 출력할때 : getParameter("id") => ${param.id}
    				2)request안에 들어간 값을 출력할때 : request.getAttribute("id") => ${requestScope.id} .뒤에 값이 key => ${id} requestScope생략가능! key명칭만 입력 가능!
    				  
    				    list.add("심청이");
						list.add("홍길동");
						list.add("박문수");
		
						request.setAttribute("list", list); 로 값을 넣고 출력은 ${requestScope.id}
    					
    				
    				
    					예 ) String id="admin"; => ${id}(출력 x) 일반변수 출력은 <=% id%>
    										   => request.setAttribute("id", identity) ==> ${id}
    				
    				
    				3) session 에 들어간 값을 출력할때 : session.getAttribute("name","홍길동") => ${sessionScope.name} =>홍길동으로 출력 
    					=> ${name} 가능하지만 우선순위가request이다!!
    					=> request와 session에 둘다 name키가 있으면 request먼저 가져옴!
    					=> 중복이 안된경우는 상관x => sessionScope생략가능!
    	
    				
    				***request 보내기 / 파일 1개에서 데이터 읽을때 
    				***session 보내기 / 여러 파일에서 데이터를 읽어야할때
    				
    				Java(처리) / Html(JSP(request,response,session etc(내장객체)), SERVLET) 분리!!
    				
    				
    				request => cookie, session 가져오기 가능!
    				call by reference!!
    				
    				4) paramValues() ==> 값이 여러개 들어올때!
    				5) cookie!
    				
    				
    				
    		
    				
     --%>
     
     <%
     
     	String name="홍길동"; //출력x
     	request.setAttribute("name", "홍길동"); //출력ok
     
     	//자바
     	String n=(String)request.getAttribute("name");
     	
     %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	이름 : ${name }
	<%= n %>
</body>
</html>