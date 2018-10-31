package com.appu.beans;

public class Token extends UserDetails{

	private final String message;
	
	private int id;

	public Token(String message,int id) {

		super();

		this.message = message;
		this.id=id;

	}

	public String getMessage() {

		return message;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
