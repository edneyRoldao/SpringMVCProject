package com.springTutorial.enums;

public enum UserData {

	EMAIL("edneyroldao@gmail.com"), PASSWORD("Rem@69378"), USER_ADMIN("Edney Roldão"), EMAIL_ADMIN("edneyroldao@yahoo.com.br"), PASS_ADMIN("edney");
	
	public String value;
	
	UserData(String value) {
		this.value = value;
	}
	
}
