package com.springTutorial.springConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.google.common.cache.CacheBuilder;
import com.springTutorial.viewResolver.JsonViewResolver;


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
@EnableCaching
@ComponentScan("com.springTutorial")
public class AppWebConfig extends WebMvcConfigurerAdapter {

	@Bean
	public MailSender mailSender() {
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
		
		// SMTP do google
		javaMailSender.setHost("smtp.gmail.com");
		
		// Senha de acesso ao email que vai enviar o email
		javaMailSender.setPassword("");
		
		// Porta SMTP do google
		javaMailSender.setPort(587);
		
		// email de origin que irá enviar os emails
		javaMailSender.setUsername("");
		
		// Autorizando o envio de email
		Properties mailProperties = new Properties();
		mailProperties.put("mail.smtp.auth", true);
		mailProperties.put("mail.smtp.starttls.enable", true);
		
		javaMailSender.setJavaMailProperties(mailProperties);
		
		return javaMailSender;
	}
	
	@Bean
	public CharacterEncodingFilter characterEncodingFilter() {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		return filter;
	}
	
	/**
	 * ViewResolver que trata do contentNegotiation para a aplicação atender a mais de um formato.
	 */
	@Bean
	public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
		
		List<ViewResolver> resolvers = new ArrayList<>();
		resolvers.add(internalResourceViewResolver());
		resolvers.add(new JsonViewResolver());
		
		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		resolver.setViewResolvers(resolvers);
		resolver.setContentNegotiationManager(manager);
		
		return resolver;
	}
	
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
	public CacheManager cacheManager() {
		
		CacheBuilder<Object, Object> builder = CacheBuilder
			.newBuilder()
			.maximumSize(100)
			.expireAfterAccess(5, TimeUnit.MINUTES);

		GuavaCacheManager cacheManager = new GuavaCacheManager();
		cacheManager.setCacheBuilder(builder);
		
		return cacheManager;
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
