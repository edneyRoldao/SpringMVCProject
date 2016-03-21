package com.springTutorialCadaDoCodigo.springConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.springTutorialCadaDoCodigo.controller.TestController;

/**
 * Nessa classe iremos registrar todos os nossos controllers
 * @author Edney Roldao
 *
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackageClasses = {TestController.class})
public class AppWebConfig extends WebMvcConfigurerAdapter {
	
	/**
	 * Registrando um viewResolver para tratar o caminho das nossos páginas
	 */
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}
	
	/**
	 * 
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").setCachePeriod(0);
	}
	
}
