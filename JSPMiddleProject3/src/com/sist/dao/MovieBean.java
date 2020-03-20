package com.sist.dao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/*
 * MNO      NOT NULL NUMBER(4)      
TITLE    NOT NULL VARCHAR2(1000) 
POSTER   NOT NULL VARCHAR2(2000) 
SCORE             NUMBER(4,2)    
GENRE    NOT NULL VARCHAR2(200)  
REGDATE           VARCHAR2(200)  
TIME              VARCHAR2(50)   
GRADE             VARCHAR2(200)  
DIRECTOR          VARCHAR2(200)  
ACTOR             VARCHAR2(500)  
STORY             CLOB           
TYPE              NUMBER         

 * 
 */
public class MovieBean {

	private int mno;
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
	
}
