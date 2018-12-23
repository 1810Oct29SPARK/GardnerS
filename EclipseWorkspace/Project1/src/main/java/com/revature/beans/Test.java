package com.revature.beans;

public class Test {

	public String json;
	
	//below are the constructors, no arg and from fields, as well as the getters and setters
	
	@Override
	public String toString() {
		return "Test [json=" + json + "]";
	}
	public void setJson(String json) {
		this.json = json;
	}
	public Test(String json) {
		super();
		this.json = json;
	}
	public String getJson() {
		return json;
	}
	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}

}
