package com.sist.dao;

import java.util.*;
import java.io.*; //xml읽기위해

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.lf5.util.Resource;
/*	
 * <자바>
 * 
 * 	클래스의 구성요소 : 자바는 클래스 영역에 모두 들어가야한다.
 * =============
 * 	1) 맴버변수
 * 		=인스턴스 : new를 해서 메모리 할당하여 생성됨!
 * 		=정적변수(static-따로 메모리할당x) : JVM이 클래스를 읽었을때 시작 => 생성됨
 * 	2) 메소드
 * 	3) 생성자
 * =============
 * 
 * 필요시에 맴버변수에 대한 초기화가 필요
 * 	초기화 방법
 * 	1)명시적 방법: 직접적으로 값을 넣어주는 방식
 * 
 * 	public class A (클래스 영역!: 선언만 가능, 구현 블가능!)
 * {
 * 	
 * 		int a
 * 		static int b=20;	==> (클래스 영역!: 선언만 가능, 구현 블가능! 메소드 호출x, 제어문x, 연산자 사용이 불가능!)=> 가능하도록 생성자, 초기화블럭 이용하게함!
 * 		===============>외부, 메소드를 이용해서 초기화 불가능
 * 		public int getNumber()
 * 		{
 * 			return 10;
 *		 }
 * }
 * 	
 * 	2)생성자 이용 : 외부에서 파일 읽기, 네트워크 연결, db연결 , xml 파싱=> 생성자 or 초기화블럭 둘중에 하나 이용해 초기화함!
 * 	3)초기화블럭이용
 * 
 * 
 * 	**** 순서
 * 		====
 * 		=> 명시적 방법 => 초기화블럭 => 생성자
 * 					===========
 * 					인스턴스 블록(블럭이 2개?)   ==> 변수가 인스턴스 일때
 * 					public class A{ 
 * 						int a;
 * 
 * 						{
 * 							a=getNumber();
 * 						}
 * 						====---> 인스턴스 => 생성자
 * 
 * 					}
 * 					static 블럭 ==> 변수가 static일때 사용 
 * 					public class A{
 * 
 * 						static int a;
 * 						
 * 						static
 * 						{
 * 							a=getNumber();
 * 						}
 * 
 * 					}
 * 					
 * 					==============================>인스턴스 블록,static 블럭  둘다 자동 호출! 부르지 않아도 호출됨!
 * 
 *  	따라서 static으로 하게 되면 호출하지 않아도 사용 가능함, 따로 메모리 할당 필요x=호출필요x

 * 
 */

public class BoardDAO {

	//파싱하기? /데이터 가져오기?!
	// 시작하자 마자 메소드를 읽어야 파싱가능 => static으로 구현! 
	//가장 먼저 xml을 읽어놓고 시작해야 하기 때문에! xml 파싱작업이 가장 먼저 이루어져야한다.
	private static SqlSessionFactory ssf;
	
	static // what is this?
	{
		//파싱하기 => 하는 이유: getConnection(), disConnection()만들어놓고 시작해야함
		//id, sql문장을 Map에 저장해놓고 시작
		//id를 입력하고 sql문장을 실행 결과를 달라고 해야하기 때문에!
		
		/*
		 * <select id="boardDetailData" resultType="BoardVO" parameterType="int"><!--  *주면 알아서 자동으로 vo에 채워줄 것이다. 더이상set메소드 사용x -->
				SELECT * FROM board
				WHERE no=#{no}
			</select>
		 * 
		 * id를 boardDetailData값만 주면 아래 sql문장을 처리할 것임!
		 * 
		 * config.xml 설정 - 한개 필요
		 * mapper.xml sql문장 - 여러개 필요 -  테이블마다 한개씩 필요! 
		 * id, sql 저장!
		 * 
		 * ==>map에 저장했다가 
		 * (이 과정은 이 프로그램에서 자동으로 해줄 것!)
		 * Map map = new HashMap();'
		   map.put("boardDetailData","SELECT * FROM board WHERE no=#{no}")
		 * 
		 * ==> 필요한 데이터를 가져오는데 이것이...xml로 되어있다.... 
		 * 
		 * 파싱한다는 것은 필요한 데이터를 저장해놓고 시작한다는 의미!

		 */
		try{
			
			//xml파일 읽기
			//현재 config.xml 에 올려놓은 <mapper>가 모든 자료 갖고 있다.
			
			/* <mappers><!-- (mapper*, package*) mapper여러개 등록 가능! --> ==> 파일을 불러와서 저장해 놓는 상태!(따라서 등록만 해놓으면ok!)
	 	 			<mapper resource="com/sist/dao/board-mapper.xml"/>
	 	 			<mapper resource="com/sist/dao/board-mapper.xml"/> 여러개(여러명이 따로 개발) 등록하여.. 여튼 여기에 모두 등록해놓고.
	 	 			...
 	 			</mappers>
 	 			
 	 			따라서 config.xml 한번만 파싱하면 ok!
			 */
			
			Reader reader=Resources.getResourceAsReader("Config.xml"); //우리가 입력한XML파일 모두 가져옴!
			//spring, mybatis ==> classpath를 읽음 => src까지는 자동인식함!! src(자동인식path)에 값이 들어감!
			
			
			//파싱하기
			//id, sql 읽어서 getConnection(), disconnetion()하여,,,데이터 읽기(파싱하기)
			//ssf에 모든 내용 저장하기
			ssf=new SqlSessionFactoryBuilder().build(reader); //알아서 데이터 읽어간다. build메소드 안에 datasource등등 읽을수 있는 기능이 내제됨!
			//빌드까지 끝! 목록읽기로 고고!
			
			
		}catch(Exception ex){
			
			System.out.println(ex.getMessage());
		}

		//실무에서는 myBatis와 Spring을 갖고 업무! + ajax, js, 프론트...etc....
	
	}

	
	//목록읽기
	public static List<BoardVO> boardListData(Map map) //메모리할당 안하려static추가
	{
		List<BoardVO> list=new ArrayList<BoardVO>();
		
		//값채우기
		SqlSession session = ssf.openSession(); //session이란 공간에 모두 채움
		list=session.selectList("boardListData",map);
		//						==============  ====
		//							id값과 매치		parametertype과 매치 되야함!
		// <select id="boardListData" resultType="BoardVO" parameterType="java.util.Map">
		
		
		//connection 반환해야한다
		session.close(); //반환!

		return list;
		
	}
	
