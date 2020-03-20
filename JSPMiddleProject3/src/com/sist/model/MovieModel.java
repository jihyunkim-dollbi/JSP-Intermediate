package com.sist.model;
/*
 * 
 * jsp한개에 한개의 request를 갖고 있다.
 * 
 * 여러 페이지를 만들경우 여러 request를 사용하게 되므로 충돌위험과 속도가 늘어날수도 있다.
 * 
 * 따라서 한개의 request를 만들어 공유하는 시스템으로! ==> request관리! controller!
 * request를 관리하는 곳을 여러 곳으로 나누어 분산처리!
 * mvc4.0 => domain model 5.0으로 !
 * 
 * 처리는  1개가 끝나고 다음 한개를 처리! (but, 쓰레드는 여러 클라이언트가 동시수행하도록)
 * 
 */
import com.sist.dao.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class MovieModel {   
	
	public void movieListData(HttpServletRequest request)
	{
		
		// 기존에 jsp파일 위에 java소스를  분리 
		// 모델 메소드(매개변수 request) 안에 넣어서 request를 공유할 예정!!
		// 메소드를 통해서 request를 전달!
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		
		int curpage=Integer.parseInt(page);
		
		MovieDAO dao= new MovieDAO();
		List<MovieBean> list= dao.movieListData(curpage);
		
		int totalpage=dao.movieTotalPage();
		
		//값이 넘어갈때 키가 동일하다면 request가 우선순위!!
		request.setAttribute("list", list);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		
		//request와 session을 모두 갖고 있어서 session으로 보내도 된다! request와 키가 충돌 안된다면  
		HttpSession session=request.getSession();
		session.setAttribute("list", list);
		session.setAttribute("curpage", curpage);
		session.setAttribute("totalpage", totalpage);
		
		
		
		//리턴형 없이 request에  여러 값를 담아서 보내주는 메소드!
		
	}

		
	public void movieDetailData(HttpServletRequest request){
		
		//detail.jsp로 값을 보낼 예정! 상세보기
		
		
		String mno=request.getParameter("mno");
		MovieDAO dao= new MovieDAO();
		MovieBean vo=dao.movieDetailData(Integer.parseInt(mno));
		
		
		request.setAttribute("vo", vo);
	
		
		
	}
	
	
	
	
	
	
	
	
}
