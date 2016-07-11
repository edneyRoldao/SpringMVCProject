package com.springTutorial.enums;

public enum UserData {

	EMAIL(""), PASSWORD(""), USER_ADMIN(""), EMAIL_ADMIN(""), PASS_ADMIN("");
	
	public String value;
	
	UserData(String value) {
		this.value = value;
	}
	
}
