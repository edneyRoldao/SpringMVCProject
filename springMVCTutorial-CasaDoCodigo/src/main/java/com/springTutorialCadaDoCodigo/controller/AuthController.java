package com.springTutorialCadaDoCodigo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/usuario")
public class AuthController {
	
	@RequestMapping("/cadastro")
	public ModelAndView formCadastroUsuario() {
		return new ModelAndView("cadastro-usuario");
	}
	
	@RequestMapping("/login")
	public ModelAndView logarUsuario() {
		return new ModelAndView("login");
	}
	
}
