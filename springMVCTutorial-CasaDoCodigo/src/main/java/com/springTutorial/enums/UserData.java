package com.springTutorial.enums;

public enum UserData {

	EMAIL("edneyroldao@gmail.com"), PASSWORD("minhaSenha"), USER_ADMIN("Edney Roldão"), EMAIL_ADMIN("edneyroldao@yahoo.com.br"), PASS_ADMIN("edney");
	
	public String value;
	
	UserData(String value) {
		this.value = value;
	}
	
}
