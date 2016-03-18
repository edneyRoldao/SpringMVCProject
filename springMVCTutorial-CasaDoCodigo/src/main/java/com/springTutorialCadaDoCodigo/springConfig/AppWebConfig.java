package com.springTutorialCadaDoCodigo.springConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.springTutorialCadaDoCodigo.controller.HomeController;

/**
 * Nessa classe iremos registrar todos os nossos controllers
 * @author Edney Roldao
 *
 */
@EnableWebMvc // Esse annotation vai dar suporte para conversão de JSon, xml e geração de RSS
@ComponentScan(basePackageClasses = {HomeController.class})
public class AppWebConfig {
	
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

}
