package com.springTutorialCadaDoCodigo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springTutorialCadaDoCodigo.dao.RoleDAO;
import com.springTutorialCadaDoCodigo.dao.UserDAO;
import com.springTutorialCadaDoCodigo.model.Role;
import com.springTutorialCadaDoCodigo.model.User;

@Controller
public class IndexController {
	
	@Autowired
	RoleDAO roleDAO;
	
	@Autowired
	UserDAO userDAO;


	@RequestMapping("/index")
	public ModelAndView index() {
		return new ModelAndView("index");
	}

	@RequestMapping("/login")
	public ModelAndView loginForm() {
		return new ModelAndView("login");
	}
	
	private void initDatabase() {
		Role roleAdmin = new Role("ROLE_ADMIN");
		Role roleComprador = new Role("ROLE_COMPRADOR");
		//roleDAO.cadastrar(roleAdmin);
		//roleDAO.cadastrar(roleComprador);
		List<Role> roles = new ArrayList<>();
		roles.add(roleAdmin);
		roles.add(roleComprador);
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		User userAdmin = new User();
		userAdmin.setLogin("admin");
		userAdmin.setName("admin");
		userAdmin.setPassword(encoder.encode("admin"));
		userAdmin.setRoles(roles);
		userDAO.cadastrar(userAdmin);
		
		User userComprador = new User();
		userComprador.setLogin("comprador");
		userAdmin.setName("admin");
		userComprador.setPassword(encoder.encode("comprador"));
		List<Role> roles2 = new ArrayList<>();
		roles2.add(roleComprador);
		userComprador.setRoles(roles2);
		userDAO.cadastrar(userComprador);
	}
	
}
