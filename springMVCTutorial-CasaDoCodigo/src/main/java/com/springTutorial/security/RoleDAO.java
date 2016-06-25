package com.springTutorial.security;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class RoleDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	
	public void cadastrar(Role role) {
		em.persist(role);
	}
	
	public Role buscar(String name) {
		String query = "select r from Role r where r.name = :name";
		List<Role> roles = em.createQuery(query, Role.class).setParameter("name", name).getResultList();
		
		if(roles.isEmpty()) {
			Role role = new Role();
			role.setName("");
			return role;
		}
		
		return roles.get(0);
	}


}
