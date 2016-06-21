package com.springTutorialCadaDoCodigo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.springTutorialCadaDoCodigo.model.User;

@Repository
public class UserDAO implements UserDetailsService{
	
	public static final String JPQL = "select u from User u where u.login = :login";

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		List<User> users = em.createQuery(JPQL, User.class).setParameter("login", userName).getResultList();

		if(users.isEmpty())
			throw new UsernameNotFoundException("O usuario " + userName + " não existe");
		
		return users.get(0);
	}
	
	public void cadastrar(User user) {
		em.persist(user);
	}

}
