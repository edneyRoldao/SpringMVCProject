package com.springTutorialCadaDoCodigo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springTutorialCadaDoCodigo.dao.RoleDAO;
import com.springTutorialCadaDoCodigo.dao.UserDAO;
import com.springTutorialCadaDoCodigo.model.Role;
import com.springTutorialCadaDoCodigo.model.Usuario;

@Controller
@RequestMapping("/usuario")
public class AuthController {
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	RoleDAO roleDAO;
	
	@RequestMapping("/cadastro")
	public ModelAndView formCadastroUsuario(Usuario usuario) {
		return new ModelAndView("cadastro-usuario");
	}
	
	@RequestMapping("/login")
	public ModelAndView logarUsuario() {
		return new ModelAndView("login");
	}
	
	@RequestMapping("/efetivaCadastro")
	public ModelAndView cadastrar(Usuario usuario) {
		
		Role r = new Role();
		r.setName("ADMIN");
		roleDAO.cadastrar(r);
		
		
		return new ModelAndView("redirect:login");
	}

	
	
}
