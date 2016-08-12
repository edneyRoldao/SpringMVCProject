package com.springTutorial.springConfig;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

import javax.sql.DataSource;
import javax.persistence.EntityManagerFactory;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Profile("prod")
@EnableTransactionManagement
public class ConfigJPAProd {
	
	@Bean
	public PlatformTransactionManager platformTransactionManager(EntityManagerFactory emf) {
	
		JpaTransactionManager JPAManager = new JpaTransactionManager();
		JPAManager.setEntityManagerFactory(emf);
		
		return JPAManager;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		
		JpaVendorAdapter vendor = new HibernateJpaVendorAdapter();
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

		em.setDataSource(dataSource);
		em.setJpaVendorAdapter(vendor);
		em.setJpaProperties(additionalProperties());
		em.setPackagesToScan(new String[] {"com.springTutorial.model", "com.springTutorial.security"});
		
		return em;
	}

	@Bean
	public BasicDataSource dataSource() throws URISyntaxException {
		
		URI dbUri = new URI(System.getenv("DATABASE_URL"));
		BasicDataSource dataSource = new BasicDataSource();
		
		String driver = "org.postgresql.Driver";
		String username = dbUri.getUserInfo().split(":")[0];
		String password = dbUri.getUserInfo().split(":")[1];
		String url = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath(); 
		
		dataSource.setUrl(url);
		dataSource.setPassword(password);
		dataSource.setUsername(username);
		dataSource.setDriverClassName(driver);
		
		return dataSource;
	}
	
	private Properties additionalProperties() {
		
		Properties props = new Properties();
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.hbm2ddl.auto", "create");
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");			
		
		return props;
	}
}
