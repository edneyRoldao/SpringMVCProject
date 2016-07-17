package com.springTutorial.enums;

public enum UserData {

	EMAIL(""), PASSWORD("");
	
	public String value;
	
	UserData(String value) {
		this.value = value;
	}
	
}
