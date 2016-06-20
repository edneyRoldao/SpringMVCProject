package com.springTutorialCadaDoCodigo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO implements UserDetailsService{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {

		
		
		return null;
	}

}
