package com.springTutorialCadaDoCodigo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.springTutorialCadaDoCodigo.model.Role;

@Repository
public class RoleDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	
	public void cadastrar(Role role) {
		em.persist(role);
	}


}
