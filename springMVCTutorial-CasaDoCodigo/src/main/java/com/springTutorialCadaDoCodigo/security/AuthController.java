package com.springTutorialCadaDoCodigo.security;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Transactional
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
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/efetivaCadastro", produces = "text/plain;charset=UTF-8")
	public ModelAndView cadastrar(Usuario usuario) {
		
		List<Role> roles = new ArrayList<>();
		String user = "ROLE_USER";
		roles.add(buscarRole(user));

		// Desmarcar para garantir acesso administrador
		// String admin = "ROLE_ADMIN";
		// roles.add(buscarRole(admin));
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String senha = encoder.encode(usuario.getPassword());
		usuario.setPassword(senha);
		
		usuario.setRoles(roles);
		userDAO.cadastrar(usuario);
				
		return new ModelAndView("redirect:/index");
	}

	private Role buscarRole(String name) {
		
		Role role = roleDAO.buscar(name);
		
		if(role.getName().equals("")) {
			role.setName(name);
			roleDAO.cadastrar(role);
		}
		
		return role;
	}
	
	
}
