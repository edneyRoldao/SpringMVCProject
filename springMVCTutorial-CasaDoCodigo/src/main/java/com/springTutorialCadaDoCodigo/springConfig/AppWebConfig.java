package com.springTutorialCadaDoCodigo.springConfig;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.springTutorialCadaDoCodigo.controller.IndexController;
import com.springTutorialCadaDoCodigo.controller.ProdutoController;
import com.springTutorialCadaDoCodigo.controller.TestController;
import com.springTutorialCadaDoCodigo.dao.ProdutoDAO;

/**
 * Nessa classe iremos registrar todos os nossos controllers e classe que serão
 * gerenciadas pelo container do Spring.
 * 
 * @author Edney Roldao
 *
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackageClasses = {TestController.class, IndexController.class, ProdutoController.class, ProdutoDAO.class})
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
	 * Aqui estamos avisando para o Spring que precisamos ter acesso a conteúdos estáticos
	 * como arquivos js, css e img.
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").setCachePeriod(0);
	}
	
	@Bean(name = "messageSource")
	public MessageSource carregarMensagensDeErroPeloContextoDoString() {
		
		ReloadableResourceBundleMessageSource bundle = new ReloadableResourceBundleMessageSource();
		bundle.setBasename("/WEB-INF/messages");
		bundle.setDefaultEncoding("UTF-8");
		bundle.setCacheSeconds(1);
		
		return bundle;
	}
	
}
