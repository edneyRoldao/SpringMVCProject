package com.springTutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

	// Como esse método trata de um request, ele precisa retornar uma página para exibição. porém, temos que configurar um ViewResolver
	// O spring utiliza um viewResolver para saber qual é o caminho da pagina dentro do projeto.
	@RequestMapping("/controllers")
	public String index() {
		System.out.println("test");
		return "testServletSpring";
	}
	
	// Para utilizar recursos estáticos na nosso aplicacção como, arquivos javascript, css, imagens e outros precisamos 
	// adicionar uma configuração na classe AppWebConfig. Nesse caso estou testando tal configuração.
	@RequestMapping("/recursos")
	public String testUsoRecursosStaticos() {
		return "testUsoDeConteudoEstatico";
	}
	
	
}
