package com.springTutorialCadaDoCodigo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.springTutorialCadaDoCodigo.model.Usuario;

@Repository
public class UserDAO implements UserDetailsService {

	@PersistenceContext
	private EntityManager em;
	
	
	public void cadastrar(Usuario user) {
		em.persist(user);
	}

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		
		String query = "select u from Usuario u where u.login = :login";
		List<Usuario> users = em.createQuery(query, Usuario.class).setParameter("login", login).getResultList();
		
		if(users.isEmpty())
			throw new UsernameNotFoundException("O usuario " + login + " nao existe");
		
		return users.get(0);
	}
	
}