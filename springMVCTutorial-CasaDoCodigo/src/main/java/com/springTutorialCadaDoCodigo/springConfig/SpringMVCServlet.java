package com.springTutorialCadaDoCodigo.springConfig;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

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
		return new Class[]{SecurityConfiguration.class};
	}

	/*
	 * Aqui devemos registrar os Controller (classes) que serão gerenciadas pelo
	 * container do spring, ou apontar para uma classe que seja responsável por
	 * isso, que será o nosso caso.
	 * 
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { AppWebConfig.class, JPAConfig.class };
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

}
