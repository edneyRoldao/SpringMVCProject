package com.springTutorial.springConfig;

import java.net.URI;
import java.net.URISyntaxException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Profile("prod")
public class ConfigJPAProducao {
	
	@Autowired
	private Environment environment;
	
	@Bean
	public DataSource dataSource() throws URISyntaxException {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		URI dbURL = new URI(environment.getProperty("DATABASE_URL"));
		dataSource.setUrl("jdbc:postgresql://" + dbURL.getHost() + ":" + dbURL.getPort() + dbURL.getPath());
		dataSource.setUsername(dbURL.getUserInfo().split(":")[0]);
		dataSource.setPassword(dbURL.getUserInfo().split(":")[1]);
		
		return dataSource;
	}
	
}