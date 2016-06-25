package com.springTutorial.viewResolver;

import java.util.Locale;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

public class JsonViewResolver implements ViewResolver{

	/*
	 	Para saber mais sobre contentNegotiation com Spring e Jackson, acesse:
	 		http://spring.io/blog/2013/06/03/content-negotiation-using-views/
	 * */
	
	@Override
	public View resolveViewName(String viewName, Locale locale) throws Exception {
		MappingJackson2JsonView view = new MappingJackson2JsonView();
		view.setPrettyPrint(true);
		
		return view;
	}

}
