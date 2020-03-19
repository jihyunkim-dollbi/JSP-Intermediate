package com.sist.model;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

import java.util.*;

public class SawonModel {

	public void sawonListData(HttpServletRequest request)
	{
		List<String> list= new ArrayList<String>();
		
		list.add("심청이");
		list.add("홍길동");
		list.add("박문수");
		
		request.setAttribute("list", list);
	}
	
	
}
