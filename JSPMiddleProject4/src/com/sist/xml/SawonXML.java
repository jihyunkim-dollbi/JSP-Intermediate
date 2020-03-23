package com.sist.xml;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
/*
 * XML
 * XML => 데이터 읽기 위한 파일! => 솔루션업체(프로그램을 직접 제작하는 업체- XML사용!) SI/SM(웹? XML만들일X)
 * 
 * 파서(parser)란 컴파일러의 일부로서 원시 프로그램즉, 
 * 컴퍼일러나 인터프리터에서 원시 프로그램을 읽어 들여, 그문장의 구조를 알아내는 구문 분석(parsing)을 행하는 프로그램을 말한다.
 * 
 */
public class SawonXML {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SawonXML xml = new SawonXML();
		xml.xmlParser(); //sawon의 모든 태그 읽음!
		

	}

	public void xmlParser(){
		
		try{
			
			//XML파서기(XML데이터 읽는 것!) 만들기
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); //파서기 만드는 아이
			DocumentBuilder db = dbf.newDocumentBuilder(); //db가 실제 파서기
			
			
			//문서를 저장 => db파서기가 해당경로로 가서 파일을 parse를 함 
			//(해당 경로 읽기 =>sawon.xml의 오른쪽 클릭->property => location 복사후 -> \-> \\로 변경!)
			//parse한 정보를 doc에 저장함! 
			Document doc = db.parse(new File("C:\\webDev\\webStudy\\JSPMiddleProject4\\WebContent\\WEB-INF\\sawon.xml")); //xml파일을 읽어서 doc에 저장!
			
			
			//테이블 읽기 - <sawon> 맨 앞에 있는 tag Element 태그 1개 읽음
			//doc에 있는 정보들중 최상위 tag를 가져온다!
			//getDocumentElement() : 최상위 요소(Root Element) 노드
			Element table = doc.getDocumentElement(); //최상위 태그를 읽는다. 
				
			System.out.println(table.getChildNodes()); // 최상위 tag가 가진 자식 tag들을 가져오나?
			System.out.println(table.getTagName()); // 최상위  tag의 이름을 가져온다 => sawon
			
			//같은 tag를 모아서 for문 고고
			NodeList list=table.getElementsByTagName("list");   //tag 명 list를 모두 모아라! 
			
			/*DOM 문서 저장 형태 ==>  트리 형태로 저장이 된다!(has 계층구조! )
			 * sawon -list - name
			 * 			   - address
			 * 			   -  etc...
			 * 
			 * 		 -list
			 * 		 -list
			 * 
			 * 이 전체를 document라고 한다.!  => doc 객체!
			 * nodelist를 모아서  => list 의 첫번째 값을 가져와라

			 */
				System.out.println(list.getLength());  //tag명 list의 개수는 3개이다! => 3
				
				for(int i=0;i<list.getLength();i++)
				{
					//인덱스 번호로 값 가져옴
					list=table.getElementsByTagName("name"); // name tag읽기
					String name=list.item(i).getFirstChild().getNodeValue(); // name tag의 i번째 첫번째 node의 값 읽기!
					System.out.println("name="+name);
					
					list=table.getElementsByTagName("addr"); // addr tag읽기
					String addr=list.item(i).getFirstChild().getNodeValue(); 
					System.out.println("addr="+addr);
					
					list=table.getElementsByTagName("sex"); // sex tag읽기
					String sex=list.item(i).getFirstChild().getNodeValue(); 
					System.out.println("sex="+sex);
					
				}
				
				
		}catch(Exception ex){
			
			ex.printStackTrace();
		}
		
		
	}
	
	
}
