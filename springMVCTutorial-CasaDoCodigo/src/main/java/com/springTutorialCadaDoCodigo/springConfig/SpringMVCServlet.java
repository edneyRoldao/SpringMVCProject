package com.springTutorialCadaDoCodigo.springConfig;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Registrando a Servlet padrão do spring. (Esse classe substitui configurações no arquivo web.xml)
 * @author Edney Roldao
 *
 */
public class SpringMVCServlet extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	/* 
	 * Aqui devemos registrar os Controller (classes) que serão gerenciadas pelo container do spring, 
	 * ou apontar para uma classe que seja responsável por isso, que será o nosso caso.
	 * 
	 * */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {AppWebConfig.class};
	}

	// Aqui estamos mapeando a servlet do Spring de forma programática (sem xml)
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
