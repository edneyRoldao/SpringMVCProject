package com.springTutorialCadaDoCodigo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	// Como esse método trata de um request, ele precisa retornar uma página para exibição. porém, temos que configurar um ViewResolver
	// O spring utiliza um viewResolver para saber qual é o caminho da pagina dentro do projeto.
	@RequestMapping("/index")
	public String index() {
		System.out.println("test");
		return "index";
	}
	
}