	/*
	 * selectList() - 리스트 받기
	 * selectOne() - 클래스 한개 받기 - 리턴형 object!
	 * 
	 * 자동형변환 기능 있음  => 제네릭스 타입이 들어감! object가 형변환 필요x 
	 */
	
	
	//상세보기
	public static BoardVO boardDetailData(int no){//메모리할당 안하려static추가
		
		BoardVO vo=new BoardVO();
		
		SqlSession session=ssf.openSession(); //세션 생성
		
		session.update("hitIncrement",no); 
		//<update> 태그 사용하여 update()사용! insert 사용했으면 insert("id",값) delete("id",값)
		//단 select만 두개!
		/* selectList() - 여러개로 받을때,리스트 받기
		 * selectOne() - 클래스 한개 받기 
		 */
		
		//현재 hit +1 이 되었는데!!
		// 커밋을 안해서 조회수가 증가가 안되었다! .update는 커밋설정이 안되어있다! 
		// 중요한 과정!!!!
		//1.insert, update, delete 사용시 커밋을 처리해줘야함!!
		//2. connection pool이기 때문에 반환작업을 해줘야한다!!
		
		session.commit();
		
		
		vo=session.selectOne("boardDetailData", no); // 데이터 가져오고
		
		//connection 반환해야한다. 8개의 커넥션을 그때그때 사용하고 반환을 해놓아야한다. 커넥션을 다 쓰면 동작x , 커넥션은 세션안에 들어가 있기 때문에 session에서 close()!!
		session.close(); //반환!
		/*
		 * 아래와 같은 작업!
		 * if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		 */
		return vo; //데이터 리턴!
		
	}
	
	
	//총페이지 구하기
	public static int boardTotalPage()
	{
		
		int total=0;
		
		SqlSession session = ssf.openSession();
		total=session.selectOne("boardTotalPage");
		
		
		//connection 반환해야한다
		session.close(); //반환!
		
		return total;
		
	}
	
	
	//insert 데이터 받아와서 넣어주기
	public static void boardInsert(BoardVO vo)
	{
		SqlSession session=ssf.openSession(true); // or setAutoCommit(true)
		session.insert("boardInsert",vo);
		session.close();
		
		//boardmodel에서 불러들임 고고1!
		
		
	}
	
	
	
	public static BoardVO boardUpdateData(int no){//메모리할당 안하려static추가
		
		BoardVO vo=new BoardVO();
		
		SqlSession session=ssf.openSession(); //세션 생성
		
		
		vo=session.selectOne("boardDetailData", no); // 데이터 가져오고
		
		session.close(); //반환!
		
		return vo; //데이터 리턴!
		
	}
	
	
	
	public static void boardUpdate(BoardVO vo)
	
	{
		
				
		SqlSession session=ssf.openSession(true); // setAutoCommit(true)

		session.update("boardUpdate",vo);
		
		session.close(); //반환!
				
	}
	
	
	
}
