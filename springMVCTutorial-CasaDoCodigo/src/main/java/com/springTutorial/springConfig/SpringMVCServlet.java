package com.springTutorial.springConfig;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.core.env.AbstractEnvironment;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.springTutorial.security.SpringSecurityAuthConfig;

/**
 * Registrando a Servlet padrão do spring. (Esse classe substitui configurações
 * no arquivo web.xml)
 * 
 * @author Edney Roldao
 *
 */
public class SpringMVCServlet extends AbstractAnnotationConfigDispatcherServletInitializer {

	private static final String[] URL_MAPPING = { "/", "*.html", "*.htm", "*.json", "*.xml" };

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{AppWebConfig.class, ConfigJPADesenvolvimento.class, ConfigJPAProducao.class, SpringSecurityAuthConfig.class};
	}

	/*
	 * Aqui devemos registrar os Controller (classes) que serão gerenciadas pelo
	 * container do spring, ou apontar para uma classe que seja responsável por
	 * isso, que será o nosso caso.
	 * 
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {};
	}

	// Aqui estamos mapeando a servlet do Spring de forma programática (sem xml)
	@Override
	protected String[] getServletMappings() {
		return URL_MAPPING;
	}

	@Override
	protected void customizeRegistration(Dynamic registration) {
		registration.setMultipartConfig(new MultipartConfigElement(""));
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
		servletContext.addListener(RequestContextListener.class);
		servletContext.setInitParameter(AbstractEnvironment.DEFAULT_PROFILES_PROPERTY_NAME, "prod");
	}
	
}
