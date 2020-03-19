<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    <%--
    
    	${연산자}
    	
    	===> 산술 연산자
    			+ , - , * , /(=div) , % (=mod)
    			================== > / ( <%= 10/3 %>) 정수출력   ==> (${3.333}) 실수출력
    	
    			+ : 산술연산 , 문자열 결합
    				"hello"+10 =>hello10	
    					
    			+ : 순수하게 산술만 가능!
    			    "hello"+10 => error
    					
    			자바 : <%= "100" + "10"%>  ==> 10010
    			EL : ${"100"+10}  ==> 100 + 10 =>  110 ==> 문자열을 자동으로 정수형 변환
    				
    				***문자열 결합시 => +=
    				${'hello' += 10} => hello10
    				
    				<%= null+10 %> => error
    				${ null + 10} => null값은 0으로 인식!!
   					 
   					 null => 0    	
   					 
   					 /  => 리턴 실수형!!		
    			
    				스크립트 형식이므로 "" ,'' 모두 문자열로 읽음 => String!
    				var a ="apple" 
    				var b ='pear'
    				
    				${sessionScope.id} => null 예매, 댓글!
    		

					***    		
    				 /(=div) , % (=mod)
    				 
    				 => ${ 5 div 2}
    				 => ${ 5 mod 2}
    			
    			
    		======> 비교연산자 ==> true/false
    		
    		 		== | eq 문자열, 숫자 모두 비교 가능! => ${requestScope.id=='admin'}   |  ${requestScope.id eq 'admin'}
    		 		!= | ne 문자열, 숫자 모두 비교 가능! => ${requestScope.id != 'admin'}   |  ${requestScope.id ne 'admin'}
    		 		<  | lt ${10<5} 
    		 		>  | gt  ${10>5}
    		 		<= | le  ${10<=5}
    		 		>= | ge  ${10>=5}
    		 			
    		======> 논리연산자 ==> true/false
    		
    				&&    |  and    
    				||    |   or    
    				!	  |  not
    			
    			
    			
    			String id;  - >  null
    			String id="";  -> "" 공백
    	 	======> empty 연산자
    	 		
    	 		${empty list} arraylist에 값이 있어? 물음!
    	 			비어있으면 => true 
    			
    			${list.size()} ==> 갖고 있는 함수 사용x => error!
    			
    		
    		=======>  삼항연산자 :  ${조건?값1:값2}	
    		
    		=======>  문자열 결합 연산자 : +=
    	=========================================================================
    		 	
    		JSTL => JSP안에서 <%= %> 사용 X!!
    
     --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%="Hello" %><br>
	${"Hello" }<br>
	<%= "hello" + 10 %><br>
	${"100"+"10" }<br>
	${"Hello" += 10 }<br>
	${"hello" += "java" }<br>
	${null+10 }<br>
</body>
</html>