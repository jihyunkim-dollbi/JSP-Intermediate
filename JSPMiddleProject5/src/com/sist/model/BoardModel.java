package com.sist.model;

//자바코딩은 boardModel에서 메소드형식만 만들어서 메소드를 호출하여 req,res값을 JSP에 넘겨받고 주고 받게끔만 만들어주고 
//실제 sql문장으로 insert,select, update 를 명령/db작업하는 부분은 board-mapper에서 한다! 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;
import com.sist.dao.*;
/*
 * mvc구조 -  확장성 용이!!
 * page 543
 * 이전에 <%  %> 하여 코딩했던 부분이 여기 model이다!
 * 1. java & html분리!
 * 2. 필요할때 상속받아 재정의 가능하게
 * 3. 소스의 보안처리 (jsp는 모두 오플소스이기때문에!!)
 * 
 * get/post
 * session/cookie
 * 모델1 & 모델2(mvc구조!!)
 * 
 * 매jsp마다 위에 코딩하던 부분(값 받기 -  자동호출=> annotation?을 배우게 될 예정!) 밑에 public으로 빼줌 모두 만들어주기!!
 * 값을 채우고 넘겨주는 작업은 이제 모두 java에서! 
 * 
 */

public class BoardModel {

	public void boardListData(HttpServletRequest request)
	{
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		
		int curpage=Integer.parseInt(page);
		//자바는 자바대로 html은html대로
		
		int rowSize=10;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		
		Map map=new HashMap();
		
		map.put("start", start);
		map.put("end", end);
		
		//데이터 가져오기
		List<BoardVO> list=BoardDAO.boardListData(map);
		
		//총페이지 가져오기 =>board-mapper.xml에서 작성 고고!
		int totalpage=BoardDAO.boardTotalPage();
		
		
		//jsp로 결과값 전송
		//3개 
		// jsp는 받은 값을 출력만 하는 기능!
		request.setAttribute("list", list);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);


	}
	
	
	public void boardDetailData(HttpServletRequest request)
	{
		String no=request.getParameter("no");
		
		BoardVO vo=BoardDAO.boardDetailData(Integer.parseInt(no));
		
		//detail.jsp전송 vo를 넘겨줌!
		request.setAttribute("vo", vo);
		
		
	}
	
	
	
	public void boardInsert(HttpServletRequest request, HttpServletResponse response)
	{
		//response =>화면이동때문에 필요!! 
		//화면 이동시 response 항상 필요!!
		
		/* 
		 * ***BoardDAO
		 * ***BoardModel
		 * 
		 * list.jsp boardListData(req)
		 * detail.jsp boardDetailData(req)
		 * insert.jsp 에서 모양폼(아직 어떤 것도 처리할게 없음 아직 입력x)을 일단 띄워주고 insert_ok.jsp를 거쳐서(글쓰기 완료 눌렀을때 여기로 넘어감) boardInsert(req,res)를 이용해야한다.
		 * insert_ok.jsp ==> 결국 여기서 받은 값을 여기에 boardInsert(req,res) 넣어주면 처리됨!!!
		 * 
		 * 
		 * 따라서 입력창/화면 에서는 db작업을 할 필요x 
		 * 입력창/화면창_ok.jsp에서 db작업!
		 * 
		 * 
		 * 
		 */
		try{
		
		response.sendRedirect("list.jsp");  // list 페이지로 이동!!
		//에러난다 try~ catch 해줘야
		//sendRedirect가 io exception을 갖고 있기 때문에.
		
		// 이 작업 후 ==> board-mapper에서 sql문장 insert작업하러 고고!!
		
		}catch(Exception ex) {}
		
		
	}
	
	
	
}
