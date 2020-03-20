<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!--  변수선언, 제어문, url 을 사용하기 위한 선언! -->  
  
    <%--
    
    	JSTL => XML로 제작됨! 
    	1. TAG 열고 닫기 항상 유의!
    	2. 지원하는 속성외의 다른 속성을 이요하면 에러가 난다. (ex) var test value items....) 
    	3. 속성값은 반드시 ""를 사용해야한다.
    	ex) <c:set var=i/> ->error=> "i"
    		
    	
    		= core (3가지 기능!)
    			1. 변수선언
    				<c:set> ==> request.setAttribute("id","admin")와 동일!
    				<c:set var="id" value="admin"> 위와 동일
    				
    				EL을 사용해 request,session값을 ${}(html로 값 바로 출력 기능!) 곧바로 출력가능하다!!
    			   =>${id} 로 바로 출력가능!!{} 안에는 ""생략가능! =동일!= request.getAttribute()!    			   
    			   
    			   *** <c:out value="test"> =>동일 out.println()
    			   		=====> 보다 ${} 사용!
    			   
    			2. 제어문 
    				
    				1)
    				<c:if> => else가 존재하지 않는다.
    				
    					if(조건문)
    					{
    						실행문장!
    					}
    					=> <c:if test="조건문"> => 속성이 test!
								실행문장
						   </c:if>    				
    				
    				2)
    				<c:forEach>
    					
    					for(int i=0; i<10;i++)
    					{
    					
    					}
    						=> <c:forEach var="i" begin="1" end="10" step="1"> =이 항상 포함됨!
    														======   =======
    														i<=10     step은 1일 경우에 생략가능!
    						   							**단점: step="-1" =>감소는 불가능!!
    						   </c:forEach>
    						   
    					for(MovieVO vo:list){
    					
    					}
    						var => 자동 변환 변수 list안에 들어간 값에 따라 설정해줌!
    						=> <c:forEach var="vo" items="list">
    						   </c:forEach>
    				
    				3)
    				
    				<c:choose> : 다중 조건문, 선택문!
    				
    					<c:choose>	
    					  <c:when test="조건문">실행문장</c:when> if()
    					  <c:when test="조건문">실행문장</c:when> else if()
    					  <c:when test="조건문">실행문장</c:when> else if()
    					  <c:when test="조건문">실행문장</c:when> else if()
    					  <c:otherwise>실행문장</c:otherwise> default! => else!
    					</c:choose>
    				
    				
    				4)
    				
    				***<c:forTokens var="s" value="red, blue, green" delimt=","> 
    						=> stringTokenizer()
    					</c:forTokens>
    				
    				
    			3. URL
    				
    				<c:redirect url=""> :화면이동 (response.sendRedirect()와 동일!)
    					
    			
    			
    			
    		 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/fmt" %>	
    		= fmt(format) 
    			(날짜(sumpledateformat자바를 대채하기 위해 사용), )
    		
    		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/functions" %>	
    		= fn 
    			1. String, Collection 제어!
    			${fn:title, substring()} => function사용하겠다는 선언을 해야 자바 함수 사용가능!
    		
    		
    		======
    		= sql  ===========> DAO 평소 DAO가 표준!
    		= xml  ===========> Parser (JAXP, JAXB)
    		======사용하지 않는다.
    
    		
    
     --%>
     
     <%
     
     	int sex=1;
     	
     
     %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Java로 코딩을 할 경우</h2>
	<%
		if(sex==1)
		{
	%>
		 남자입니다.
	<%			
			
		}
		else
		{
	%>
		여자입니다.
	<%		
		}
	
	%>
	
	<br>
	<c:set var="sex" value="2"></c:set> <!-- var:키 value:값!"항상" 변수선언 아래와 동일! -->

<%--		
		//request.setAttribute("sex", 2);
--%> 
	

	<h2>JSTL을 이용할 경우</h2>
	<c:if test="${sex==1 }">
	남자입니다
	
	<%-- ==> 사용해야함! // 사용x!!
		c:if
		  	=> test=> 조건문을 작성하는 위치!
	 --%>
	</c:if>
	<c:if test="${sex==2 }">
	여자입니다
	</c:if>	
	
	
</body>
</html>