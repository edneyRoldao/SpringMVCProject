package com.springTutorialCadaDoCodigo.springConfig;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


/**
 * Nessa classe iremos registrar todos os nossos controllers e classe que serão
 * gerenciadas pelo container do Spring.
 * 
 * URL de acesso: http://localhost:8080/springTutorialCasaDoCodigo/
 * 
 * @author Edney Roldao
 *
 */
@EnableWebMvc
@Configuration
@ComponentScan("com.springTutorialCadaDoCodigo")
public class AppWebConfig extends WebMvcConfigurerAdapter {
	
	/**
	 * Registrando um viewResolver para tratar o caminho das nossos páginas
	 */
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		//Essa linha libera o acesso a todos os objetos do context por meio de expression language.
		resolver.setExposeContextBeansAsAttributes(true);
		
		//podemos expor apenas os objetos que precisamos acessar
		//resolver.setExposedContextBeanNames("nomeDaBean"); - nessa caso a bean seria carrinhoDeCompra
		
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
	
	/**
	 * Registrando o Objeto RestTemplate disponibilizado pelo proprio Spring
	 * @return Objeto que trata as requisicoes restfull
	 */
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public FormattingConversionService mvcConversionService() {
		
		DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService(true);
		DateFormatterRegistrar registrar = new DateFormatterRegistrar();
		
		registrar.setFormatter(new DateFormatter("dd/MM/yyyy"));
		registrar.registerFormatters(conversionService);
		
		return conversionService;
	}
	
	@Bean
	public MultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}
	
}
