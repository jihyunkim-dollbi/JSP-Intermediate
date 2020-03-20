package com.sist.dao;

import java.sql.Connection;
import java.sql.*;
import java.util.*;



public class MovieDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	
	//드라이버 등록 생성자
	public MovieDAO()
	{
		
		try{
			
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
			
		}
		
		
	}
	
	//연결
	
	public void getConnection()
	{		
		try{
			
			conn=DriverManager.getConnection(URL,"hr", "happy");
			
		}catch(Exception ex)
		{

		}
		
	}
	
	
	//연결 해제
	public void disConnection(){
		
		try{
			
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
			
		}catch(Exception ex) {}
		
	}	
	
	
	
	public int movieTotalPage()
	{
		int total=0;
		try{
			getConnection();
			
			String sql="SELECT CEIL(COUNT(*)/9.0) FROM movie";
		
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			rs.next();
			total=rs.getInt(1);
			rs.close();
			
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		
		}finally
		{
			disConnection();
			
		}
		return total;
		
		
	}
	
	
	//데이터 가져오기
	public List<MovieBean> movieListData(int page)
	{
		List<MovieBean> list=new ArrayList<MovieBean>();
			
		try{
			
			getConnection();
			
			String sql="SELECT mno, poster, title, num "
					+ "FROM (SELECT mno, poster, title, rownum as num "
					+ "FROM (SELECT mno, poster, title "
					+ "FROM movie ORDER BY mno ASC)) "
					+ "WHERE num BETWEEN ? AND ?";
			
			int rowSize=9;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			
			ps=conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, end);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				MovieBean vo=new MovieBean();
				vo.setMno(rs.getInt(1));
				vo.setPoster(rs.getString(2));
				vo.setTitle(rs.getString(3));
				
				list.add(vo);
				
			}rs.close();
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
			
		}finally{
			
			disConnection();
		}
		
		
		return list;
	}
	
	/*
	 * private int mno;
	private String title;
	private String poster;
	private double score;
	private String genre;
	private String regdate;
	private String time;
	private String grade;
	private String director;
	private String actor;
	private String story;
	private int type;
	
	 * 
	 */
	public MovieBean movieDetailData(int mno){
		
		MovieBean vo=new MovieBean();
		
		try{
			
			getConnection();
			
			String sql="SELECT mno, title, poster, score, genre, regdate, time, grade, director, actor, story "
					+ "FROM movie "
					+ "WHERE mno=?";
			
			ps=conn.prepareStatement(sql);
			
			ps.setInt(1, mno);
			
			ResultSet rs=ps.executeQuery();
			
			rs.next();
			
			vo.setMno(rs.getInt(1));
			vo.setTime(rs.getString(2));
			vo.setPoster(rs.getString(3));
			vo.setScore(rs.getDouble(4));
			vo.setGenre(rs.getString(5));
			vo.setRegdate(rs.getString(6));
			vo.setTime(rs.getString(7));
			vo.setGrade(rs.getString(8));
			vo.setDirector(rs.getString(9));
			vo.setActor(rs.getString(10));
			vo.setStory(rs.getString(11));
			
			
			rs.close();
			
			
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
			
		}finally
		{
			disConnection();
			
		}
		
		
		return vo;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
