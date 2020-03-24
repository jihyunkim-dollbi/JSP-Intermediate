<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.model.*"%>

    <%
    
    	BoardModel model = new BoardModel();
    	
    	//request넘기는 함수 필요 model에서 메소드로 만들러 고고!!
    	//baordModel에서 boardInsert 메소드 만듬!
 
    	model.boardInsert(request, response);
    	
    
    %>