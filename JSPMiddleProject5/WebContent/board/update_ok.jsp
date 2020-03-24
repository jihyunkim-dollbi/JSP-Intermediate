<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.model.*, com.sist.dao.*"%>

    <%
    
    	BoardModel model= new BoardModel();
    
    	model.boardUpdate(request,response);
    	
    	/*
    	
    		
    
    	//list.jsp에서  클라이언트가 준 값을 String으로 받는다.
    	String no=request.getParameter("no"); //no라는 변수를 받아라
    	String strPage=request.getParameter("page");
    	
    	//dao객체 생성
    	BoardDAO dao=new BoardDAO();
    	
    	//boardDetailData()에 개시물 넘버와 type=1(이전에 db에서 가지고 있던 no,name, subject, content, regdate, hit를 가져온다)을  넣은 BoardVO vo객체를 생성
    	BoardVO vo=dao.boardDetailData(Integer.parseInt(no), 1);
    
    	
    	
    	*/
    	
    
    
    %>
    
  