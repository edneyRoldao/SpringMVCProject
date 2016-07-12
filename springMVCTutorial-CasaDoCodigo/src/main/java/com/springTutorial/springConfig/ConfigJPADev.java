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
 * O profile utilizado como padrao e o de producao "prod", para executar o DataSource desse "dev",
 * precisamos passar o argumento abaixo quando rodamos o jetty pelo maven:
 
 * -Dspring.profiles.active="dev" 
 * (este valor deve ser adicionado no campo VM arguments da aba JRE quando rodamos o server pelo maven)
 * 
 * @author edneyroldao
 *
 */
@Configuration
@Profile("dev")
@EnableTransactionManagement
public class ConfigJPADev {
	
	@Bean
	public PlatformTransactionManager platformTransactionManager(EntityManagerFactory emf) {
		JpaTransactionManager JPAManager = new JpaTransactionManager();
		JPAManager.setEntityManagerFactory(emf);
		
		return JPAManager;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		JpaVendorAdapter vendor = new HibernateJpaVendorAdapter();

		em.setDataSource(dataSource);
		em.setJpaProperties(additionalProperties());
		em.setPackagesToScan(new String[] {"com.springTutorial.model", "com.springTutorial.security"});
		em.setJpaVendorAdapter(vendor);
		
		return em;
	}

	@Bean
	public DataSource dataSource(Environment environment) {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost/spring_mvc_tutorial");
		dataSource.setUsername("root");
		dataSource.setPassword("conam");
		
		return dataSource;
	}
	
	private Properties additionalProperties() {
		Properties props = new Properties();
		props.setProperty("hibernate.hbm2ddl.auto", "update");
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		props.setProperty("hibernate.show_sql", "true");
		return props;
	}
}
