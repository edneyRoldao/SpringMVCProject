package com.springTutorialCadaDoCodigo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springTutorialCadaDoCodigo.dao.RoleDAO;
import com.springTutorialCadaDoCodigo.dao.UserDAO;
import com.springTutorialCadaDoCodigo.model.Role;
import com.springTutorialCadaDoCodigo.model.Usuario;

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
	
	@RequestMapping("/login")
	public ModelAndView logarUsuario() {
		return new ModelAndView("login");
	}
	
	@RequestMapping("/efetivaCadastro")
	public ModelAndView cadastrar(Usuario usuario) {
		
		List<Role> roles = new ArrayList<>();
		roles.add(buscarRole("ADMIN"));
		roles.add(buscarRole("USUARIO"));
		
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
