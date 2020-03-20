package com.sist.vo;

public class Sawon {

	private int sabun;
	private String name;
	private String dept;
	
	
	public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public Sawon(int sabun, String name, String dept) { //생성자 함수! source-> using field!!
		//jsp안에는 매소드 영역이기 때문에 클래스를 여기서 만듬! 여기에 값을 채워서 jsp에서 출력할 예정!
		//jsp에서 클래스 객체 생성없이 바로  s.name을 사용할 수 있다!
		this.sabun = sabun;
		this.name = name;
		this.dept = dept;
	}
	
	
}
