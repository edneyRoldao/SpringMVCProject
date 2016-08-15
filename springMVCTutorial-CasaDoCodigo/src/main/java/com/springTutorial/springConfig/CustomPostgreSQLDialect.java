package com.springTutorial.springConfig;

import java.sql.Types;

import org.hibernate.dialect.PostgreSQL9Dialect;

public class CustomPostgreSQLDialect extends PostgreSQL9Dialect {

	public CustomPostgreSQLDialect() {
		super();
		registerColumnType(Types.BLOB, "bytea");
	}
	
}
