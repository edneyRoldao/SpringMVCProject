package com.springTutorialCadaDoCodigo.springConfig;

import java.util.Properties;

import javax.sql.DataSource;
import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
public class JPAConfig {
	
	@Bean
	public PlatformTransactionManager getPlatformTransactionManager(EntityManagerFactory emf) {
		JpaTransactionManager JPAManager = new JpaTransactionManager();
		JPAManager.setEntityManagerFactory(emf);
		
		return JPAManager;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		JpaVendorAdapter vendor = new HibernateJpaVendorAdapter();

		em.setDataSource(getDataSource());
		em.setJpaProperties(getAdditionalProperties());
		em.setPackagesToScan(new String[] {"com.springTutorialCadaDoCodigo.model", "com.springTutorialCadaDoCodigo.security"});
		em.setJpaVendorAdapter(vendor);
		
		return em;
	}

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		
		dmds.setDriverClassName("com.mysql.jdbc.Driver");
		dmds.setUrl("jdbc:mysql://localhost/spring_mvc_tutorial");
		dmds.setUsername("root");
		dmds.setPassword("conam");
		
		return dmds;
	}
	
	private Properties getAdditionalProperties() {
		Properties props = new Properties();
		
		props.setProperty("hibernate.hbm2ddl.auto", "update");
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		props.setProperty("hibernate.show_sql", "true");
		
		return props;
	}
}
