package com.brunolima.quarkus.entity;

public class State {
	private String code;

	private String name;
	
	@Deprecated
	public State() {
	}

	public State(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getName() {
		return name;
	}

}
