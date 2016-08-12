package com.springTutorial.springConfig;

import java.util.Properties;

import javax.sql.DataSource;
import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 	Datasource criado para tester o postgres que é o banco em produção
 	
 * -Dspring.profiles.active="postgres" 
 * (este valor deve ser adicionado no campo VM arguments da aba JRE quando rodamos o server pelo maven)
 * 
 * @author edneyroldao
 *
 */
@Configuration
@Profile("postgres")
@EnableTransactionManagement
public class ConfigJPAPostgres {
	
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
	public DataSource dataSource(Environment environment) {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();		
		dataSource.setUsername("conam");
		dataSource.setPassword("conam");		
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/spring_mvc_tutorial");
		
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
