package com.appu.beans;

public class TokenData{

	private final String message;
	
	private String generatedKey;
	
	public TokenData(String message, String generatedKey) {
		super();
		this.message = message;
		this.generatedKey = generatedKey;
	}

	public String getGeneratedKey() {
		return generatedKey;
	}

	public void setGeneratedKey(String generatedKey) {
		this.generatedKey = generatedKey;
	}

	private int id;

	public TokenData(String message,int id) {

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
